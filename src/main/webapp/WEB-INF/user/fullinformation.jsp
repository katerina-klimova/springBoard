<%--
  Created by IntelliJ IDEA.
  User: Катя
  Date: 23.07.2018
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <link rel="stylesheet" href="../../resources/simple-sidebar.css">

    <script
            src="http://code.jquery.com/jquery-3.3.1.js"
            integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
            crossorigin="anonymous">

    </script>
</head>
<body>
<div id="wrapper" class="toggled">
    <%@include file="../menuusers.jsp" %>
    <div id="page-content-wrapper">
        <form:form action="/user/items" method="get" modelAttribute="item">
            <h3><input type="hidden" name="id" value="${item.getId()}"></h3>
            <c:out value=" ${item.getName()}"/>
            <c:out value=" ${item.getDescription()}"/>
            <c:out value=" ${item.getCost()}"/>
            <c:if test=" ${item.getStatus()}">
                <p>Solded</p>
            </c:if>
            <c:if test="${ not item.getStatus()}">
                <p>Not solded</p>
            </c:if>
            <td>
                <button type="submit">Back</button>
            </td>
        </form:form>
    </div>
</div>
</body>
</html>

