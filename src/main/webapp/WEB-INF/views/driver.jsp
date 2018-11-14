<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Driver</title>
</head>
<body>
    Add new driver to our staff!
    <br/>
    <form:form method="post" modelAttribute="driverForm">
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
        <input type="submit" value="Add"/>
        <input type="reset" value="Clear"/>
    </form:form>
    <br/>
    <a href="/home">Home</a>
</body>
</html>
