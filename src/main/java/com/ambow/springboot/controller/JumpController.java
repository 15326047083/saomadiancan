package com.ambow.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jump")
public class JumpController {
    @RequestMapping("/")
    public String toIndex() {
        return "manager/index";
    }

    @RequestMapping("/toMenuList")
    public String toMenu(){return "manager/menu/list";}

    @RequestMapping("/toMenuAdd")
    public String toAdd(){return "manager/menu/add";}

    @RequestMapping("/toMenuUpdate/{id}")
    public String toEmpUpdate(@PathVariable("id") Integer id, Model model) {
      //  System.out.println(id);
        model.addAttribute("id", id);
        return "manager/menu/update";
    }
}
