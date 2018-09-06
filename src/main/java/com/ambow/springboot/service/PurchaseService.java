package com.ambow.springboot.service;

import com.ambow.springboot.entity.Purchase;
import com.ambow.springboot.vo.PurchaseGoodsVo;

import java.util.List;

public interface PurchaseService {
    void toSave(Purchase purchase);

    List<PurchaseGoodsVo> toListPurchaseByOrderNumber(long order_number);
}
