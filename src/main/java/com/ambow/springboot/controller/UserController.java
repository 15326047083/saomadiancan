


package com.ambow.springboot.controller;

import com.ambow.springboot.entity.User;

import com.ambow.springboot.service.UserService;
import com.ambow.springboot.util.MD5Util;
import com.ambow.springboot.util.Page;
import com.ambow.springboot.util.SendMessage;
import org.apache.commons.httpclient.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;

@Controller
@RequestMapping("/login")
public class UserController {
    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("/getMyUserInfo")
    public User getMyUserInfo(HttpServletRequest request) {
        return (User) request.getSession().getAttribute("user");
    }

    /*
     * 短信验证码登录
     * */
    @ResponseBody
    @RequestMapping(value = "/sendmelogin", method = RequestMethod.GET)
    public String sendmes(@RequestParam("phone") String phone,
                          HttpServletRequest request) throws HttpException,
            IOException {
        HashMap<String, String> m = SendMessage.getMessageStatus(phone);
        String result = m.get("result");
        if (result.trim().equals("1")) {//手机号已注册发送验证码

            HttpSession session = request.getSession();
            String code = m.get("code");//获取验证码
            session.setAttribute("code", code);//验证码存session
            session.setAttribute("phone", phone);//验证码存session
            session.setMaxInactiveInterval(60 * 3);//设置短信有效时间

            return "success";
        } else {
            //手机号未注册提醒注册
            return "false";
        }
    }

    @ResponseBody
    @RequestMapping(value = "/comparecodelogin")
    public String comparecodelogin(@RequestParam(value = "code") String code,
                                   @RequestParam(value = "phone") String phone, HttpServletRequest request) {
        User user = new User();
        HttpSession session = request.getSession();
        String sessioncode = (String) session.getAttribute("code");//取session里手机号与code验证码
        String sessionPhone = (String) session.getAttribute("phone");//取session里手机号与code验证码
        user.setPhone(sessionPhone);
        if ((code).equals(sessioncode) && (phone).equals(sessionPhone)) {//用户输入的code与session里相比较
            User users = userService.login(user);
            if (users != null) {
                session.setAttribute("user", users);//登录session
                return "success";
            }
            return "error";
        }
        return "error";
    }

    /*
     * 短信验证注册
     * */
    @ResponseBody
    @RequestMapping(value = "/sendme", method = RequestMethod.GET)
    public String sendme(@RequestParam("phone") String phone,
                         HttpServletRequest request) throws HttpException,
            IOException {
        User user = new User();
        user.setPhone(phone);
        if (userService.listphone(user)) {
            return "error";
        } else {
            HashMap<String, String> m = SendMessage.getMessageStatus(phone);
            String code = m.get("code");
            HttpSession session = request.getSession();
            session.setAttribute("code", code);//验证码存session
            session.setAttribute("phone", phone);//手机号存session
            session.setMaxInactiveInterval(60 * 3);
            return "success";
        }
    }

    @ResponseBody
    @RequestMapping(value = "/comparecode", method = RequestMethod.POST)
    public String comparecode(@RequestParam(value = "code") String code,
                              User user, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String sessionCode = (String) session.getAttribute("code");//取session里手机号与code验证码
        String sessionPhone = (String) session.getAttribute("phone");//取session里手机号与code验证码
        if ((code).equals(sessionCode) && (user.getPhone()).equals(sessionPhone)) {//用户输入的code与session里相比较
            user.setIntegral(0);
            userService.insert(user);
            User users = userService.login(user);
            if (users != null) {
                session.setAttribute("user", users);//登录session
                return "success";
            }
            return "error";
        }
        return "error";
    }

    /*
     * 注销
     * */
    @ResponseBody
    @RequestMapping(value = "/zhuxiao")
    public String zhuxiao(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        return "SUCCESS";
    }

    /*查询所有用户*/
    @ResponseBody
    @RequestMapping(value = "/listUser")
    public Page<User> Listuser(@RequestParam(name = "page", defaultValue = "1") Integer page,
                               @RequestParam(defaultValue = "4") Integer rows) {
        Page<User> listuser = userService.lsituser(page, rows);
        return listuser;
    }

    @ResponseBody
    @RequestMapping("/getUser")
    public User getUser(HttpServletRequest request) {
        return (User) request.getSession().getAttribute("user");
    }
}

