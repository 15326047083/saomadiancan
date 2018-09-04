package com.ambow.springboot.service;

import com.ambow.springboot.entity.Roles;

import java.util.List;

public interface RolesService {
    List<Roles> queryAll();

    Roles getById(Integer rolesId);

    void update(Roles roles);

    void delete(Integer rolesId);

    void save(Roles roles);
}
