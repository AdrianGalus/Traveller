<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
    <c:if test="${empty loggedUser}">
        <a href="/login">Login</a>
    </c:if>
    <c:if test="${not empty loggedUser}">
        <h3>Hello ${loggedUser.login}!</h3>
        <a href="/logout">Logout</a>
        <br/>
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
        <a href="/add-tour/check">Add tour</a>
        <br/>
    </c:if>
</body>
</html>
