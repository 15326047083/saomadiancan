package com.ambow.springboot.vo;

import java.util.Date;

public class PurchaseGoodsVo {

    private Integer purchase_id; // 中间表主键

    private Long  purchase_orderNum; // 中间表订单号

    private Integer  purchase_goodsId; //中间表商品ID

    private Integer  purchase_num; // 中间表商品数量

    private Integer goods_id; // 商品主键

    private String goods_typeId; // 商品类型ID

    private String goods_name; // 商品名

    private Integer goods_price; // 商品单价

    private Integer goods_discount; // 折后价

    private Date goods_startTime; // 商品打折开始

    private Date goods_endTime; // 商品打折结束

    private Integer goods_num; // 商品月销售量

    private String goods_info; // 商品详情

    public Integer getPurchase_id() {
        return purchase_id;
    }

    public void setPurchase_id(Integer purchase_id) {
        this.purchase_id = purchase_id;
    }

    public Long getPurchase_orderNum() {
        return purchase_orderNum;
    }

    public void setPurchase_orderNum(Long purchase_orderNum) {
        this.purchase_orderNum = purchase_orderNum;
    }

    public Integer getPurchase_goodsId() {
        return purchase_goodsId;
    }

    public void setPurchase_goodsId(Integer purchase_goodsId) {
        this.purchase_goodsId = purchase_goodsId;
    }

    public Integer getPurchase_num() {
        return purchase_num;
    }

    public void setPurchase_num(Integer purchase_num) {
        this.purchase_num = purchase_num;
    }

    public Integer getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(Integer goods_id) {
        this.goods_id = goods_id;
    }

    public String getGoods_typeId() {
        return goods_typeId;
    }

    public void setGoods_typeId(String goods_typeId) {
        this.goods_typeId = goods_typeId;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public Integer getGoods_price() {
        return goods_price;
    }

    public void setGoods_price(Integer goods_price) {
        this.goods_price = goods_price;
    }

    public Integer getGoods_discount() {
        return goods_discount;
    }

    public void setGoods_discount(Integer goods_discount) {
        this.goods_discount = goods_discount;
    }

    public Date getGoods_startTime() {
        return goods_startTime;
    }

    public void setGoods_startTime(Date goods_startTime) {
        this.goods_startTime = goods_startTime;
    }

    public Date getGoods_endTime() {
        return goods_endTime;
    }

    public void setGoods_endTime(Date goods_endTime) {
        this.goods_endTime = goods_endTime;
    }

    public Integer getGoods_num() {
        return goods_num;
    }

    public void setGoods_num(Integer goods_num) {
        this.goods_num = goods_num;
    }

    public String getGoods_info() {
        return goods_info;
    }

    public void setGoods_info(String goods_info) {
        this.goods_info = goods_info;
    }

    @Override
    public String toString() {
        return "PurchaseGoodsVo{" +
                "purchase_id=" + purchase_id +
                ", purchase_orderNum=" + purchase_orderNum +
                ", purchase_goodsId=" + purchase_goodsId +
                ", purchase_num=" + purchase_num +
                ", goods_id=" + goods_id +
                ", goods_typeId='" + goods_typeId + '\'' +
                ", goods_name='" + goods_name + '\'' +
                ", goods_price=" + goods_price +
                ", goods_discount=" + goods_discount +
                ", goods_startTime=" + goods_startTime +
                ", goods_endTime=" + goods_endTime +
                ", goods_num=" + goods_num +
                ", goods_info='" + goods_info + '\'' +
                '}';
    }
}
