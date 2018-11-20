<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Details</title>
</head>
<body>
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
    Tours: <a href="">Show details</a>
    <br/>
    <a href="/home">Home</a>
</body>
</html>
