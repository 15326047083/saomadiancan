package com.ambow.springboot.controller;

import com.ambow.springboot.entity.User;

import com.ambow.springboot.service.UserService;
import com.ambow.springboot.util.MD5Util;
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
    * 登录
    * */
    @ResponseBody
    @RequestMapping("/tologin")
    public  String  login(User user, HttpServletRequest request){
        user.setPassword(MD5Util.MD5( user.getPassword()));
        HttpSession session=request.getSession();
        User users=userService.login(user);
        if (users!=null){
            session.setAttribute("user","users");
        return "SUCCESS";
        }
        return "";
    }
    /*
     * 短信验证注册
     * */
    @ResponseBody
    @RequestMapping(value = "/sendme", method = RequestMethod.GET)
    public ModelAndView sendme(User user,@RequestParam("phone") String phone,
                               HttpServletRequest request) throws HttpException, IOException {

        ModelAndView model = new ModelAndView();
        if (userService.listphone(user)) {
            HashMap<String, String> m = SendMessage.getMessageStatus(phone);
            String result = m.get("result");
            if (result.trim().equals("1")) {
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
}
