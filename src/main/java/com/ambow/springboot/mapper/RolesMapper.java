package com.ambow.springboot.mapper;

import com.ambow.springboot.entity.Roles;

import java.util.List;

public interface RolesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Roles record);

    int insertSelective(Roles record);

    Roles selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Roles record);

    int updateByPrimaryKey(Roles record);

    List<Roles> queryAll();

    List<Roles> getMeanByRoles(String roles);
}