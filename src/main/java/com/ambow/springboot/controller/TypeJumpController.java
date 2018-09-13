package com.ambow.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    /*
    * 某一天时段客流量
    * */
    @RequestMapping("/hoursCustmer")
    public String ordersCustmer(){
        return "manager/report/ordersCustmer";
    }

    /*
    * 日成本利润
    * */
    @RequestMapping("costGain")
    public String costGain(){
        return "manager/report/costGain";
    }
    /*
     * 月成本利润
     * */
    @RequestMapping("costGainMonth")
    public String costGainMonth(){
        return "manager/report/costGainMonth";
    }
    /*
     * 年成本利润
     * */
    @RequestMapping("costGainYear")
    public String costGainYear(){
        return "manager/report/coatGainYear";
    }

    /*
     * 跳转到订单全查页面
     * */
    @RequestMapping("ordersList")
    public String ordersList(){
        return "manager/orders/list";
    }

    /*
    * 订单详情
    * */
    @RequestMapping("/toFindPurchase/{ordersNum}/{state}")
    public String toFindPurchase(@PathVariable("ordersNum") String ordersNum,@PathVariable("state") String state, Model model) {
        model.addAttribute("ordersNum", ordersNum);
        model.addAttribute("state", state);
        return "manager/orders/show";
    }
}
