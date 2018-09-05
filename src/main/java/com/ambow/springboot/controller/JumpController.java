package com.ambow.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jump")
public class JumpController {
    @RequestMapping("/")
    public String toIndex() {
        return "manager/index";
    }

    @RequestMapping("/toMenu")
    public String toMenu(){return "manager/menu/add";}
}
