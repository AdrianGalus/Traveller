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
        <a href="/add-driver">Add driver</a>
        <a href="/edit-driver">Edit driver</a>
        <a href="/delete-driver">Delete driver</a>
        <br/>
        <a href="/add-coach">Add coach</a>
        <a href="/edit-coach">Edit coach</a>
        <a href="/delete-coach">Delete coach</a>
        <br/>
        <a href="/add-customer">Add customer</a>
        <a href="/edit-customer">Edit customer</a>
        <a href="/delete-customer">Delete customer</a>
        <br/>
        <a href="/check-tour">Add tour</a>
        <a href="/edit-tour">Edit tour</a>
        <a href="/delete-tour">Delete tour</a>
        <br/>
    </c:if>
</body>
</html>
