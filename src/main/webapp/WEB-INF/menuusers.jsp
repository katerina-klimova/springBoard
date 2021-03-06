<%--
  Created by IntelliJ IDEA.
  User: Катя
  Date: 29.04.2018
  Time: 21:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <!-- Optional theme -->
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

    <!-- Latest compiled and minified JavaScript -->
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="../resources/main.css">
    <link rel="stylesheet" href="../resources/simple-sidebar.css">

    <script
            src="http://code.jquery.com/jquery-3.3.1.js"
            integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
            crossorigin="anonymous"></script>
    <!-- Latest compiled and minified CSS -->
</head>
<body>
<div id="sidebar-wrapper">
    <ul class="sidebar-nav">
        <li class="sidebar-brand">
            <a href="#">
                <security:authorize access="isAuthenticated()">
                    Hello, <security:authentication property="principal.username"/>
                </security:authorize>
            </a>
        </li>

        <security:authorize access="hasRole(\"ADMIN\")">
            <li>
                <a href="/admin/users">All Users</a>
            </li>
            <li>
                <a href="/admin/newusers">New Users</a>
            </li>

        </security:authorize>
        <li>
            <a href="/user/items">My items</a>
        </li>
        <li>
            <a href="/logout">Log Out</a>
        </li>
    </ul>
</div>
</body>
</html>

