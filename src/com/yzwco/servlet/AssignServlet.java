package com.yzwco.servlet;

import com.yzwco.dao.AssignDao;
import com.yzwco.dao.WorkorderDao;
import com.yzwco.dao.impl.AssignDaoImpl;
import com.yzwco.dao.impl.WorkorderDaoImpl;
import com.yzwco.pojo.Assign;
import com.yzwco.pojo.Workorder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/* 查询指定工单的任务详情，传输给视图层
 * 1.获取从 workorder.jsp 页面传过来的 工单 id
 * 2.调用方法，查询指定工单内容，
 *           查询指定工单的所有任务
 * 3.将查询结果 工单详情 与 任务详情 传送到视图层显示
 */

@WebServlet(name = "AssignServlet", value = "/AssignServlet")
public class AssignServlet extends HttpServlet {
    private WorkorderDao workorderDao = new WorkorderDaoImpl();
    private AssignDao assignDao = new AssignDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int wid = Integer.parseInt(request.getParameter("wid"));
        Workorder wo = workorderDao.queryWorkorderByWid(wid);
        List<Assign> list = assignDao.queryAssignByWid(wid);

        request.setAttribute("workorder", wo); // 工单信息
        request.setAttribute("list", list);    // 工单对应任务列表
        request.getRequestDispatcher("assignList.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
