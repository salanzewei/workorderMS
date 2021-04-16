<%--
  Created by IntelliJ IDEA.
  User: salan
  Date: 2021/4/9
  Time: 8:47
  选择工单类型界面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.yzwco.pojo.Project" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>项目工单类型选择</title>
</head>
<style type="text/css">
    body {background-color: #becee2;}
    /*表格样式*/
    table {
        width: 20%;
        border-collapse: collapse;
        text-align: left;
        border: 1px solid #bbb7b7;
    }
    tr:hover {
        background: #9dbde3;
    }

</style>
<body>
    <!--使用 getAttribute获取从 ProjectServlet得到的所有工单类型 -->
    <%
        List<Project> list = (List<Project>)request.getAttribute("list");
    %>
    <br><br><br><br><br>
    <h2 align="center">选择工单类型</h2>
    <table border="1" align="center">
        <tr align="center">
            <td>
                <br>
                <!--将视图层选择结果，提交给 PubWorkorderServlet 进行处理-->
                <form action="PubWorkorderServlet" method="post">
                    <select name="id">
                        <option>---请选择---</option>
                        <%
                            for(Project p : list){
                        %>
                        <!--value是传给 servlet进行处理的值，即项目类型 id-->
                        <option value="<%= p.getId() %>" >
                            <!--前端显示的是项目类型的 name-->
                            <%= p.getProjectName() %>
                        </option>
                        <% } %>
                    </select>
                    <input type="submit" value="发布工单" />
                </form>
            </td>
        </tr>
    </table>
</body>
</html>
