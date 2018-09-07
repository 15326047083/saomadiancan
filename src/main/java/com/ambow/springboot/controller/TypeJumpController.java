package com.ambow.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/zhengJump")
public class TypeJumpController {

    /*
    * 类型添加跳转
    * */
    @RequestMapping("/add")
    public String addType(){
        return "manager/type/addType";
    }

    /*
    * 类型全查路径
    * */
    @RequestMapping("toList")
    public String toList(){
        return "manager/type/typeList";
    }


    /*
    * 显示要修改的类型内容
    * */
    @RequestMapping("/toUpdate/{id}")
    public String toUpdate(@PathVariable("id") Integer id, Model model) {
        System.out.println(id);
        model.addAttribute("id", id);
        return "manager/type/updateType";
    }
    /*
    * 区间内的日销量
    * */
    @RequestMapping("/ordersDay")
    public String ordersDay(){
       // System.out.println("区间内的日销量");
        return "manager/report/ordersDay";
    }

    /*
    * 某年的月销量
    * */
    @RequestMapping("/ordersMonth")
    public String  ordersMonth(){
        return "manager/report/ordersMonth";
    }

    /*
    * 商品销量
    * */
    @RequestMapping("/goodsSale")
    public String goodsSale(){
        return "manager/report/goodsSale";
    }
}
