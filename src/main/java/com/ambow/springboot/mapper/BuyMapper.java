package com.ambow.springboot.mapper;

import com.ambow.springboot.entity.Buy;

public interface BuyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Buy record);

    int insertSelective(Buy record);

    Buy selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Buy record);

    int updateByPrimaryKeyWithBLOBs(Buy record);

    int updateByPrimaryKey(Buy record);
}