package com.yzwco.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/*
 * 1.获取从 projectSelect.jsp 页面选择结果，即项目类型对应 id
 * 2.传送 项目类型id 并跳转到 pubWorkorder.jsp 页面
 */
@WebServlet(name = "PubWorkorderServlet", value = "/PubWorkorderServlet")
public class PubWorkorderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取项目的ID
        String id = request.getParameter("id");
        //将项目ID存储到request作用域中
        request.setAttribute("id",id);
        //跳转到发布工单页面
        request.getRequestDispatcher("pubWorkorder.jsp").forward(request,response);
    }
}
