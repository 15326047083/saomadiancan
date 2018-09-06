package com.ambow.springboot.service;

import com.ambow.springboot.entity.Discuss;
import com.ambow.springboot.util.Page;
import com.ambow.springboot.vo.DiscussReplyVo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public interface DiscussService{
    /**
     * 添加评论
     */
    int saveDiscuss(Discuss discuss);
    /**
     * 添加回复
     */
    int saveReply(Discuss discuss);
    /**
     * 查看所有评论信息
     */
    Page<DiscussReplyVo> DiscussList(@RequestParam(defaultValue = "1") Integer page,
                                     @RequestParam(defaultValue = "4")Integer rows);

}
