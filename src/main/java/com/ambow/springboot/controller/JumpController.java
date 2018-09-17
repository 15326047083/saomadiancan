package com.ambow.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jump")
public class JumpController {

   // 跳转到  管理员主页
    @RequestMapping("/")
    public String toIndex() {
        return "manager/index";
    }

    //跳转到  左侧导航菜单列表
    @RequestMapping("/toMenuList")
    public String toMenu(){return "manager/menu/list";}

  //   跳转到  新增左侧导航菜单
    @RequestMapping("/toMenuAdd")
    public String toAdd(){return "manager/menu/add";}

   //  跳转  修改导航菜单
    @RequestMapping("/toMenuUpdate/{id}")
    public String toEmpUpdate(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("id", id);
        return "manager/menu/update";
    }

     //跳转到  购买列表
    @RequestMapping("/toBuyList")
    public String toBuy(){return "manager/buy/list";}

    //后台登陆页面
    @RequestMapping("/toEmpLogin")
    public String toEmpLogin(){return "manager/login"; }

    //前台评论页面
    @RequestMapping("/toDiscussList")
    public String toDiscussList(){return "phone/disscussList";}
    //前台服务页面
    @RequestMapping("/toService")
    public String toService(){return "phone/service";}
}
