<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<form action="/sys/user/add" method="get">

    姓名：<input type="text" name="name" value=""><br><br>
    密码：<input type="text" name="pwd" value=""><br><br>
    性别：<input type="radio" name="sex" value="1">男
    <input type="radio" name="sex" value="0">女<br><br>
    <input type="submit" value="保存">
</form>
</body>
</html>
