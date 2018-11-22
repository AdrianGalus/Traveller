<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit coach</title>
</head>
<body>
    <%@include file="header.jsp" %>
    <form:form method="post" modelAttribute="coachForm">
        <form:hidden path="id"/>
        <form:input path="registrationNumber" placeholder="registrationNumber"/>
        <form:errors path="registrationNumber"/>
        <br/>
        <form:input path="model" placeholder="model"/>
        <form:errors path="model"/>
        <br/>
        <form:input path="mark" placeholder="mark"/>
        <form:errors path="mark"/>
        <br/>
        <form:select path="driversId" items="${drivers}" itemValue="id" itemLabel="description"/>
        <br/>
        <input type="submit" value="Confirm"/>
    </form:form>
</body>
</html>
