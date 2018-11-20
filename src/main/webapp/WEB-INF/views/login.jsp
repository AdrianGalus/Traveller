<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
    <%@include file="header.jsp" %>
    <form:form method="post" modelAttribute="userForm">
        <form:input path="login" placeholder="login"/>
        <form:errors path="login"/>
        <form:password path="password" placeholder="password"/>
        <form:errors path="password"/>
        <input type="submit" value="Ok"/>
        <input type="reset" value="Clear"/>
    </form:form>
</body>
</html>
