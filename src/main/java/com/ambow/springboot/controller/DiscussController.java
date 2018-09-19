package com.ambow.springboot.controller;

import com.ambow.springboot.entity.Discuss;
import com.ambow.springboot.service.DiscussService;
import com.ambow.springboot.util.Page;
import com.ambow.springboot.vo.DiscussReplyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/discuss")
public class DiscussController {

    @Autowired
    private DiscussService discussService;

    public Cookie getCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        Cookie order_numberCookie = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("order_numberCookie".equals(cookie.getName())) { //获取购物车cookie
                    order_numberCookie = cookie;
                }
            }
        }
        return order_numberCookie;
    }

    /**
     * 添加评论信息
     */
    @RequestMapping(value = "/saveDiscuss", method = RequestMethod.POST)
    public String saveDiscuss(Discuss discuss, HttpServletResponse response, HttpServletRequest request) {
        if (discuss.getInfo().length() < 1)
            return "error";
        else {
            discussService.saveDiscuss(discuss);

            Cookie cookie = getCookie(request);
            if (cookie != null) {
                // 设置寿命为0秒
                cookie.setMaxAge(0);
                // 设置路径
                cookie.setPath("/");
                // 设置cookie的value为null
                cookie.setValue(null);
                // 更新cookie
                response.addCookie(cookie);
            }
            return "success";
        }
    }

    /**
     * 添加回复信息
     */
    @RequestMapping(value = "/saveReply", method = RequestMethod.POST)
    public void saveReply(Discuss discuss) {
        discussService.saveReply(discuss);
    }

    /**
     * 查看所有留言
     */
    @RequestMapping("/DiscussList")
    public Page<DiscussReplyVo> DiscussList(@RequestParam(name = "page", defaultValue = "1") Integer page,
                                            @RequestParam(defaultValue = "4") Integer rows) {
        Page<DiscussReplyVo> DiscussList = discussService.DiscussList(page, rows);
        Discuss discuss = new Discuss();
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        for (DiscussReplyVo Discusslist : DiscussList.getRows()) {
            String s = (new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").format(Discusslist.getDiscussTime()));
            try {
                date = format.parse(s);
                discuss.setDiscussTime(date);
            } catch (Exception e) {
            }
        }
        return DiscussList;
    }

    /**
     * 查看所有留言 不分页
     */
    @RequestMapping("/DiscussListNoPage")

    public List<DiscussReplyVo> DiscussList() {
        List<DiscussReplyVo> DiscussList = discussService.DiscussListNoPage();
        Discuss discuss = new Discuss();
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        for (DiscussReplyVo Discusslist : DiscussList) {
            String s = (new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").format(Discusslist.getDiscussTime()));
            try {
                date = format.parse(s);
                discuss.setDiscussTime(date);
            } catch (Exception e) {
            }
        }
        return DiscussList;
    }
}