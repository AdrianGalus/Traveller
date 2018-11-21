<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All tours</title>
</head>
<body>
    <%@include file="header.jsp" %>
    There are all our tours
    <ol>
    <c:forEach items="${allTours}" var="tour">
        <li>${tour.description}
            <a href="/details-tour/${tour.id}">Show details</a>
            <a href="/delete-tour/${tour.id}">Delete</a>
        </li>
    </c:forEach>
    </ol>
</body>
</html>
