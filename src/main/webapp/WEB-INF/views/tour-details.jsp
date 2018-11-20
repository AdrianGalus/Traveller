<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Details</title>
</head>
<body>
    <%@include file="header.jsp" %>
    Id: ${tourDTO.id}
    <br/>
    Destination: ${tourDTO.destination}
    <br/>
    Departure time: ${tourDTO.departureTime}
    <br/>
    Arrival time: ${tourDTO.arrivalTime}
    <br/>
    Distance: ${tourDTO.distance}
    <br/>
    Price: ${tourDTO.price}
    <br/>
    Customer: <a href="/details-customer/${tourDTO.customerId}">Show details</a>
    <br/>
    Coach: <a href="/details-coach/${tourDTO.coachId}">Show details</a>
    <br/>
    Drivers: ?
</body>
</html>
