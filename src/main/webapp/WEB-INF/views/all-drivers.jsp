<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All drivers</title>
</head>
<body>
    There are all our drivers
`   <ol>
    <c:forEach items="${allDrivers}" var="driver">
    <li>${driver}
        </c:forEach>
</ol>
<br/>
<a href="/home">Home</a>
</body>
</html>