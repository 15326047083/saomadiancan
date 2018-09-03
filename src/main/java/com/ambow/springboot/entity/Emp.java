package com.ambow.springboot.entity;

import java.util.Date;

/**
 * 员工
 */
public class Emp {
    private Integer id; // 主键

    private String name; // 名称

    private String username; // 用户名

    private String password; // 密码

    private String roles; // 角色

    private Date entryTime; // 入职时间

    private Date leaveTime; // 离职时间 如果存在离职时间则认为该人离职

    private Integer wage; // 基本工资

    private Integer ticheng; // 提成工资 保留字段

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roles='" + roles + '\'' +
                ", entryTime=" + entryTime +
                ", leaveTime=" + leaveTime +
                ", wage=" + wage +
                ", ticheng=" + ticheng +
                '}';
    }

    public Emp() {
    }

    public Emp(Integer id, String name, String username, String password, String roles, Date entryTime, Date
            leaveTime, Integer wage, Integer ticheng) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.entryTime = entryTime;
        this.leaveTime = leaveTime;
        this.wage = wage;
        this.ticheng = ticheng;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles == null ? null : roles.trim();
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public Date getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(Date leaveTime) {
        this.leaveTime = leaveTime;
    }

    public Integer getWage() {
        return wage;
    }

    public void setWage(Integer wage) {
        this.wage = wage;
    }

    public Integer getTicheng() {
        return ticheng;
    }

    public void setTicheng(Integer ticheng) {
        this.ticheng = ticheng;
    }
}