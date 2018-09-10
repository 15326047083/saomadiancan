package com.ambow.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 跳转
 */
@Controller
@RequestMapping("/empJump")
public class EmpJumpController {
    // 新增员工
    @RequestMapping("/toEmpNew")
    public String toEmpNew() {
        return "manager/emp/add";
    }

    // 员工列表
    @RequestMapping("/toEmpList")
    public String toEmpList() {
        return "manager/emp/list";
    }

    // 修改员工
    @RequestMapping("/toEmpUpdate/{empId}")
    public String toEmpUpdate(@PathVariable("empId") Integer empId, Model model) {
        model.addAttribute("empId", empId);
        return "manager/emp/update";
    }

    // 采购列表
    @RequestMapping("/toBuyList")
    public String toBuyList() {
        return "manager/buy/list";
    }

    // 新增采购记录
    @RequestMapping("/toBuyNew")
    public String toBuyNew() {
        return "manager/buy/add";
    }

    // 评价回复列表
    @RequestMapping("/toDiscussList")
    public String toDiscussList() {
        return "manager/discuss/discuss";
    }

    // 购物车
    @RequestMapping("/toCart")
    public String toCart() {
        return "phone/cart";
    }

    // 商品列表，点餐
    @RequestMapping("/toGoodsList")
    public String toGoodsList() {
        return "phone/goods";
    }
}
