package com.ambow.springboot.vo;

import com.ambow.springboot.entity.Type;

import java.util.Date;
import java.util.List;

public class GoodsTypeListVo {
    private Integer goodsId; // 主键

    private String goodsTypeId; // 类型ID

    private String goodsName; // 商品名

    private Integer goodsPrice; // 单价

    private Integer goodsDiscount; // 折后价

    private Date goodsStartTime; // 打折开始

    private Date goodsEndTime; // 打折借书

    private Integer goodsNum; // 月销售量

    private String goodsInfo; // 详情

    private List<Type> typeList;

    public GoodsTypeListVo() {
    }

    public GoodsTypeListVo(Integer goodsId, String goodsTypeId, String goodsName, Integer goodsPrice, Integer
            goodsDiscount, Date goodsStartTime, Date goodsEndTime, Integer goodsNum, String goodsInfo, List<Type>
                                   typeList) {

        this.goodsId = goodsId;
        this.goodsTypeId = goodsTypeId;
        this.goodsName = goodsName;
        this.goodsPrice = goodsPrice;
        this.goodsDiscount = goodsDiscount;
        this.goodsStartTime = goodsStartTime;
        this.goodsEndTime = goodsEndTime;
        this.goodsNum = goodsNum;
        this.goodsInfo = goodsInfo;
        this.typeList = typeList;
    }

    @Override
    public String toString() {
        return "GoodsTypeListVo{" +
                "goodsId=" + goodsId +
                ", goodsTypeId='" + goodsTypeId + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", goodsPrice=" + goodsPrice +
                ", goodsDiscount=" + goodsDiscount +
                ", goodsStartTime=" + goodsStartTime +
                ", goodsEndTime=" + goodsEndTime +
                ", goodsNum=" + goodsNum +
                ", goodsInfo='" + goodsInfo + '\'' +
                ", typeList=" + typeList +
                '}';
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsTypeId() {
        return goodsTypeId;
    }

    public void setGoodsTypeId(String goodsTypeId) {
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

    public List<Type> getTypeList() {
        return typeList;
    }

    public void setTypeList(List<Type> typeList) {
        this.typeList = typeList;
    }
}
