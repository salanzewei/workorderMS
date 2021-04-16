<%--
  Created by IntelliJ IDEA.
  User: salan
  Date: 2021/4/9
  Time: 15:16
  展示工单任务详情页面
--%>
<%@ page import="com.yzwco.pojo.Assign" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.yzwco.pojo.Workorder" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>工单任务详情</title>
    <style type="text/css">
        body {background-color: #becee2;}
        /*表格样式*/
        table.wo{
            width: 50%;
            height: 80px;
        }
        table.as{
            width: 50%;
            border-collapse: collapse;
            text-align: left;
            background: #fff;
            border: 1px solid #ccc;
        }
        table.as:hover {
            background: #9dbde3;
        }

    </style>
</head>
<body>
    <br>
    <h2 align="center">工单任务详情</h2>
    <% Workorder wo = (Workorder)request.getAttribute("workorder"); %>
    <table class="wo" align="center">
        <tr align="left">
            <td>
                <b>项目名称：</b><%=wo.getProject().getProjectName()%>
            </td>
            <td>
                <b>创建人：</b><%=wo.getCreater()%>
            </td>
            <td>
                <b>创建时间：</b><%=wo.getCreateDate()%>
            </td>
            <td class="button" align="left">
                <br>
                <!-- 点击按钮，跳转到 指派任务界面，并传输 工单id -->
                <form action="ToAddAssign" method="post">
                    <!--传工单 wid -->
                    <input name="wid" type="hidden" value="<%=wo.getId()%>" />
                    <input type="submit" value="指派任务" />
                </form>
            </td>
        </tr>
        <tr align="left">
            <td colspan="4">
                <b>任务描述：</b><%=wo.getDescription()%>
            </td>
        </tr>
    </table>
    <br>
    <%
        List<Assign> list = (List<Assign>)request.getAttribute("list");
    %>
    <% for(Assign a : list) { %>
    <table class="as" rules="none" border="1" align="center" cellpadding="9">

        <tr class="astr" align="left">
            <td><b>执行人：</b><%= a.getExecutor() %></td>
            <td><b>执行时间：</b><%= a.getExecutionTime() %></td>
        </tr>
        <tr class="astr" align="left">
            <td colspan="2"><b>详情描述：</b><%= a.getDescription() %></td>
        </tr>
    </table>
    <br>
    <% } %>

</body>
</html>
