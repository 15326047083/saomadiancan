package com.ambow.springboot.service;

import com.ambow.springboot.entity.Type;

import java.util.BitSet;
import java.util.List;

public interface TypeService {
    /*
    *查询所有数据类型
    * */
    List<Type> toList();

    /*
    * 根据id查找要修改的类型信息
    * */
    Type toUpdate(Integer typeId);

    /*
    * 根据名字查找类型
    * */
    Type selectByName(String typeName);

    /*
    * 修改类型信息
    * */
    void updateByPrimaryKeySelective(Type type);

    /*
    * 添加类型
    * */
    void addType(Type type);
    /*
    * 批量删除类型
    * */
    void deleteType(Integer[] ids);
    /*
    * 判断此类型是否被引用
    * */
    boolean selectGoodsByTypeId(Integer[] id);
}
