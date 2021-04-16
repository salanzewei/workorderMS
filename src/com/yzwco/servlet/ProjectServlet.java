package com.yzwco.servlet;

import com.yzwco.dao.ProjectDao;
import com.yzwco.dao.impl.ProjectDaoImpl;
import com.yzwco.pojo.Project;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

/*
 * 1.查询数据库，获取工单的所有项目类型
 * 2.将项目类型传送到视图层用于显示
 */

@WebServlet(name = "ProjectServlet", value = "/ProjectServlet")
public class ProjectServlet extends HttpServlet {
    private ProjectDao projectDao = new ProjectDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Project> list= projectDao.queryProject(); // 调用查询 Project表的方法
        request.setAttribute("list", list); // 传输 查询结果 给视图层
        request.getRequestDispatcher("projectSelect.jsp").forward(request, response); // 跳转到 jsp
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
