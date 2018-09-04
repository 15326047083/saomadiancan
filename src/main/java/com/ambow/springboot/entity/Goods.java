package com.ambow.springboot.entity;

import java.util.Date;

/**
 * 商品
 */
public class Goods {
    private Integer id; // 主键

    private String typeId; // 类型ID

    private String name; // 商品名

    private Integer price; // 单价

    private Integer discount; // 折后价

    private Date startTime; // 打折开始

    private Date endTime; // 打折借书

    private Integer num; // 月销售量

    private String info; // 详情

    private Integer start;

    private Integer rows;
    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", typeId='" + typeId + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", num=" + num +
                ", info='" + info + '\'' +
                '}';
    }

    public Goods() {
    }

    public Goods(Integer id, String typeId, String name, Integer price, Integer discount, Date startTime, Date
            endTime, Integer num, String info) {

        this.id = id;
        this.typeId = typeId;
        this.name = name;
        this.price = price;
        this.discount = discount;
        this.startTime = startTime;
        this.endTime = endTime;
        this.num = num;
        this.info = info;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }
}