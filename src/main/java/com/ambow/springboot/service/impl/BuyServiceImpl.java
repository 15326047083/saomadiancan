package com.ambow.springboot.service.impl;


import com.ambow.springboot.mapper.BuyMapper;
import com.ambow.springboot.service.BuyService;
import com.ambow.springboot.util.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ambow.springboot.entity.Buy;
import org.springframework.web.bind.annotation.RequestParam;


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
    public Page<Buy> buyList(@RequestParam(defaultValue = "1") Integer page,
                             @RequestParam(defaultValue = "4")Integer rows) {
        Buy buy = new Buy();

        buy.setStart((page - 1) * rows);
        buy.setRows(rows);
        Page<Buy> pages = new Page<Buy>();
        pages.setPage(page);
        pages.setRows(buyMapper.listBuy(buy));
        pages.setSize(rows);
        pages.setTotal(buyMapper.selectBuyCount());
        return pages;

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
