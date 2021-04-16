package com.yzwco.servlet;

import com.yzwco.dao.WorkorderDao;
import com.yzwco.dao.impl.WorkorderDaoImpl;
import com.yzwco.pojo.Workorder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/* 查询数据库中所有工单，传输给视图层显示
 * 1.调用方法，查询数据库中所有工单
 * 2.将查询结果 放入 list
 * 3.传送给 视图层 显示
 */

@WebServlet(name = "WorkorderServlet", value = "/WorkorderServlet")
public class WorkorderServlet extends HttpServlet {
    private WorkorderDao workorderDao = new WorkorderDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Workorder> list= workorderDao.queryWorkorder();
        request.setAttribute("list", list);
        request.getRequestDispatcher("workorder.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
