<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All drivers</title>
</head>
<body>
    <%@include file="header.jsp" %>
    There are all our drivers
    <ol>
    <c:forEach items="${allDrivers}" var="driver">
        <li>
            ${driver.description}
            <a href="/details-driver/${driver.id}">Show details</a>
            <a href="/delete-driver/${driver.id}">Delete</a>
        </li>
    </c:forEach>
    </ol>
</body>
</html>
