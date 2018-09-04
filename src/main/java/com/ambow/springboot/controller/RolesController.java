package com.ambow.springboot.controller;

import com.ambow.springboot.entity.Roles;
import com.ambow.springboot.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RolesController {
    @Autowired
    private RolesService rolesService;

    @RequestMapping("/toList")
    public List<Roles> toList() {
        return rolesService.queryAll();
    }

    @RequestMapping("/toUpdate/{rolesId}")
    public Roles toUpdate(@PathVariable("rolesId") Integer rolesId) {
        return rolesService.getById(rolesId);
    }

    @RequestMapping("/update")
    public String update(Roles roles) {
        rolesService.update(roles);
        return "success";
    }

    @RequestMapping("/delete/{rolesId}")
    public String delete(@PathVariable("rolesId") Integer rolesId) {
        rolesService.delete(rolesId);
        return "success";
    }

    @RequestMapping("/save")
    public String save(Roles roles) {
        rolesService.save(roles);
        return "success";
    }
}
