package com.ambow.springboot.entity;

/**
 * 分类
 */
public class Type {
    private Integer id; // 主键

    private String name; // 分类名

    private Integer num; // 分类下菜品数量

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", num=" + num +
                '}';
    }

    public Type() {
    }

    public Type(Integer id, String name, Integer num) {

        this.id = id;
        this.name = name;
        this.num = num;
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
        this.name = name;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}