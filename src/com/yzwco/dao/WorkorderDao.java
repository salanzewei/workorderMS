package com.yzwco.dao;

import com.yzwco.pojo.Workorder;

import java.util.List;

public interface WorkorderDao {
    /**
     *【多表连接查询】查询 workorder 表所有内容，其中项目表单类型查询，需连接 project表
     * @return
     */
    public List<Workorder> queryWorkorder();

    /**
     * 根据指定工单号，查询工单信息
     * @param wid
     * @return 查询到的工单 实体
     */
    public Workorder queryWorkorderByWid(int wid);

    /**
     * 新增工单
     * @param workorder
     * @return 整形值，若大于 0 则插入成功
     */
    public int insertWorkorder(Workorder workorder);

    /**
     * 更新工单指派数量
     * @param wid 工单 id
     * @return 整形值，若大于 0 则更新成功
     */
    public int updateCount(int wid);

}
