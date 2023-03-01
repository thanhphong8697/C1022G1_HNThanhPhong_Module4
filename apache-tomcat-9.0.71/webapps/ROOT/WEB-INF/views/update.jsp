<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 28/2/2023
  Time: 4:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!doctype html>
<html lang="en">
<head>
    <title>Update form</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <style>
        body {
            display: flex;
            justify-content: center;
        }

        .border {
            margin-top: 100px;
            border: 3px solid black;
            padding: 10px;
        }
    </style>
</head>
<body>
<div class="border">
    <h1 style="text-align: center">Update</h1>
    <form:form modelAttribute="mailBox" action="/updateMail" method="post">
        <div>
            <label>Languages</label>
            <form:select path="languages" items="${language}"/>
        </div>
        <div>
            <lable>Page Size: show</lable>
            <form:select path="pageSize" items="${pageSizes}"/>
            <span> emails per page</span>
        </div>
        <div>
            <lable>Spam Filter</lable>
            <form:checkbox path="spamsFilter" value="${mailBox.spamsFilter}"/>
        </div>
        <div>
            <lable>Signature</lable>
            <form:textarea path="signature"/>
        </div>
        <div style="text-align: center">
            <button type="button" class="btn btn-primary">
                <a style="color: white; text-decoration: none" href="/mail">Cancel</a>
            </button>
            <button type="submit" class="btn btn-primary">
                Update
            </button>
        </div>
    </form:form>
</div>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>
