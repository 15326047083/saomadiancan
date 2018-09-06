package com.ambow.springboot.mapper;

import com.ambow.springboot.entity.Purchase;
import com.ambow.springboot.vo.PurchaseGoodsVo;

import java.util.List;

public interface PurchaseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Purchase record);

    int insertSelective(Purchase record);

    Purchase selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Purchase record);

    int updateByPrimaryKey(Purchase record);

    List<PurchaseGoodsVo> toListPurchaseByOrderNumber(long order_number);
}