package com.ambow.springboot.controller;

import com.ambow.springboot.WebSocket;
import com.ambow.springboot.entity.Emp;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * 跳转
 */
@Controller
@RequestMapping("/empJump")
public class EmpJumpController {
    @Autowired
    private WebSocket webSocket;

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

    // 订单页
    @RequestMapping("/toOrder")
    public String toOrder() {
        return "phone/order";
    }

    // 支付页面
    @RequestMapping("/toPay")
    public String toPay() {
        return "phone/pay";
    }



    // 查看员工自己信息
    @RequestMapping("/toEmpBy")
    public String toEmpby(HttpServletRequest request, Model model) {
        HttpSession session=request.getSession();
        Emp emps= (Emp) session.getAttribute("emp");
        Integer empId = emps.getId();
        model.addAttribute("empId", empId);
        return "manager/emp/myInfo";
    }

    // 员工修改密码
    @RequestMapping("/toUpdatePassword")
    public String toUpdatePassword(HttpServletRequest request, Model model) {
        HttpSession session=request.getSession();
        Emp emp= (Emp) session.getAttribute("emp");
        model.addAttribute("emp", emp);
        return "manager/emp/updatePassword";
    }

    // 获取用户列表
    @RequestMapping("/toUserList")
    public String toUserList() {
        return "phone/user/userList";
    }

    // 用户登陆
    @RequestMapping("/toUserLogin")
    public String toUserLogin() {
        return "phone/user/login";
    }

    // 用户注册
    @RequestMapping("/toUserRegister")
    public String toUserRegister() {
        return "phone/user/register";
    }

    // 我的详情
    @RequestMapping("/toMy")
    public String toMy() {
        return "phone/user/my";
    }

    // 我的订单
    @RequestMapping("/toMyOrders")
    public String toMyOrders() {
        return "phone/user/myOrder";
    }

    // 我的积分
    @RequestMapping("/toMyIntegral")
    public String toMyIntegral() {
        return "phone/user/integral";
    }

    // 呼叫服务员
    @RequestMapping("/help")
    @ResponseBody
    public String help(HttpServletRequest request) {
        //String deskNum = (String) request.getSession().getAttribute("deskNum");
        String deskNum = "" + 5;
        webSocket.sendMessage(deskNum);
        return "success";
    }
}
