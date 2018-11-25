<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit driver</title>
</head>
<body>
    <%@ include file="header.jsp"%>
    <form:form method="post" modelAttribute="driverForm">
        <form:hidden path="id"/>
        <form:input path="firstName" placeholder="firstName"/>
        <form:errors path="firstName"/>
        <br/>
        <form:input path="lastName" placeholder="lastName"/>
        <form:errors path="lastName"/>
        <br/>
        <form:input path="phone" placeholder="phone"/>
        <form:errors path="phone"/>
        <br/>
        <form:input path="email" placeholder="email"/>
        <form:errors path="email"/>
        <br/>
        <form:select path="coachId" items="${availableCoaches}" itemValue="id" itemLabel="description"/>
        <form:errors path="coachId"/>
        <br/>
        <input type="submit" value="Confirm"/>
    </form:form>
</body>
</html>
