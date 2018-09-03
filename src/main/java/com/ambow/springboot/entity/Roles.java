package com.ambow.springboot.entity;

/**
 * 菜单
 */
public class Roles {
    private Integer id; // 主键

    private String name; // 角色名

    private String meanName; // 菜单名

    private String meanUrl; // 菜单url

    @Override
    public String toString() {
        return "Roles{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", meanName='" + meanName + '\'' +
                ", meanUrl='" + meanUrl + '\'' +
                '}';
    }

    public Roles() {
    }

    public Roles(Integer id, String name, String meanName, String meanUrl) {

        this.id = id;
        this.name = name;
        this.meanName = meanName;
        this.meanUrl = meanUrl;
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

    public String getMeanName() {
        return meanName;
    }

    public void setMeanName(String meanName) {
        this.meanName = meanName == null ? null : meanName.trim();
    }

    public String getMeanUrl() {
        return meanUrl;
    }

    public void setMeanUrl(String meanUrl) {
        this.meanUrl = meanUrl == null ? null : meanUrl.trim();
    }
}