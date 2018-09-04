package com.ambow.springboot.service.impl;

import com.ambow.springboot.entity.Roles;
import com.ambow.springboot.mapper.RolesMapper;
import com.ambow.springboot.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolesServiceImpl implements RolesService {
    @Autowired
    private RolesMapper rolesMapper;

    @Override
    public List<Roles> queryAll() {
        return rolesMapper.queryAll();
    }

    @Override
    public Roles getById(Integer rolesId) {
        return rolesMapper.selectByPrimaryKey(rolesId);
    }

    @Override
    public void update(Roles roles) {
        rolesMapper.updateByPrimaryKeySelective(roles);
    }

    @Override
    public void delete(Integer rolesId) {
        rolesMapper.deleteByPrimaryKey(rolesId);
    }

    @Override
    public void save(Roles roles) {
        rolesMapper.insert(roles);
    }

    @Override
    public List<Roles> getMeanByRoles(String roles) {
        return rolesMapper.getMeanByRoles(roles);
    }
}
