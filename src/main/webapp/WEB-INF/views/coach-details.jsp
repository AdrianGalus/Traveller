<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Details</title>
</head>
<body>
    <%@include file="header.jsp" %>
    Id: ${coachDTO.id}
    <br/>
    Registration number: ${coachDTO.registrationNumber}
    <br/>
    Mark: ${coachDTO.mark}
    <br/>
    Model: ${coachDTO.model}
    <br/>
    Drivers: <a href="/show-driver/coachDTO/${coachDTO.id}">Show more</a>
    <br/>
    Tours: <a href="/show-tour/coachDTO/${coachDTO.id}">Show more</a>
    <br/>
    <a href="/edit-coach/${coachDTO.id}">Edit</a>
</body>
</html>
