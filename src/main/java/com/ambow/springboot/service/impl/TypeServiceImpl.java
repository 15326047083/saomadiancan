package com.ambow.springboot.service.impl;

import com.ambow.springboot.entity.Type;
import com.ambow.springboot.mapper.TypeMapper;
import com.ambow.springboot.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeMapper typeMapper;

    Type type=null;

    /*
    * 查找所有类型信息
    * */
    @Override
    public List<Type> toList() {
        List<Type> list=typeMapper.toList();
        return list;
    }

    /*
    * 根据id查找类型下的信息
    * */
    @Override
    public Type toUpdate(Integer typeId) {
        type=typeMapper.selectByPrimaryKey(typeId);
        return type;
    }

    /*
    * 根据类型名字查找类型信息
    * */
    @Override
    public Type selectByName(String typeName) {

        return typeMapper.selectByName(typeName);
    }
    /*
    * 修改类型信息
    * */
    @Override
    public void updateByPrimaryKeySelective(Type type) {
        typeMapper.updateByPrimaryKeySelective(type);
    }

    /*
     * 添加类型
     * */
    @Override
    public void addType(Type type) {
        typeMapper.insert(type);
    }
    /*
    * 删除类型
    * */
    @Override
    public void deleteType(Integer[] ids) {
        typeMapper.deleteByPrimaryKey(ids);
    }
    /*
    * 判断类型是否被引用
    * */
    @Override
    public boolean selectGoodsByTypeId(Integer[] ids) {
        if (typeMapper.selectGoodsByTypeId(ids).size()==0){
            return true;
        }else {
            return false;
        }
    }

}
