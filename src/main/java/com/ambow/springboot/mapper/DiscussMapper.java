package com.ambow.springboot.mapper;

import com.ambow.springboot.entity.Discuss;
import com.ambow.springboot.vo.DiscussReplyVo;

import java.util.List;

public interface DiscussMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Discuss record);

    int insertSelective(Discuss record);

    Discuss selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Discuss record);

    int updateByPrimaryKeyWithBLOBs(Discuss record);

    int updateByPrimaryKey(Discuss record);

    /**
     * 查询所有评价和回复
     * @return List<DiscussReplyVo>
     */
    List<DiscussReplyVo> DiscussList();

    /*
     * 统计总条数方法
     * */
    int selectDiscussCount();
}