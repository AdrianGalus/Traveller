<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
    <%@include file="header.jsp" %>
    <c:if test="${not empty loggedUser}">
        <a href="/find-driver/all">Show all drivers</a>
        <a href="/add-driver">Add driver</a>
        <br/>
        <a href="/find-coach/all">Show all coaches</a>
        <a href="/add-coach">Add coach</a>
        <br/>
        <a href="/find-customer/all">Show all customers</a>
        <a href="/add-customer">Add customer</a>
        <br/>
        <a href="/find-tour/all">Show all tours</a>
        <a href="/tour/check/0">Add tour</a>
        <br/>
    </c:if>
</body>
</html>
