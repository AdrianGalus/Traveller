<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Details</title>
</head>
<body>
    <%@include file="header.jsp" %>
    Id: ${driverDTO.id}
    <br/>
    First name: ${driverDTO.firstName}
    <br/>
    Last name: ${driverDTO.lastName}
    <br/>
    Phone: ${driverDTO.phone}
    <br/>
    Email: ${driverDTO.email}
    <br/>
    Coach: <a href="/details-coach/${driverDTO.coachId}">Show details</a>
    <br/>
    Tours: <a href="/show-tour/driverDTO/${driverDTO.id}">Show more</a>
    <br/>
    <a href="/edit-driver/${driverDTO.id}">Edit</a>
</body>
</html>
