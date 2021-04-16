package com.yzwco.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/* 获取任务详情页 对应的的工单id，传输给添加任务界面
 * 1. 从 assignList.jsp 页面获取 工单 id
 * 2. 传送 工单id，跳转到 pubAssign.jsp
 */

@WebServlet(name = "ToAddAssign", value = "/ToAddAssign")
public class ToAddAssign extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String wid = request.getParameter("wid");
        //System.out.println("wid from ToAddAssign:" + wid);
        request.setAttribute("wid", wid);
        request.getRequestDispatcher("pubAssign.jsp").forward(request, response);
    }
}
