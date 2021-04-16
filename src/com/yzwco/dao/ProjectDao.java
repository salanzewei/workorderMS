package com.yzwco.dao;

import com.yzwco.pojo.Project;

import java.util.List;

public interface ProjectDao {
    /**
     * 查询所有项目工单类型
     * @return Project类型的 list
     */
    public List<Project> queryProject();
}
