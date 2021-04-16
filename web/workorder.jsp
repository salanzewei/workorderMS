<%--
  Created by IntelliJ IDEA.
  User: salan
  Date: 2021/4/9
  Time: 11:16
  展示 workorder 表内容
--%>
<%@ page import="com.yzwco.pojo.Workorder" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>工单列表</title>
    <style type="text/css">
        body {background-color: #becee2;}
        /*表格样式*/
        table {
            width:85%;
            background: #ccc;
            margin: 10px auto;
            border-collapse: collapse;/*border-collapse:collapse合并内外边距(去除表格单元格默认的2个像素内外边距*/
        }
        th,td {
            height: 25px;
            line-height: 25px;
            text-align: center;
            border: 1px solid #ccc;
        }
        tr {
            background: #fff;
        }
        tr.head{
            background: #9dbde3;
            font-weight: bold;
        }
        tr:hover {
            background: #9dbde3;
        }
        td a {
            color: #06f;
            text-decoration: none;
        }
        td a:hover {
            color: #06f;
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <%
        List<Workorder> list = (List<Workorder>) request.getAttribute("list");
    %>
    <br>
    <h2 align="center">企业工单列表</h2>
    <table>
        <tr class="head" align="center">
            <td>工单编号</td>
            <td>项目名称</td>
            <td>创建人</td>
            <td>任务描述</td>
            <td>级别</td>
            <td>指派数量</td>
            <td>创建时间</td>
            <td>操作</td>
        </tr>
        <%
            for(Workorder wo : list){
        %>
        <tr align="center">
            <td>
                <%=wo.getId() %>
            </td>
            <td>
                <%=wo.getProject().getProjectName() %>
            </td>
            <td>
                <%=wo.getCreater() %>
            </td>
            <td>
                <%=wo.getDescription() %>
            </td>
            <td>
                <%=wo.getOrderLevel()==1?"1级":wo.getOrderLevel()==2?"2级":"3级" %>
            </td>
            <td>
                <%=wo.getCount() %>
            </td>
            <td>
                <%=wo.getCreateDate() %>
            </td>
            <td>
                <!--跳转到获取工单任务servlet，并传送工单id -->
                <a href="AssignServlet?wid=<%=wo.getId()%>">详情</a>
            </td>
        </tr>

        <% } %>
        <tr>
            <td colspan="8" align="center" style="color: red">
                <!--获取从AddWorkorderServlet传送过来的 flag，只要不取值，可以跨servlet传送？？？-->
                <%=request.getSession().getAttribute("flag") %>
            </td>
        </tr>
    </table>
</body>
</html>
