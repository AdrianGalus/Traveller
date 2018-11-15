<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Confirm tour</title>
</head>
<body>
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
    <form:form action="/confirm-tour" method="post" modelAttribute="selectCoach">
        <input type="hidden" name="tourFormId" value="${tourFormId}"/>
        <form:select path="coach" items="${availableCoaches}"/>
        <br/>
        <input type="submit" value="Confirm">
    </form:form>
    <br/>
    <a href="/check-tour">Check another term</a>
    <br/>
    <a href="/home">Home</a>
</body>
</html>
