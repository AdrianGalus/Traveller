<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Warnings</title>
</head>
<body>
    <%@ include file="header.jsp"%>
    <c:if test="${not empty error}">
        ${error}
    </c:if>
</body>
</html>
