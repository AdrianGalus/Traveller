<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New customer</title>
</head>
<body>
    <%@include file="header.jsp" %>
    Add new customer to our contacts!
    <form:form method="post" modelAttribute="customerForm">
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
        <form:input path="nip" placeholder="nip"/>
        <form:errors path="nip"/>
        <br/>
        <input type="submit" value="Add"/>
        <input type="reset" value="Clear"/>
    </form:form>
</body>
</html>
