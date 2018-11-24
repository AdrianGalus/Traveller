<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit tour</title>
</head>
<body>
    <%@include file="header.jsp"%>
    <form:form method="post" modelAttribute="tourForm">
        <form:hidden path="id"/>
        <form:input path="destination" placeholder="destination"/>
        <br/>
        <form:input path="departureTime" placeholder="departureTime"/>
        <form:errors path="departureTime"/>
        <br/>
        <form:input path="arrivalTime" placeholder="arrivalTime"/>
        <form:errors path="arrivalTime"/>
        <br/>
        <form:input path="distance" placeholder="distance"/>
        <form:errors path="distance"/>
        <br/>
        <form:input path="price" placeholder="price"/>
        <form:errors path="price"/>
        <br/>
        <form:select path="customerId" items="${customers}" itemValue="id" itemLabel="description"/>
        <br/>
        <input type="submit" value="Check coach"/>
    </form:form>
</body>
</html>
