<%--
  Created by IntelliJ IDEA.
  User: Катя
  Date: 16.07.2018
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="wrapper" class="toggled">
    <%@include file="../menuusers.jsp" %>
    <div id="page-content-wrapper">
        <table>
            <c:forEach items="${allnewusers}" var="user" varStatus="num">

                <tr>
                    <form:form action="/admin/newusers" method="post" modelAttribute="user">
                        <td><input type="hidden" name="login" value="${user.getLogin()}"></td>
                        <td><c:out value=" ${num.index+1}"/></td>
                        <td><c:out value=" ${user.getId()}"/></td>
                        <td><c:out value=" ${user.getLogin()}"/></td>
                        <td><c:out value=" ${user.getPassword()}"/></td>
                        <td><c:out value=" ${user.getRole()}"/></td>
                        <td><c:out value=" ${user.getFIO()}"/></td>
                        <td><c:out value=" ${user.getEmail()}"/></td>
                        <td><c:out value=" ${user.isActivity()}"/></td>
                        <td>
                            <button type="submit"> Approve</button>
                        </td>
                    </form:form>
                </tr>

            </c:forEach>
        </table>
    </div>

</div>
</body>
</html>
