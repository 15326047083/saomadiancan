package com.ambow.springboot.controller;

import com.ambow.springboot.entity.Discuss;
import com.ambow.springboot.service.DiscussService;
import com.ambow.springboot.util.Page;
import com.ambow.springboot.vo.DiscussReplyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/discuss")
public class DiscussController {

    @Autowired
    private DiscussService discussService;
    /**
     * 添加评论信息
     */
    @RequestMapping(value = "/saveDiscuss")
    public int saveDiscuss(Discuss discuss){
         return  discussService.saveDiscuss(discuss);
    }
    /**
     * 添加回复信息
     */
    @RequestMapping(value = "/saveReply")
    public int saveReply(Discuss discuss){
         return discussService.saveReply(discuss);
    }
    /**
     * 查看所有留言
     */
    @RequestMapping("/DiscussList")
    @ResponseBody
    public Page<DiscussReplyVo> DiscussList(@RequestParam(defaultValue = "1") Integer page,
                                            @RequestParam(defaultValue = "4")Integer rows){
        Page<DiscussReplyVo> DiscussList =discussService.DiscussList(page, rows);
        Discuss discuss =new Discuss();
        Date date=new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        for (DiscussReplyVo Discusslist:DiscussList.getRows()){
            String s=(new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").format(Discusslist.getDiscussTime()));
            try {
                date = format.parse(s);
                discuss.setDiscussTime(date);
            } catch (Exception e) {
            }
        }
        return DiscussList;
    }
}