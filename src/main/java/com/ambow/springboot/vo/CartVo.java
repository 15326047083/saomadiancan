package com.ambow.springboot.vo;

import java.util.Date;

public class CartVo {
    private Integer goodsId; // 主键

    private Integer goodsTypeId; // 类型ID

    private String goodsName; // 商品名

    private Integer goodsPrice; // 单价

    private Integer goodsDiscount; // 折后价

    private Integer goodsNum; // 月销售量

    private String goodsInfo; // 详情

    private Integer num; // 购物车数量

    @Override
    public String toString() {
        return "CartVo{" +
                "goodsId=" + goodsId +
                ", goodsTypeId=" + goodsTypeId +
                ", goodsName='" + goodsName + '\'' +
                ", goodsPrice=" + goodsPrice +
                ", goodsDiscount=" + goodsDiscount +
                ", goodsNum=" + goodsNum +
                ", goodsInfo='" + goodsInfo + '\'' +
                ", num=" + num +
                '}';
    }

    public CartVo() {
    }

    public CartVo(Integer goodsId, Integer goodsTypeId, String goodsName, Integer goodsPrice, Integer goodsDiscount,
                  Integer goodsNum, String goodsInfo, Integer num) {

        this.goodsId = goodsId;
        this.goodsTypeId = goodsTypeId;
        this.goodsName = goodsName;
        this.goodsPrice = goodsPrice;
        this.goodsDiscount = goodsDiscount;
        this.goodsNum = goodsNum;
        this.goodsInfo = goodsInfo;
        this.num = num;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getGoodsTypeId() {
        return goodsTypeId;
    }

    public void setGoodsTypeId(Integer goodsTypeId) {
        this.goodsTypeId = goodsTypeId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Integer goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Integer getGoodsDiscount() {
        return goodsDiscount;
    }

    public void setGoodsDiscount(Integer goodsDiscount) {
        this.goodsDiscount = goodsDiscount;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    public String getGoodsInfo() {
        return goodsInfo;
    }

    public void setGoodsInfo(String goodsInfo) {
        this.goodsInfo = goodsInfo;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
