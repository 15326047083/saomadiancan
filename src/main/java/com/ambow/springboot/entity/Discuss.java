package com.ambow.springboot.entity;

import java.util.Date;

/**
 * 评论、回复
 */
public class Discuss {
    private Integer id; // 主键

    private Integer enLevel; // 环境评分

    private Integer serviceLevel; // 服务评分

    private Integer quLevel; // 味道评分

    private Integer discussId; // 评价ID 如果评价ID存在则为回复

    private Date discussTime; // 评价时间

    private String info; // 评价详情

    public Discuss() {
    }

    public Discuss(Integer id, Integer enLevel, Integer serviceLevel, Integer quLevel, Integer discussId, Date
            discussTime, String info) {

        this.id = id;
        this.enLevel = enLevel;
        this.serviceLevel = serviceLevel;
        this.quLevel = quLevel;
        this.discussId = discussId;
        this.discussTime = discussTime;
        this.info = info;
    }

    @Override
    public String toString() {
        return "Discuss{" +
                "id=" + id +
                ", enLevel=" + enLevel +
                ", serviceLevel=" + serviceLevel +
                ", quLevel=" + quLevel +
                ", discussId=" + discussId +
                ", discussTime=" + discussTime +
                ", info='" + info + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEnLevel() {
        return enLevel;
    }

    public void setEnLevel(Integer enLevel) {
        this.enLevel = enLevel;
    }

    public Integer getServiceLevel() {
        return serviceLevel;
    }

    public void setServiceLevel(Integer serviceLevel) {
        this.serviceLevel = serviceLevel;
    }

    public Integer getQuLevel() {
        return quLevel;
    }

    public void setQuLevel(Integer quLevel) {
        this.quLevel = quLevel;
    }

    public Integer getDiscussId() {
        return discussId;
    }

    public void setDiscussId(Integer discussId) {
        this.discussId = discussId;
    }

    public Date getDiscussTime() {
        return discussTime;
    }

    public void setDiscussTime(Date discussTime) {
        this.discussTime = discussTime;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }
}