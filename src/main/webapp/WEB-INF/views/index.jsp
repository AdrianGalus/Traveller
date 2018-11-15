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
        <a href="/adddriver">Add driver</a>
        <a href="/editdriver">Edit driver</a>
        <a href="deletedriver">Delete driver</a>
        <br/>
        <a href="/addcoach">Add coach</a>
        <a href="/editcoach">Edit coach</a>
        <a href="/deletecoach">Delete coach</a>
        <br/>
        <a href="/addcustomer">Add customer</a>
        <a href="/editcustomer">Edit customer</a>
        <a href="/delete">Delete customer</a>
        <br/>
        <a href="/addtour">Add tour</a>
        <a href="/edittour">Edit tour</a>
        <a href="/deletetour">Delete tour</a>
        <br/>
    </c:if>
</body>
</html>
