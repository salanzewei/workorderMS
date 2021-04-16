package com.yzwco.servlet;

import com.sun.corba.se.spi.orbutil.threadpool.Work;
import com.yzwco.constant.SysConstant;
import com.yzwco.dao.WorkorderDao;
import com.yzwco.dao.impl.WorkorderDaoImpl;
import com.yzwco.pojo.Project;
import com.yzwco.pojo.Workorder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/* 获取前端输入，向数据库添加工单
 * 1.获取从 pubWorkorder.jsp 页面 输入的内容
 * 2.将输入内容封装到实体类 Workorder
 * 3.调用方法，向数据库插入一条数据
 * 4.跳转到 WorkorderServlet
 */
@WebServlet(name = "AddWorkorderServlet", value = "/AddWorkorderServlet")
public class AddWorkorderServlet extends HttpServlet {
    private WorkorderDao workorderDao = new WorkorderDaoImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        // 获取 jsp 输入内容，包含隐含值 pid，默认 count=0
        String creater = request.getParameter("creater");
        String description = request.getParameter("description");
        String orderLevel = request.getParameter("orderLevel");
        String projectId = request.getParameter("projectId");

        // 放入 Workorder 对象
        Workorder wo = new Workorder();
        wo.setCreater(creater);
        wo.setDescription(description);
        wo.setOrderLevel(Integer.parseInt(orderLevel));
        wo.setCreateDate(new Date());
        wo.setCount(SysConstant.ASSGIN_COUNT); // 常量
        Project p = new Project();
        p.setId(Integer.parseInt(projectId));
        wo.setProject(p);

        // 调用函数 插入数据库
        int rs = workorderDao.insertWorkorder(wo);
        if(rs > 0){
            // flag 传输添加结果信息
            request.getSession().setAttribute("flag","添加成功");
            response.sendRedirect("WorkorderServlet");
        }else{
            request.getSession().setAttribute("flag","添加失败");
            response.sendRedirect("WorkorderServlet");
        }


    }
}
