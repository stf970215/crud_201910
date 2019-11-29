<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<form action="/sys/user/update" method="get">
    <%--隐藏域--%>
    <input type="text" name="id" value="${user.id}" style="display:none;">
        <input type="text" hidden name="id" value="${user.id}">
    姓名：<input type="text" name="name" value="${user.name}"><br><br>
    密码：<input type="text" name="pwd" value="${user.pwd}"><br><br>
    性别：<input type="radio" name="sex" value="1"
              <c:if test="${user.sex==1}">checked</c:if> >男
    <input type="radio" name="sex" value="0"
           <c:if test="${user.sex==0}">checked</c:if> >女<br><br>
    <input type="submit" value="修改">
</form>
</body>
</html>
