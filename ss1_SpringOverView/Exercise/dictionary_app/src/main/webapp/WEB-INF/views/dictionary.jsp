<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 24/2/2023
  Time: 3:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Your dictionary</h1>
<form action="/dictionary" method="get">
    <p>Enter the word you wanna to translate:
        <input type="text" name="word" value="${WORD}">
    </p>
    <input type="submit" value="Translate">
</form>
<p>Translation result : ${trans}</p>
</body>
</html>
