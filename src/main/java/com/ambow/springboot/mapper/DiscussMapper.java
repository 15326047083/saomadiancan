package com.ambow.springboot.mapper;

import com.ambow.springboot.entity.Discuss;

public interface DiscussMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Discuss record);

    int insertSelective(Discuss record);

    Discuss selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Discuss record);

    int updateByPrimaryKeyWithBLOBs(Discuss record);

    int updateByPrimaryKey(Discuss record);
}