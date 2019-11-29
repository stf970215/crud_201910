<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>$Title$</title>
</head>
<link rel="stylesheet" href="/static/bootstrap-3.3.7-dist/css/bootstrap.css">
<script src="/static/js/jquery-3.3.1.js"></script>
<script src="/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<body>
<div class="container">
    <div class="container-fluid">
        <form method="get" action="/sys/user/list" style="float: right">
            姓名：<input type="text" name="account">
            <input type="submit" value="查询" class="btn btn-info">
        </form>
        <a href="/userAdd.jsp" class="btn btn-success">添加</a>

        <table class="table table-bordered">
            <tr>
                <td>序号</td>
                <td>真实姓名</td>
                <td>密码</td>
                <td>性别</td>
                <td>操作</td>
            </tr>

            <c:forEach var="user" items="${list}" varStatus="status">
                <tr>
                    <td>${status.index+1}</td>
                    <td>${user.name}</td>
                    <td>${user.pwd}</td>
                    <td>
                        <c:if test="${user.sex==1}">男</c:if>
                        <c:if test="${user.sex==0}">女</c:if>
                    </td>
                    <td>
                        <a href="/sys/user/delete?id=${user.id}" class="btn btn-danger">删除</a>
                        <a href="/sys/user/toUpdate?id=${user.id}" class="btn btn-primary">修改</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <a  href="/sys/user/list?page=1&account=${account}" class="btn btn-success">首页</a>
        <a  href="/sys/user/list?page=${(page.page-1)<=0?1:(page.page-1)}&account=${account}" class="btn btn-success">上一页</a>
        <a href="/sys/user/list?page=${(page.page+1) >page.pageTotal ? page.pageTotal :(page.page+1)}&account=${account}" class="btn btn-success">下一页</a>
        <a href="/sys/user/list?page=${page.pageTotal}&account=${account}" class="btn btn-success">尾页</a>
        当前页：${page.page}，总页数：${page.pageTotal},总记录数：${page.count},每页显示记录数：${page.pageSize}
    </div>
</div>


</body>
</html>
