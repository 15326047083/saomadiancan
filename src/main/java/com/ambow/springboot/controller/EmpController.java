package com.ambow.springboot.controller;
import com.ambow.springboot.entity.Emp;
import com.ambow.springboot.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping(value = "/emp")
public class EmpController {
    @Autowired
    EmpService empService;
    /**
    * 查看所有员工信息
    */
    @RequestMapping(value = "/toList")
    public List<Emp> toList(Emp emp) {
        List<Emp> empList =empService.toList();
        return empList;
    }
    /**
     * 添加员工信息
     */
    @RequestMapping(value = "/Save")
    public int toSave(@ModelAttribute Emp emp) {
        return empService.toSave(emp);
    }

    /**
     * 根据id删除员工
     */
    @RequestMapping(value = "/delete/{id}")
    public int delete(@PathVariable("id") Integer id) {
        return empService.delete(id);
    }
    /**
     * 修改员工信息
     */
    @RequestMapping(value = "/Update")
    public int toUpdate(@ModelAttribute Emp emp) {
       return empService.toUpdate(emp);
    }
    /**
     * 根据id查看员工信息
     */
    @RequestMapping(value = "/toUpdate/{id}")
    public Emp getOne(@PathVariable("id") Integer id) {
        Emp emp= empService.getList(id);
        return emp;
    }
    /**
     * roles查询是采购员的
     */
    @RequestMapping(value = "/roleList")
    public List<Emp> toroleList(Emp emp) {
        List<Emp> empList =empService.toList();
        return empList;
    }
    }