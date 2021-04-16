<%--
  Created by IntelliJ IDEA.
  User: salan
  Date: 2021/4/9
  Time: 10:49
  添加工单页面，用户输入工单各项数据
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
            height: 33%;
            border-collapse: collapse;
            text-align: center;
            background: #fff;
            border: 1px solid #ccc;
        }
        tr:hover {
            background: #9dbde3;
        }
        tr{
            line-height: 30px;
        }
        input {
            width:100%;
            height:30px;
            border-width:0px;
            text-align:left;
        }
        textarea{
            border: none;
            width: 100%;
            height: 90px;
        }

    </style>
</head>
<body>
    <!-- 视图层输入数据，点击提交按钮后，提交到 AddWorkorderServlet进行下一步处理 -->
    <br><br><br>
    <h2 align="center">添加工单</h2>
    <form action="AddWorkorderServlet" method="post">
        <!--获取从 PubWorkorderServlet传过来的 hidden类型 项目类型 pid -->
        <input name="projectId" type="hidden" value="<%=request.getAttribute("id")%>" />

        <table border="1px" align="center">
            <tr>
                <td>创建人:</td>
                <td>
                    <input type="text" name="creater"/>
                </td>
            </tr>
            <tr>
                <td>任务描述：</td>
                <td>
                    <textarea name="description" cols="50" rows="10"></textarea>
                </td>
            </tr>
            <tr>
                <td>级别：</td>
                <td>
                    <select name="orderLevel">
                        <option value="1">一级</option>
                        <option value="2">二级</option>
                        <option value="3">三级</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="提交" style="text-align: center;" />
                </td>
            </tr>
        </table>
    </form>

</body>
</html>
