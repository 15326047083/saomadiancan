package com.ambow.springboot.vo;

import java.util.Date;

public class EmpBuyVo {
    private Integer empId; // 主键

    private String empName; // 名称

    private String empUsername; // 用户名

    private String empPassword; // 密码

    private String empRoles; // 角色

    private Date empEntryTime; // 入职时间

    private Date empLeaveTime; // 离职时间 如果存在离职时间则认为该人离职

    private Integer empWage; // 基本工资

    private Integer empTicheng; // 提成工资 保留字段

    private Integer buyId; // 主键

    private String buyName; // 材料名称

    private String buyNum; // 采购数量

    private Date buyDate; // 采购日期

    private Integer buyPrice; // 单价

    private Integer buyUserId; // 采购员ID应该是EmpId

    private String buyInfo; // 备注

    public EmpBuyVo() {
    }

    public EmpBuyVo(Integer empId, String empName, String empUsername, String empPassword, String empRoles, Date
            empEntryTime, Date empLeaveTime, Integer empWage, Integer empTicheng, Integer buyId, String buyName,
                    String buyNum, Date buyDate, Integer buyPrice, Integer buyUserId, String buyInfo) {

        this.empId = empId;
        this.empName = empName;
        this.empUsername = empUsername;
        this.empPassword = empPassword;
        this.empRoles = empRoles;
        this.empEntryTime = empEntryTime;
        this.empLeaveTime = empLeaveTime;
        this.empWage = empWage;
        this.empTicheng = empTicheng;
        this.buyId = buyId;
        this.buyName = buyName;
        this.buyNum = buyNum;
        this.buyDate = buyDate;
        this.buyPrice = buyPrice;
        this.buyUserId = buyUserId;
        this.buyInfo = buyInfo;
    }

    @Override
    public String toString() {
        return "EmpBuyVo{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empUsername='" + empUsername + '\'' +
                ", empPassword='" + empPassword + '\'' +
                ", empRoles='" + empRoles + '\'' +
                ", empEntryTime=" + empEntryTime +
                ", empLeaveTime=" + empLeaveTime +
                ", empWage=" + empWage +
                ", empTicheng=" + empTicheng +
                ", buyId=" + buyId +
                ", buyName='" + buyName + '\'' +
                ", buyNum='" + buyNum + '\'' +
                ", buyDate=" + buyDate +
                ", buyPrice=" + buyPrice +
                ", buyUserId=" + buyUserId +
                ", buyInfo='" + buyInfo + '\'' +
                '}';
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpUsername() {
        return empUsername;
    }

    public void setEmpUsername(String empUsername) {
        this.empUsername = empUsername;
    }

    public String getEmpPassword() {
        return empPassword;
    }

    public void setEmpPassword(String empPassword) {
        this.empPassword = empPassword;
    }

    public String getEmpRoles() {
        return empRoles;
    }

    public void setEmpRoles(String empRoles) {
        this.empRoles = empRoles;
    }

    public Date getEmpEntryTime() {
        return empEntryTime;
    }

    public void setEmpEntryTime(Date empEntryTime) {
        this.empEntryTime = empEntryTime;
    }

    public Date getEmpLeaveTime() {
        return empLeaveTime;
    }

    public void setEmpLeaveTime(Date empLeaveTime) {
        this.empLeaveTime = empLeaveTime;
    }

    public Integer getEmpWage() {
        return empWage;
    }

    public void setEmpWage(Integer empWage) {
        this.empWage = empWage;
    }

    public Integer getEmpTicheng() {
        return empTicheng;
    }

    public void setEmpTicheng(Integer empTicheng) {
        this.empTicheng = empTicheng;
    }

    public Integer getBuyId() {
        return buyId;
    }

    public void setBuyId(Integer buyId) {
        this.buyId = buyId;
    }

    public String getBuyName() {
        return buyName;
    }

    public void setBuyName(String buyName) {
        this.buyName = buyName;
    }

    public String getBuyNum() {
        return buyNum;
    }

    public void setBuyNum(String buyNum) {
        this.buyNum = buyNum;
    }

    public Date getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(Date buyDate) {
        this.buyDate = buyDate;
    }

    public Integer getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(Integer buyPrice) {
        this.buyPrice = buyPrice;
    }

    public Integer getBuyUserId() {
        return buyUserId;
    }

    public void setBuyUserId(Integer buyUserId) {
        this.buyUserId = buyUserId;
    }

    public String getBuyInfo() {
        return buyInfo;
    }

    public void setBuyInfo(String buyInfo) {
        this.buyInfo = buyInfo;
    }
}
