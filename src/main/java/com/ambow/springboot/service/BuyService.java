package com.ambow.springboot.service;

import com.ambow.springboot.entity.Buy;

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
     List<Buy> buyList();
     /*
     * 删除方法
     * */
     void deleteBuy(Integer id);
     /*
      * 批量删除方法
      * */
     void deleteAll(Integer[] id);
}
