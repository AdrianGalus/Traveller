<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit customer</title>
</head>
<body>
    <%@ include file="header.jsp"%>
    <form:form method="post" modelAttribute="customerForm">
        <form:hidden path="id"/>
        <form:input path="name" placeholder="name"/>
        <form:errors path="name"/>
        <br/>
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
        <input type="submit" value="Confirm"/>
    </form:form>
</body>
</html>
