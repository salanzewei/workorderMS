package com.yzwco.dao.impl;

import com.yzwco.dao.WorkorderDao;
import com.yzwco.pojo.Project;
import com.yzwco.pojo.Workorder;
import com.yzwco.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WorkorderDaoImpl implements WorkorderDao {
    // 查询所有工单
    @Override
    public List<Workorder> queryWorkorder(){
        // 连接两个表再查询，降序排列结果
        String sql = "select w.id id, w.creater creater, w.description description, " +
                "w.order_level order_level, w.create_date create_date, w.count count, " +
                "p.project_name pname, p.id pid from workorder w left join project p " +
                "on w.project_id = p.id order by w.id desc";
        Connection con = JdbcUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Workorder> list = new ArrayList();

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Workorder wo = new Workorder();
                wo.setId(rs.getInt("id"));
                wo.setCreater(rs.getString("creater"));
                wo.setDescription(rs.getString("description"));
                wo.setOrderLevel(rs.getInt("order_level"));
                wo.setCreateDate(rs.getDate("create_date"));
                wo.setCount(rs.getInt("count"));
                // 根据查询结果，构造 Project对象
                Integer pid = rs.getInt("pid");
                if(pid != null){
                    Project p = new Project();
                    p.setId(pid);
                    p.setProjectName(rs.getString("pname"));
                    wo.setProject(p); // 向 Workorder 中插入 Project 对象
                }
                //System.out.println(rs.getString("creater"));
                list.add(wo); // Workorder 对象加入list
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtil.closeAll(con, ps, rs);
        }
        return list;
    }

    // 查询指定工单id的工单
    @Override
    public Workorder queryWorkorderByWid(int wid){
        // 连接两个表再查询，降序排列结果
        String sql = "select w.id id, w.creater creater, w.description description, " +
                "w.order_level order_level, w.create_date create_date, w.count count, " +
                "p.project_name pname, p.id pid from workorder w left join project p " +
                "on w.project_id = p.id where w.id = ? order by w.id desc";
        Connection con = JdbcUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Workorder wo = new Workorder();
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, wid);
            rs = ps.executeQuery();
            while(rs.next()){
                wo.setId(rs.getInt("id"));
                wo.setCreater(rs.getString("creater"));
                wo.setDescription(rs.getString("description"));
                wo.setOrderLevel(rs.getInt("order_level"));
                wo.setCreateDate(rs.getDate("create_date"));
                wo.setCount(rs.getInt("count"));
                // 根据查询结果，构造 Project对象
                Integer pid = rs.getInt("pid");
                if(pid != null){
                    Project p = new Project();
                    p.setId(pid);
                    p.setProjectName(rs.getString("pname"));
                    wo.setProject(p); // 向 Workorder 中插入 Project 对象
                }
                //System.out.println(rs.getString("creater"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtil.closeAll(con, ps, rs);
        }
        return wo;
    }

    // 插入工单
    @Override
    public int insertWorkorder(Workorder wo){
        String sql = "insert into workorder values (null,?,?,?,?,?,?)";
        Connection con = JdbcUtil.getConnection();
        PreparedStatement ps = null;
        int rs = -1;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,wo.getProject().getId());
            ps.setString(2,wo.getCreater());
            ps.setString(3, wo.getDescription());
            ps.setInt(4, wo.getOrderLevel());
            ps.setDate(5, new java.sql.Date(wo.getCreateDate().getTime()));
            ps.setInt(6,wo.getCount());

            rs = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtil.closeAll(con, ps, null);
        }
        return rs;
    }

    // 更新指定工单号的任务指派数量
    @Override
    public int updateCount(int wid){
        String sql = "update workorder set count = count + 1 where id = ?";
        Connection con = JdbcUtil.getConnection();
        PreparedStatement ps = null;
        int rs = -1;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, wid);
            rs = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtil.closeAll(con, ps, null);
        }
        return rs;
    }
}
