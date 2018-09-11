
package com.ambow.springboot.controller;

import com.ambow.springboot.entity.Emp;
import com.ambow.springboot.entity.User;
import com.ambow.springboot.service.EmpService;
import com.ambow.springboot.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping(value = "/emp")
public class EmpController {

    @Autowired
    EmpService empService;
    /*
     * 员工登录
     * */
    @ResponseBody
    @RequestMapping("/toEmplogin")
    public  String  login(Emp emp, HttpServletRequest request){

        HttpSession session=request.getSession();
        Emp users=empService.login(emp);
        if (users!=null){
            session.setAttribute("user","users");
            return "SUCCESS";
        }
        return "";
    }
    /**
     * 查看所有员工信息
     */
    @RequestMapping(value = "/toList")
    public List<Emp> toList(Emp emp) {
        List<Emp> empList = empService.toList();
        return empList;
    }

    /**
     * 添加员工信息
     */
    @RequestMapping(value = "/Save", method = RequestMethod.POST)
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
        Emp emp = empService.getList(id);
        return emp;
    }

    /**
     * roles查询是采购员的
     */
    @RequestMapping(value = "/roleList")
    public List<Emp> toroleList(Emp emp) {
        List<Emp> empList = empService.toList();
        return empList;
    }
}