package com.ambow.springboot.mapper;

import com.ambow.springboot.entity.Buy;

import java.util.List;
/*
* 采购Mapper
* @Author yy
* */
public interface BuyMapper {
    /*
    * 删除方法
    * */
    int deleteByPrimaryKey(Integer id);
    /*
    * 导入方法
    * */
    int insert(Buy record);
    /*
    * 查询所有方法
    * */
    List<Buy> listBuy();

    int insertSelective(Buy record);

    Buy selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Buy record);

    int updateByPrimaryKeyWithBLOBs(Buy record);

    int updateByPrimaryKey(Buy record);
}