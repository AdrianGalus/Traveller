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
        <a href="">Add driver</a>
        <br/>
        <a href="">Add coach</a>
        <br/>
        <a href="">Add customer</a>
        <br/>
        <a href="">Add tour</a>
        <br/>
    </c:if>
</body>
</html>
