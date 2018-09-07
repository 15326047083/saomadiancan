package com.ambow.springboot.controller;

import com.ambow.springboot.entity.Buy;
import com.ambow.springboot.service.BuyService;
import com.ambow.springboot.util.ImportExcel;
import com.ambow.springboot.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/*
 * 采购controller
 * @Author yy
 * */
@RestController
@RequestMapping("/buy")
public class BuyController {
    @Autowired
    private BuyService buyService;

    /*
     * 导入方法
     * */
    @RequestMapping(value = "/import", method = RequestMethod.POST)
    public String importExcel(@RequestParam("file") MultipartFile file, @RequestParam("id") Integer id,
                              HttpServletRequest request) {
        ImportExcel importExcel = new ImportExcel();
        List<Buy> importList = importExcel.ImportExcel(file, id);
        /*
         * 用户登录session采购人
         * */
        /**
         * TODO 查询emp中所有roles为采购员的列表
         */
        for (Buy importLists : importList) {
            Buy record = new Buy();
            record.setName(importLists.getName());
            record.setNum(importLists.getNum());
            record.setPrice(importLists.getPrice());
            record.setBuyDate(importLists.getBuyDate());
            record.setInfo(importLists.getInfo());
            record.setUserId(id);
            buyService.insertBuy(record);
        }
        return "SUCCESS";
    }

    /*
     * 新增方法
     * */
    @RequestMapping(value = "/tosave", method = RequestMethod.POST)
    public String save(Buy buy) {
        buy.setBuyDate(new Date());
        buyService.insertBuy(buy);
        return "success";
    }

    /*
     * 查询方法
     * */
    @RequestMapping(value = "/toList")
    public Page<Buy> buyList(@RequestParam(name = "page", defaultValue = "1") Integer page,
                             @RequestParam(defaultValue = "4") Integer rows) {
        Page<Buy> empBuyVoList = buyService.buyList(page, rows);
        Buy buy = new Buy();
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        for (Buy empbuyVolists : empBuyVoList.getRows()) {
            String s = (new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").format(empbuyVolists.getBuyDate()));
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
    @RequestMapping(value = "/todelete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        buyService.deleteBuy(id);
        return "SUCCESS";
    }

    /*
     * 批量删除
     * */
    @RequestMapping(value = "/toalldelete/{ids}")
    public String delete(@PathVariable("ids") Integer[] ids) {
        buyService.deleteAll(ids);
        return "SUCCESS";
    }
}
