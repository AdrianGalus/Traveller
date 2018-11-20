<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Details</title>
</head>
<body>
    Id: ${coachDTO.id}
    <br/>
    Registration number: ${coachDTO.registrationNumber}
    <br/>
    Mark: ${coachDTO.mark}
    <br/>
    Model: ${coachDTO.model}
    <br/>
    Drivers: ?
    <br/>
    Tours: ?
    <br/>
    <a href="/home">Home</a>
</body>
</html>
