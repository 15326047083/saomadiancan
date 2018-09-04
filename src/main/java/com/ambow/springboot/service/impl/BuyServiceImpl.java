package com.ambow.springboot.service.impl;

import com.ambow.springboot.mapper.BuyMapper;
import com.ambow.springboot.service.BuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ambow.springboot.entity.Buy;


import java.util.List;
/*
* 采购serviceImpl
* @Author yy
* */
@Service
public class BuyServiceImpl implements BuyService {

    @Autowired
    private BuyMapper buyMapper;
    /*
     * 导入
     * */
    public void insertBuy(Buy record) {
       buyMapper.insert(record);
    }
    /*
    * 查询所有
    * */
    @Override
    public List<Buy> buyList() {
       List<Buy> list=buyMapper.listBuy();
       return list;
    }
    /*
     * &#x5220;&#x9664;&#x6240;&#x6709;
     * */
    @Override
    public void deleteBuy(Integer id) {
        buyMapper.deleteByPrimaryKey(id);
    }
    /*
    * 批量删除
    * */
    @Override
    public void deleteAll(Integer[] id) {
        for(int i=0;i<id.length;i++){
            buyMapper.deleteByPrimaryKey(id[i]);
        }
    }
}
