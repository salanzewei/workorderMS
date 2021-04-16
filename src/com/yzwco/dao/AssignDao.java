package com.yzwco.dao;

import com.yzwco.pojo.Assign;

import java.util.List;

public interface AssignDao {
    /**
     * 查询对应工单的所有任务
     * @param wid
     * @return Assign类型的 List
     */
    public List<Assign> queryAssignByWid(int wid);

    /**
     * 添加任务
     * @param assign
     * @return 整型，>0插入成功
     */
    public int insertAssign(Assign assign);
}
