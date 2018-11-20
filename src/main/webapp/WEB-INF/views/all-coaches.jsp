<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All coaches</title>
</head>
<body>
    <%@include file="header.jsp" %>
    This is the whole our fleet
    <ol>
    <c:forEach items="${allCoaches}" var="coach">
        <li>${coach}
            <a href="/details-coach/${coach.id}">Show details</a>
            <a href="/delete-coach/${coach.id}">Delete</a>
        </li>
    </c:forEach>
    </ol>
</body>
</html>
