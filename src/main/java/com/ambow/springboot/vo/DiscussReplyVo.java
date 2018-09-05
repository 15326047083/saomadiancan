package com.ambow.springboot.vo;

import java.util.Date;

/**
 * 评价回复
 */
public class DiscussReplyVo {

    private Integer discussId; // 主键

    private Integer discussEnLevel; // 环境评分

    private Integer discussServiceLevel; // 服务评分

    private Integer discussQuLevel; // 味道评分

    private Date discussTime; // 评价时间

    private String discussInfo; // 评价详情

    private Integer replyId;

    private Date replyTime;

    private String replyInfo;

    @Override
    public String toString() {
        return "DiscussReplyVo{" +
                "discussId=" + discussId +
                ", discussEnLevel=" + discussEnLevel +
                ", discussServiceLevel=" + discussServiceLevel +
                ", discussQuLevel=" + discussQuLevel +
                ", discussTime=" + discussTime +
                ", discussInfo='" + discussInfo + '\'' +
                ", replyId=" + replyId +
                ", replyTime=" + replyTime +
                ", replyInfo='" + replyInfo + '\'' +
                '}';
    }

    public DiscussReplyVo() {
    }

    public DiscussReplyVo(Integer discussId, Integer discussEnLevel, Integer discussServiceLevel, Integer
            discussQuLevel, Date discussTime, String discussInfo, Integer replyId, Date replyTime, String replyInfo) {

        this.discussId = discussId;
        this.discussEnLevel = discussEnLevel;
        this.discussServiceLevel = discussServiceLevel;
        this.discussQuLevel = discussQuLevel;
        this.discussTime = discussTime;
        this.discussInfo = discussInfo;
        this.replyId = replyId;
        this.replyTime = replyTime;
        this.replyInfo = replyInfo;
    }

    public Integer getDiscussId() {
        return discussId;
    }

    public void setDiscussId(Integer discussId) {
        this.discussId = discussId;
    }

    public Integer getDiscussEnLevel() {
        return discussEnLevel;
    }

    public void setDiscussEnLevel(Integer discussEnLevel) {
        this.discussEnLevel = discussEnLevel;
    }

    public Integer getDiscussServiceLevel() {
        return discussServiceLevel;
    }

    public void setDiscussServiceLevel(Integer discussServiceLevel) {
        this.discussServiceLevel = discussServiceLevel;
    }

    public Integer getDiscussQuLevel() {
        return discussQuLevel;
    }

    public void setDiscussQuLevel(Integer discussQuLevel) {
        this.discussQuLevel = discussQuLevel;
    }

    public Date getDiscussTime() {
        return discussTime;
    }

    public void setDiscussTime(Date discussTime) {
        this.discussTime = discussTime;
    }

    public String getDiscussInfo() {
        return discussInfo;
    }

    public void setDiscussInfo(String discussInfo) {
        this.discussInfo = discussInfo;
    }

    public Integer getReplyId() {
        return replyId;
    }

    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
    }

    public Date getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }

    public String getReplyInfo() {
        return replyInfo;
    }

    public void setReplyInfo(String replyInfo) {
        this.replyInfo = replyInfo;
    }
}
