<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Wedding Event</title>
    <link rel="stylesheet" href="css/weddingupform.css">
     <%@ include file="headerafterlog.jsp" %>
    <%@ include file="topheadercus.jsp" %>
</head>
<body>
    <h2>Update Wedding Event</h2>

    <form action="WeddingEventUpdateServlet" method="POST">
        <input type="hidden" name="eventId" value="${weddingEvent.id}">

        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${weddingEvent.name}" required>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" value="${weddingEvent.email}" required>

        <label for="phone">Phone:</label>
        <input type="text" id="phone" name="phone" value="${weddingEvent.phone}" required>

        <label for="location">Location:</label>
        <input type="text" id="location" name="location" value="${weddingEvent.location}" required>

        <label for="eventDate">Event Date:</label>
        <input type="date" id="eventDate" name="eventDate" value="${weddingEvent.eventDate}" required>

        <label for="participants">Participants:</label>
        <input type="number" id="participants" name="participants" value="${weddingEvent.participants}" required>

        <label for="specialRequests">Special Requests:</label>
        <textarea id="specialRequests" name="specialRequests">${weddingEvent.specialRequests}</textarea>

        <button type="submit">Update Event</button>
    </form>
</body>
</html>
