<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 27/2/2023
  Time: 3:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Caculator</title>
</head>
<body>

<form action="/caculator" method="post">
    <table class="table">
        <tr>
            <td>Enter number 1</td>
            <td><input type="number" name="numb1"></td>
            <td>Enter number 2</td>
            <td><input type="number" name="numb2"></td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="addition" name="method" class="btn btn-danger btn-lg">
            </td>
            <td>
                <input type="submit" value="subtraction" name="method" class="btn btn-danger btn-lg">
            </td>
            <td>
                <input type="submit" value="multiplication" name="method" class="btn btn-danger btn-lg">
            </td>
            <td>
                <input type="submit" value="division" name="method" class="btn btn-danger btn-lg">
            </td>
        </tr>
    </table>
</form>
<p>Your result: ${result}</p>
</body>
</html>
