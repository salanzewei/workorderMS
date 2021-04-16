package com.yzwco.pojo;

import java.util.Date;

public class Workorder {
    private int id;
    private String creater;
    private String description;
    private int orderLevel;
    private Date createDate;
    private int count;
    // 一个 Workorder 对应一个 Project，而一个 Project 对应多个 Workorder
    // 多对一关联映射，可在【一】这边定义【多】的对象
    private Project project;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getOrderLevel() {
        return orderLevel;
    }

    public void setOrderLevel(int orderLevel) {
        this.orderLevel = orderLevel;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) { this.createDate = createDate;}

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }


}
