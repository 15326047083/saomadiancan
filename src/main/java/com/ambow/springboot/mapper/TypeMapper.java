package com.ambow.springboot.mapper;

import com.ambow.springboot.entity.Goods;
import com.ambow.springboot.entity.Type;

import java.util.BitSet;
import java.util.List;

public interface TypeMapper {
    /*
    * 根据id删除类型
    * */
    int deleteByPrimaryKey(int id);

    /*
    * 添加类型
    * */
    int insert(Type record);
    /*
    *没用的添加数据类型
    * */
    int insertSelective(Type record);
    /*
    * 根据id查找数据类型
    * */
    Type selectByPrimaryKey(Integer id);
    /*
    * 修改数据类型
    * */
    int updateByPrimaryKeySelective(Type record);
    /*
     * 修改数据类型
     * */
    int updateByPrimaryKey(Type record);

    /*
    * 查找所有类型信息
    * */
    List<Type> toList();
    /*
    * 根据类型名字查找类型信息
    * */
    Type selectByName(String typeName);

    /*
    * 根据类型id查看物品是否被引用
    * */
    List<Goods> selectGoodsByTypeId(Integer[] ids);
}