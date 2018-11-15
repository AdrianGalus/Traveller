<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All coaches</title>
</head>
<body>
    This is the whole our fleet
    <ol>
        <c:forEach items="${allCoaches}" var="coach">
            <li>${coach}
        </c:forEach>
    </ol>
    <br/>
    <a href="/home">Home</a>
</body>
</html>
