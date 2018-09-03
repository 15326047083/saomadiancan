package com.ambow.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JumpController {
    @RequestMapping("/")
    public String toIndex() {
        return "redirect:/user/toIndex";
    }
}
