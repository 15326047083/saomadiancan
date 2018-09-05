package com.ambow.springboot.service;

import com.ambow.springboot.entity.Buy;
import com.ambow.springboot.util.Page;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
/*
* 采购service
* @Author yy
* */
public interface BuyService {
     /*
     * 导入方法
     * */
     void insertBuy(Buy record);
     /*
     * 查询方法
     * */
     Page<Buy> buyList(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "4")Integer rows);
     /*
     * 删除方法
     * */
     void deleteBuy(Integer id);
     /*
      * 批量删除方法
      * */
     void deleteAll(Integer[] id);
}
