<%--
  Created by IntelliJ IDEA.
  User: salan
  Date: 2021/4/9
  Time: 17:35
  指派任务界面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>发布工单</title>
    <style type="text/css">
        body {background-color: #becee2;}
        /*表格样式*/
        table {
            width: 40%;
            height: 35%;
            border-collapse: collapse;
            text-align: center;
            background: #fff;
            border: 1px solid #bbb7b7;
        }
        tr:hover {
            background: #9dbde3;
        }
        input {
            width:100%;
            height:100%;
            border-width:0px;
            text-align:left;
        }
        textarea{
            border: none;
            width: 100%;
            height: 105px;
        }

    </style>
</head>
<body>
<form action="AddAssignServlet" method="post">
    <!--获取从ToAddAssign传过来的 wid -->
    <input name="wid" type="hidden" value="<%=request.getAttribute("wid")%>"/>
    <br><br><br>
    <h2 align="center">指派任务</h2>
    <table border="1" align="center">
        <tr>
            <td align="center">指派人:</td>
            <td>
                <input type="text" name="executor"/>
            </td>
        </tr>
        <tr>
            <td align="center">执行时间：</td>
            <td>
                <input type="date" name="executionTime"/>
            </td>
        </tr>
        <tr >
            <td align="center">详情描述：</td>
            <td>
                <textarea name="description"></textarea>
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="提交" style="text-align: center;"/>
            </td>
        </tr>
    </table>
</form>

</body>
</html>
