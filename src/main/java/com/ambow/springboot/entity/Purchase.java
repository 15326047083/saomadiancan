package com.ambow.springboot.entity;

/**
 * 中间表
 */
public class Purchase {
    private Integer id; // 主键

    private Long orderNum; // 订单号

    private Integer goodsId; // 商品ID

    private Integer num; // 商品数量

    @Override
    public String toString() {
        return "Purchase{" +
                "id=" + id +
                ", orderNum=" + orderNum +
                ", goodsId=" + goodsId +
                ", num=" + num +
                '}';
    }

    public Purchase() {
    }

    public Purchase(Integer id, Long orderNum, Integer goodsId, Integer num) {

        this.id = id;
        this.orderNum = orderNum;
        this.goodsId = goodsId;
        this.num = num;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Long orderNum) {
        this.orderNum = orderNum;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}