package com.ambow.springboot.controller;

import com.ambow.springboot.entity.Buy;
import com.ambow.springboot.entity.Emp;
import com.ambow.springboot.service.BuyService;
import com.ambow.springboot.util.ImportExcel;
import com.ambow.springboot.util.Page;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
/*
* 采购controller
* @Author yy
* */
@Controller
@RequestMapping("/buy")
public class BuyController {
 @Autowired
 private BuyService buyService;
    /*
    * 导入方法
    * */
    @ResponseBody
    @RequestMapping(value="/import")
    public String importExcel(@RequestParam("file")File file,Integer id ,HttpServletRequest request){
        ImportExcel importExcel=new ImportExcel();
        List<Buy> importList=importExcel.ImportExcel(file);
        /*
        * 用户登录session采购人
        * */
        /**
         * TODO 查询emp中所有roles为采购员的列表
         */
        HttpSession session=request.getSession();
        Emp emp= (Emp) session.getAttribute("emp");
        Buy record=new Buy();
        for (Buy  importLists:importList){
            record.setName(importLists.getName());
            record.setNum(importLists.getNum());
            record.setPrice(importLists.getPrice());
            record.setBuyDate( importLists.getBuyDate());
            record.setInfo(importLists.getInfo());
            //empid
            record.setUserId(emp.getId());
            buyService.insertBuy(record);
        }
        return  "SUCCESS";
    }
    /*
     * 新增方法
     * */
    @ResponseBody
    @RequestMapping(value="/tosave")
    public  String save(Buy record){
        buyService.insertBuy(record);
        return "SUCCESS";
    }
    /*
    * 查询方法
    * */
    @ResponseBody
    @RequestMapping(value = "/toList")
    public Page<Buy> buyList(@RequestParam(defaultValue = "1") Integer page,
                             @RequestParam(defaultValue = "4")Integer rows){
        Page<Buy> empBuyVoList=buyService.buyList(page, rows);
        Buy buy=new Buy();
        Date date=new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        for (Buy empbuyVolists:empBuyVoList.getRows()){
            String s=(new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").format( empbuyVolists.getBuyDate()));
            try {
                date = format.parse(s);
                buy.setBuyDate(date);
            } catch (Exception e) {

            }
        }
        return empBuyVoList;
    }
    /*
    * 删除方法
    * */
    @ResponseBody
    @RequestMapping(value="/todelete/{id}")
    public  String delete(@PathVariable("id") Integer id){
        buyService.deleteBuy(id);
        return "SUCCESS";
    }
    /*
    * 批量删除
    * */
    @ResponseBody
    @RequestMapping(value="/toalldelete/{ids}")
     public String delete(@PathVariable("ids") Integer[] ids){
        buyService.deleteAll(ids);
        return "SUCCESS";
    }
}
