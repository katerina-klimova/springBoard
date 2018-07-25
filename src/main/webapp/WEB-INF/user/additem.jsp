<%--
  Created by IntelliJ IDEA.
  User: Катя
  Date: 21.07.2018
  Time: 23:22
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
</head>
<body>
<%@include file="../menuusers.jsp" %>
    <div class="row">
        <div class="col-md-3 col-md-offset-4">
            <div>
                <form:form action="/user/additem" method="post" modelAttribute="itemForm">
                    <label for="name">Name: </label><form:input id="name" class="form-control" type="text" path="name"/>
                    <c:if test="${errorName!=null}">
                        <div class="alert alert-danger">
                                ${errorName}
                        </div>
                    </c:if>
                    <br/>
                    <label for="description">Description: </label><form:input id="description" class="form-control" type="textarea" path="description"/>
                    <br/>
                    <label for="cost">Cost: </label><form:input id="cost" class="form-control" type="number" min="0.01" step ="0.01" path="cost"/>
                    <c:if test="${errorCost!=null}">
                        <div class="alert alert-danger">
                                ${errorCost}
                        </div>
                    </c:if>
                    <br/>
                    <form:button class="btn btn-success" type="submit">Add new</form:button>
                </form:form>
                <form action="/user/items" method="get">
                    <button class="btn" type="submit">Cancel</button>
                </form>
            </div>
        </div>
    </div>

</body>
</html>
