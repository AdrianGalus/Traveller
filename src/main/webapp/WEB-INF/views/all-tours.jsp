<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All tours</title>
</head>
<body>
    There are all our tours
`   <ol>
    <c:forEach items="${allTours}" var="tour">
    <li>${tour}
        </c:forEach>
    </ol>
    <br/>
    <a href="/home">Home</a>
</body>
</html>
