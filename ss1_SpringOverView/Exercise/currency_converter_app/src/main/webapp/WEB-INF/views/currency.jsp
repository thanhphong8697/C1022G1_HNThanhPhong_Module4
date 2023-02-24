<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 24/2/2023
  Time: 2:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/currency" method="get">
    <p>Enter your USD : <input type="text" name="USD" value="${usd}"></p>

    <input type="submit" value="convert">
</form>
<p>Result = ${vnd} VNĐ</p>
</body>
</html>
