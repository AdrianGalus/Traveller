<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Confirm tour</title>
</head>
<body>
    <%@include file="header.jsp" %>
    Confirm tour:
    Destination: ${tourForm.destination}
    <br/>
    Departure time: ${tourForm.departureTime}
    <br/>
    Arrival time: ${tourForm.arrivalTime}
    <br/>
    Distance: ${tourForm.distance}
    <br/>
    Price: ${tourForm.price}
    <br/>
    Select coach:
    <form:form action="/tour/confirm" method="post" modelAttribute="confirmedTour">
        <input type="hidden" name="tourFormId" value="${tourFormId}"/>
        <form:select path="coachId" items="${availableCoaches}" itemLabel="description" itemValue="id"/>
        <form:errors path="coachId"/>
        <br/>
        <form:select path="driversId" items="${availableDrivers}" itemLabel="description" itemValue="id"/>
        <form:errors path="driversId"/>
        <br/>
        <input type="submit" value="Confirm">
    </form:form>
</body>
</html>
