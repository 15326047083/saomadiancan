



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
    /*
     * 短信验证码登录
     * */
    @ResponseBody
    @RequestMapping(value = "/sendmelogin", method = RequestMethod.GET)
    public String sendmes(User user,@RequestParam("phone") String phone,
                          HttpServletRequest request) throws HttpException,
            IOException {
        if (userService.listphone(user)) {
            HashMap<String, String> m = SendMessage.getMessageStatus(phone);
            String result = m.get("result");
            if (result.trim().equals("1")) {//手机号已注册发送验证码

                HttpSession session=request.getSession();
                String code = m.get("code");//获取验证码
                session.setAttribute(phone + "code", code);//验证码存session
                session.setMaxInactiveInterval(60 * 3);//设置短信有效时间
                return "success";
            } else {
                //手机号未注册提醒注册
                return "false";
            }

        }
        return "";
    }

    @ResponseBody
    @RequestMapping(value = "/comparecodelogin.action", method = RequestMethod.POST)
    public String  comparecodelogin(@RequestParam(value = "code") String code,
                                    User user, HttpServletRequest request) {
        user.setPassword(MD5Util.MD5( user.getPassword()));//MD5加密密码
        HttpSession session = request.getSession();
        String sessioncode = (String) session.getAttribute(user.getPhone()
                + "code");//取session里手机号与code验证码
        System.out.println(sessioncode);
        if ((code).equals(sessioncode)) {//用户输入的code与session里相比较
            User users=userService.login(user);
            if (users!=null){
                session.setAttribute("user","users");//登录session
            }
        }
        return "";
    }
    /*
     * 短信验证注册
     * */
    @ResponseBody
    @RequestMapping(value = "/sendme", method = RequestMethod.GET)
    public ModelAndView sendme(User user,@RequestParam("phone") String phone,
                               HttpServletRequest request) throws HttpException,
            IOException {

        ModelAndView model = new ModelAndView();
        if (userService.listphone(user)) {
            HashMap<String, String> m = SendMessage.getMessageStatus(phone);
            String result = m.get("result");
            if (result.trim().equals("1")) {//未注册发送验证码
                String code = m.get("code");
                HttpSession session = request.getSession();
                session.setAttribute(phone + "code", code);
                session.setMaxInactiveInterval(60 * 3);
            } else {
            }
            model.addObject("phone", phone);
            model.setViewName("index");
        } else {
            model.addObject("phone", phone);
            model.setViewName("index");
        }
        return model;

    }

    @ResponseBody
    @RequestMapping(value = "/comparecode.action", method = RequestMethod.POST)
    public ModelAndView comparecode(@RequestParam(value = "code") String code,
                                    User user, HttpServletRequest request) {
        user.setPassword(MD5Util.MD5( user.getPassword()));
        ModelAndView model = new ModelAndView();
        HttpSession session = request.getSession();
        String sessioncode = (String) session.getAttribute(user.getPhone()
                + "code");
        System.out.println(sessioncode);
        if ((code).equals(sessioncode)) {
            userService.insert(user);
        } else {
            model.setViewName("index");
        }
        model.setViewName("result");

        return model;
    }
    /*
     * 注销
     * */
    @ResponseBody
    @RequestMapping(value = "/zhuxiao")
    public String  zhuxiao( HttpServletRequest request){
        HttpSession session=request.getSession();
        session.removeAttribute("user");
        return "SUCCESS";
    }
    /*查询所有用户*/
    @ResponseBody
    @RequestMapping(value="/listUser")
    public Page<User> Listuser(@RequestParam(name = "page", defaultValue = "1") Integer page,
                               @RequestParam(defaultValue = "4") Integer rows){
        Page<User> listuser=userService.lsituser(page,rows);
        return listuser;
    }
}

