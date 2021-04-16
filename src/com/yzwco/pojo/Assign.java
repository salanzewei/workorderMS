package com.yzwco.pojo;

import java.util.Date;

public class Assign {
    private int id;
    private String executor;
    private Date executionTime;
    private String description;
    // 一个 任务 assign，应一个 项目工单 Workorder
    private Workorder wo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExecutor() {
        return executor;
    }

    public void setExecutor(String executor) {
        this.executor = executor;
    }

    public Date getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(Date executionTime) {
        this.executionTime = executionTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Workorder getWo() {
        return wo;
    }

    public void setWo(Workorder wo) {
        this.wo = wo;
    }


}
