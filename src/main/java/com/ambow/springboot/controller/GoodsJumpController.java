package com.ambow.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/goodsJump")
public class GoodsJumpController {
    /*
Goods页面的展示
 */
    @RequestMapping("/getTypeToList")
    public  String getTypeToList(){return "manager/goods/addGoods";}

    /*
    Goods页面的增加
     */
    @RequestMapping("/toGoodsAdd")
    public String toGoodsAdd(){return "manager/goods/addGoods";}
    /*
Goods页面的查看
 */
    @RequestMapping("/toGoodsShow/{goodsid}")
    public String toGoodsShow(@PathVariable("goodsid") Integer goodsid, Model model){
        model.addAttribute("goodsid", goodsid);
        return "manager/goods/showGoods";
    }

//    @RequestMapping("/toUpdate")
//    public String toUpdate(){return "manager/goods/discount";}
/*
Goods页面的修改
 */
    @RequestMapping("/toGoodsUpdate/{goodsid}")
    public String toGoodsUpdate(@PathVariable("goodsid") Integer goodsid, Model model) {
        //  System.out.println(id);
        model.addAttribute("goodsid", goodsid);
        return "manager/goods/updateGoods";
    }
    /*
    Goods页面列表嘞
     */
    @RequestMapping("/toGoodsList")
    public  String toGoods(){
        return  "manager/goods/goodsList";
    }
}