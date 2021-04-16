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
import java.text.ParseException;
import java.text.SimpleDateFormat;

/* 获取视图层输入 和 工单id，向数据库中添加任务
 * 1.获取前端输入的任务信息，封装到任务实体类
 * 2.调用函数，更新数据库
 * 3.跳转回 任务展示 servlet，并传送 工单id
 */
@WebServlet(name = "AddAssignServlet", value = "/AddAssignServlet")
public class AddAssignServlet extends HttpServlet {
    private WorkorderDao workorderDao = new WorkorderDaoImpl();
    private AssignDao assignDao = new AssignDaoImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        // 从 pubAssign.jsp 获取输入数据，包括隐含值 wid
        String wid = request.getParameter("wid");
        String executor = request.getParameter("executor");
        String executionTime = request.getParameter("executionTime");
        String description = request.getParameter("description");

        // 放入 assign 对象
        Assign assign = new Assign();
        assign.setExecutor(executor);
        try {
            assign.setExecutionTime(new SimpleDateFormat("yyyy-MM-dd").parse(executionTime));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        assign.setDescription(description);
        Workorder wo = new Workorder();
        wo.setId(Integer.parseInt(wid));
        assign.setWo(wo);

        // 调用插入函数
        int rs1 = assignDao.insertAssign(assign);
        if(rs1 > 0){
            // 新增任务成功，更新后台工单的任务指派数量
            int rs2 = workorderDao.updateCount(Integer.parseInt(wid));
            if(rs2 > 0){
                response.sendRedirect("AssignServlet?wid=" + wid);
            }else{
                response.sendRedirect("AssignServlet?wid=" + wid);
            }
        }else{
            response.sendRedirect("AssignServlet?wid=" + wid);
        }

    }
}
