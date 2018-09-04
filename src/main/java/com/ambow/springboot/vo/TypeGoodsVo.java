package com.ambow.springboot.vo;

import java.util.Date;

/**
 * 分类商品vo
 */
public class TypeGoodsVo {
    private Integer typeId; // 分类ID

    private Integer goodsId; // 商品ID

    private String goodsName; // 商品名称

    private Integer goodsPrice; // 商品单价

    private Integer goodsDiscount; // 商品折后价

    private Date goodsStartTime; // 商品打折开始

    private Date goodsEndTime; // 商品打折结束

    private Integer goodsNum; // 商品月销售量

    private String goodsInfo; // 商品详情

    private String typeName; // 分类名

    private Integer typeNum; // 分类下菜品数量

    @Override
    public String toString() {
        return "TypeGoodsVo{" +
                "typeId=" + typeId +
                ", goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", goodsPrice=" + goodsPrice +
                ", goodsDiscount=" + goodsDiscount +
                ", goodsStartTime=" + goodsStartTime +
                ", goodsEndTime=" + goodsEndTime +
                ", goodsNum=" + goodsNum +
                ", goodsInfo='" + goodsInfo + '\'' +
                ", typeName='" + typeName + '\'' +
                ", typeNum=" + typeNum +
                '}';
    }

    public TypeGoodsVo() {
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
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

    public Date getGoodsStartTime() {
        return goodsStartTime;
    }

    public void setGoodsStartTime(Date goodsStartTime) {
        this.goodsStartTime = goodsStartTime;
    }

    public Date getGoodsEndTime() {
        return goodsEndTime;
    }

    public void setGoodsEndTime(Date goodsEndTime) {
        this.goodsEndTime = goodsEndTime;
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

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getTypeNum() {
        return typeNum;
    }

    public void setTypeNum(Integer typeNum) {
        this.typeNum = typeNum;
    }

    public TypeGoodsVo(Integer typeId, Integer goodsId, String goodsName, Integer goodsPrice, Integer goodsDiscount,
                       Date goodsStartTime, Date goodsEndTime, Integer goodsNum, String goodsInfo, String typeName,
                       Integer typeNum) {
        this.typeId = typeId;
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsPrice = goodsPrice;
        this.goodsDiscount = goodsDiscount;
        this.goodsStartTime = goodsStartTime;
        this.goodsEndTime = goodsEndTime;
        this.goodsNum = goodsNum;
        this.goodsInfo = goodsInfo;
        this.typeName = typeName;
        this.typeNum = typeNum;
    }
}
