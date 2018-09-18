
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
    public String login(Emp emp, HttpServletRequest request) {

        HttpSession session = request.getSession();

        Emp emps = empService.login(emp);
        if (emps != null) {
            session.setAttribute("emp", emps);
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
    public String toSave(@ModelAttribute Emp emp) {
        String username =emp.getUsername();
        if (empService.selectByName(username) != null) {
            return "error";
        }
        empService.toSave(emp);
        return "success";
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
    public String toUpdate(@ModelAttribute Emp emp) {
        String username = emp.getUsername();
        Emp emp1 = empService.selectByName(username);
        if (emp1 != null) {
            if (emp1.getId() != emp1.getId()) {
                return "error";
            } else {
                empService.toUpdate(emp);
                return "success";
            }
        } else {
            empService.toUpdate(emp);
            return "success";
        }
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

    /*
     *根据empid和password查询
     *
     **/
    @ResponseBody
    @RequestMapping(value = "/emplistbypassowrd/{password}")
    public String listempBypassword(@PathVariable("password") String password, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Emp emps = (Emp) session.getAttribute("emp");
        Integer empId = emps.getId();
        Emp empss = empService.selectByPassword(empId, password);
        if (empss == null) {
            return "success";
        }
        return "error";
    }
    /**
     *修改密码
     */
    @ResponseBody
    @RequestMapping(value ="/toUpdatePassword/{password}" )
    public String updatePassword(@PathVariable("password") String password,HttpServletRequest request){
        HttpSession session=request.getSession();
        Emp emp= (Emp) session.getAttribute("emp");
        emp.setPassword(password);
        empService.toUpdate(emp);
        return "success";
    }

}