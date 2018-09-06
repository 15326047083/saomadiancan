package com.ambow.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/empJump")
public class EmpJumpController {
    @RequestMapping("/toEmpNew")
    public String toEmpNew() {
        return "manager/emp/add";
    }

    @RequestMapping("/toEmpList")
    public String toEmpList() {
        return "manager/emp/list";
    }

    @RequestMapping("/toEmpUpdate/{empId}")
    public String toEmpUpdate(@PathVariable("empId") Integer empId, Model model) {
        model.addAttribute("empId", empId);
        return "manager/emp/update";
    }
}
