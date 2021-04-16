package com.yzwco.dao.impl;

import com.yzwco.dao.ProjectDao;
import com.yzwco.pojo.Project;
import com.yzwco.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjectDaoImpl implements ProjectDao {

    // 查询所有项目工单类型
    @Override
    public List<Project> queryProject(){
        String sql = "select * from project";
        Connection con = JdbcUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List list = new ArrayList();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Project p = new Project();
                p.setId(rs.getInt("id"));
                p.setProjectName(rs.getString("project_name"));
                list.add(p);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtil.closeAll(con, ps, rs);
        }
        return list;
    }

}
