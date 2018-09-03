package com.ambow.springboot.entity;

/**
 * 用户
 */
public class User {
    private Integer id; // 主键

    private String name; // 用户名称

    private String phone; // 手机号

    private String password; // 密码

    private Integer integral; // 积分

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", integral=" + integral +
                '}';
    }

    public User() {
    }

    public User(Integer id, String name, String phone, String password, Integer integral) {

        this.id = id;
        this.name = name;
        this.phone = phone;
        this.password = password;
        this.integral = integral;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }
}