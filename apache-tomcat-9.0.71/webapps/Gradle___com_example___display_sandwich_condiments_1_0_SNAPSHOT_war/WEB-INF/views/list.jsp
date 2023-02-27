<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 27/2/2023
  Time: 2:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sandwich condiments</title>
</head>
<body>
<form action="/save" method="post">
    <input type="checkbox" name="condiment" value="lettuce">Lettuce
    <input type="checkbox" name="condiment" value="tomato">Tomato
    <input type="checkbox" name="condiment" value="mustard">Mustard
    <input type="checkbox" name="condiment" value="sprouts">Sprouts
    <input type="submit" value="Submit">
</form>

<div>${sandwich}</div>
</body>
</html>
