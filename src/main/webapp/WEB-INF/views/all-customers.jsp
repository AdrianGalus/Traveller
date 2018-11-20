<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Customers</title>
</head>
<body>
    There are all our customers
`   <ol>
    <c:forEach items="${allCustomers}" var="customer">
        <li>${customer}
            <a href="/details-customer/${customer.id}">Show details</a>
            <a href="/delete-customer/${customer.id}">Delete</a>
        </li>
    </c:forEach>
    </ol>
    <br/>
    <a href="/home">Home</a>
</body>
</html>
