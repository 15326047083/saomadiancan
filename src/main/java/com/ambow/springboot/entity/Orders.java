package com.ambow.springboot.entity;

import java.util.Date;

/**
 * 订单
 */
public class Orders {
    private Integer id; // 主键

    private Long orderNum; // 订单号 自动生成20位左右

    private Integer allPrice; // 总价值

    private Date generateTime; // 生成时间

    private Integer userId; // 用户ID 如果不登陆则为空

    private Integer state; // 订单状态 0为未支付 1为微信支付 2为支付宝支付 3为线下支付

    private Integer deskNum; // 桌号 扫码自带桌号，无需填写

    private Integer peopleNum; // 用餐人数


    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", orderNum=" + orderNum +
                ", allPrice=" + allPrice +
                ", generateTime=" + generateTime +
                ", userId=" + userId +
                ", state=" + state +
                ", deskNum=" + deskNum +
                ", peopleNum=" + peopleNum +
                '}';
    }

    public Orders() {
    }

    public Orders(Integer id, Long orderNum, Integer allPrice, Date generateTime, Integer userId, Integer state,
                  Integer deskNum, Integer peopleNum) {

        this.id = id;
        this.orderNum = orderNum;
        this.allPrice = allPrice;
        this.generateTime = generateTime;
        this.userId = userId;
        this.state = state;
        this.deskNum = deskNum;
        this.peopleNum = peopleNum;
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

    public Integer getAllPrice() {
        return allPrice;
    }

    public void setAllPrice(Integer allPrice) {
        this.allPrice = allPrice;
    }

    public Date getGenerateTime() {
        return generateTime;
    }

    public void setGenerateTime(Date generateTime) {
        this.generateTime = generateTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getDeskNum() {
        return deskNum;
    }

    public void setDeskNum(Integer deskNum) {
        this.deskNum = deskNum;
    }

    public Integer getPeopleNum() {
        return peopleNum;
    }

    public void setPeopleNum(Integer peopleNum) {
        this.peopleNum = peopleNum;
    }


}