<%--
  Created by IntelliJ IDEA.
  User: Катя
  Date: 20.04.2018
  Time: 10:27
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
</head>
<body>
<div id="wrapper" class="toggled">
    <%@include file="../menuusers.jsp" %>
    <div id="page-content-wrapper">
        <h2>My Items</h2>
        <table>
            <c:out value="${noitems}"></c:out>
            <c:forEach items="${allitems}" var="item" varStatus="num">
                <tr>


                    <td><c:out value=" ${num.index+1}"/></td>
                    <td><c:out value=" ${item.getName()}"/></td>
                    <td><c:out value=" ${item.getCost()}"/></td>
                    <form  action="/user/items/${item.getId()}" method="get" >
                        <td><button type="submit" >Full information</button><td>

                    </form>
                </tr>
            </c:forEach>
        </table>
        <br />
        <form  action="/user/additem" method="get" >
            <button type="submit" >Add item</button>
        </form>
    </div>
</div>
</body>
</html>
