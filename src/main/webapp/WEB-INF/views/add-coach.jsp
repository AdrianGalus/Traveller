<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New coach</title>
</head>
<body>
    <%@include file="header.jsp" %>
    Add new coach to our fleet!
    <br/>
    <form:form method="post" modelAttribute="coachForm">
        <form:input path="registrationNumber" placeholder="registrationNumber"/>
        <form:errors path="registrationNumber"/>
        <br/>
        <form:input path="mark" placeholder="mark"/>
        <form:errors path="mark"/>
        <br/>
        <form:input path="model" placeholder="model"/>
        <form:errors path="model"/>
        <br/>
        <input type="submit" value="Add"/>
        <input type="reset" value="Clear"/>
    </form:form>
</body>
</html>
