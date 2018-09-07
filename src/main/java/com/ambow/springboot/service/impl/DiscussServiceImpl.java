package com.ambow.springboot.service.impl;

import com.ambow.springboot.entity.Discuss;
import com.ambow.springboot.mapper.DiscussMapper;
import com.ambow.springboot.service.DiscussService;
import com.ambow.springboot.util.Page;
import com.ambow.springboot.vo.DiscussReplyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Service
public class DiscussServiceImpl implements DiscussService {

    @Autowired
    private DiscussMapper discussMapper;

    /**
     * 查询所有评价和回复
     *
     * @param page
     * @param rows
     * @return
     */
    @Override
    public Page<DiscussReplyVo> DiscussList(@RequestParam(defaultValue = "1") Integer page,
                                            @RequestParam(defaultValue = "4") Integer rows) {
        Discuss discuss = new Discuss();
        discuss.setStart((page - 1) * rows);
        discuss.setRows(rows);
        Page<DiscussReplyVo> pages = new Page<DiscussReplyVo>();
        pages.setPage(page);
        pages.setRows(discussMapper.DiscussList(discuss));
        pages.setSize(rows);
        pages.setTotal(discussMapper.selectDiscussCount());
        return pages;
    }

    /**
     * 加一个评价
     *
     * @param discuss
     * @return
     */
    @Override
    public int saveDiscuss(Discuss discuss) {
        discuss.setDiscussTime(new Date());
        return discussMapper.insertSelective(discuss);
    }

    /**
     * 对评价进行回复
     *
     * @param discuss
     * @return
     */
    @Override
    public int saveReply(Discuss discuss) {
        discuss.setDiscussTime(new Date());
        return discussMapper.insertSelective(discuss);
    }
}
