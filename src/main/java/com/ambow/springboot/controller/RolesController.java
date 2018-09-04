package com.ambow.springboot.controller;

import com.ambow.springboot.entity.Emp;
import com.ambow.springboot.entity.Roles;
import com.ambow.springboot.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 菜单
 */
@RestController
@RequestMapping("/roles")
public class RolesController {
    @Autowired
    private RolesService rolesService; // 注入service

    /**
     * 获取全部菜单列表
     *
     * @return json（菜单列表）
     */
    @RequestMapping("/toList")
    public List<Roles> toList() {
        return rolesService.queryAll();
    }

    /**
     * 根据rolesId获取要修改的菜单信息
     *
     * @param rolesId 菜单ID
     * @return 要修改的roles详细信息
     */
    @RequestMapping("/toUpdate/{rolesId}")
    public Roles toUpdate(@PathVariable("rolesId") Integer rolesId) {
        return rolesService.getById(rolesId);
    }

    /**
     * 修改
     *
     * @param roles 修改后的roles信息
     * @return 成功或者失败（success or error）
     */
    @RequestMapping("/update")
    public String update(Roles roles) {
        rolesService.update(roles);
        return "success";
    }

    /**
     * 根据ID删除菜单
     *
     * @param rolesId 菜单ID
     * @return 成功或者失败（success or error）
     */
    @RequestMapping("/delete/{rolesId}")
    public String delete(@PathVariable("rolesId") Integer rolesId) {
        rolesService.delete(rolesId);
        return "success";
    }

    /**
     * 新增菜单
     *
     * @param roles 菜单详情
     * @return 成功或者失败（success or error）
     */
    @RequestMapping("/save")
    public String save(Roles roles) {
        rolesService.save(roles);
        return "success";
    }

    /**
     * 根据用户权限获取菜单
     *
     * @param request 获取session中登陆用户信息
     * @return 该用户对应的菜单项
     */
    @RequestMapping("/getMean")
    public List<Roles> getMean(HttpServletRequest request) {
        Emp emp = (Emp) request.getSession().getAttribute("emp");
        return rolesService.getMeanByRoles(emp.getRoles());
    }
}
