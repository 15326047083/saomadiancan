package com.ambow.springboot.entity;

import java.util.Date;

/**
 * 采购
 */
public class Buy {
    private Integer id; // 主键

    private String name; // 材料名称

    private String num; // 采购数量

    private Date buyDate; // 采购日期

    private Integer price; // 单价

    private Integer userId; // 采购员ID

    private String info; // 备注

    @Override
    public String toString() {
        return "Buy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", num='" + num + '\'' +
                ", buyDate=" + buyDate +
                ", price=" + price +
                ", userId=" + userId +
                ", info='" + info + '\'' +
                '}';
    }

    public Buy() {
    }

    public Buy(Integer id, String name, String num, Date buyDate, Integer price, Integer userId, String info) {
        this.id = id;
        this.name = name;
        this.num = num;
        this.buyDate = buyDate;
        this.price = price;
        this.userId = userId;
        this.info = info;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num == null ? null : num.trim();
    }

    public Date getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(Date buyDate) {
        this.buyDate = buyDate;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }
}