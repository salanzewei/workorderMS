package com.yzwco.dao.impl;

import com.yzwco.dao.AssignDao;
import com.yzwco.pojo.Assign;
import com.yzwco.pojo.Workorder;
import com.yzwco.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AssignDaoImpl implements AssignDao {
    // 查询指定工单的所有任务
    @Override
    public List<Assign> queryAssignByWid(int wid){
        String sql = "select * from assign where workorder_id = ?";
        Connection con = JdbcUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Assign> list = new ArrayList();
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, wid);
            rs = ps.executeQuery();
            while(rs.next()){
                Assign assign = new Assign();
                assign.setId(rs.getInt("id"));
                assign.setExecutor(rs.getString("executor"));
                assign.setExecutionTime(rs.getDate("execution_time"));
                assign.setDescription(rs.getString("description"));
                Workorder w = new Workorder();
                w.setId(wid);
                assign.setWo(w);

                list.add(assign);
                // 验证
                System.out.println("wid from sql:" + assign.getWo().getId());
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally{
            JdbcUtil.closeAll(con, ps, rs);
        }
        return list;
    }

    // 新增任务
    @Override
    public int insertAssign(Assign assign) {
        String sql = "insert into assign values (null,?,?,?,?)";
        Connection con = JdbcUtil.getConnection();
        PreparedStatement ps = null;
        int rs = -1;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, assign.getWo().getId());
            ps.setString(2, assign.getExecutor());
            ps.setDate(3, new java.sql.Date(assign.getExecutionTime().getTime()));
            ps.setString(4,assign.getDescription());
            rs = ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtil.closeAll(con, ps, null);
        }
        return rs;
    }
}
