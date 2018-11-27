<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Confirm delete</title>
</head>
<body>
    <%@ include file="header.jsp"%>
    <c:if test="${type == 'customer'}">
        Are you sure to delete customer about ID ${id}?
        <br/>
        <a href="/delete-customer/confirm/${id}">Yes</a> <a href="/find-customer/all">No</a>
    </c:if>
    <c:if test="${type == 'driver'}">
        Are you sure to delete driver about ID ${id}?
        <br/>
        <a href="/delete-driver/confirm/${id}">Yes</a> <a href="/find-driver/all">No</a>
    </c:if>
    <c:if test="${type == 'coach'}">
        Are you sure to delete coach about ID ${id}?
        <br/>
        <a href="/delete-coach/confirm/${id}">Yes</a> <a href="/find-coach/all">No</a>
    </c:if>
    <c:if test="${type == 'tour'}">
        Are you sure to delete tour about ID ${id}?
        <br/>
        <a href="/delete-tour/confirm/${id}">Yes</a> <a href="/find-tour/all">No</a>
    </c:if>
</body>
</html>
