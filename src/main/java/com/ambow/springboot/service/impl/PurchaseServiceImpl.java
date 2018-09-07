package com.ambow.springboot.service.impl;

import com.ambow.springboot.entity.Purchase;
import com.ambow.springboot.mapper.PurchaseMapper;
import com.ambow.springboot.service.PurchaseService;
import com.ambow.springboot.vo.PurchaseGoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService {
    @Autowired
    private PurchaseMapper purchaseMapper;
    /*
    * 添加中间表信息
    * */
    @Override
    public void toSave(Purchase purchase) {
        purchaseMapper.insert(purchase);
    }

    /*
    * 根据订单号查询中间表信息
    * */
    @Override
    public List<PurchaseGoodsVo> toListPurchaseByOrderNumber(long order_number) {
        return purchaseMapper.toListPurchaseByOrderNumber(order_number);
    }

    @Override
    public void toDeletePurchase(Integer id) {
        purchaseMapper.deleteByPrimaryKey(id);
    }
}
