<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Manage Events</title>
    <link rel="stylesheet" href="css/manage-event.css"> <!-- External CSS -->
</head>
<body>
<jsp:include page="headerafterlog.jsp" />
<%@ include file="topheadercus.jsp" %>

<div class="container">
    <h1>Manage Your Events</h1>
    
    <div class="event-section">
        <h2>Book an Event</h2>
        
        <p>Select the type of event you'd like to manage or book:</p>
        
        <!-- Button to redirect to birthday event booking form -->
        <a href="BirthdayForms.jsp" class="btn">Book Birthday Event</a>
        <a href="MusicForms.jsp" class="btn">Book Music Event</a>
        <a href="Weddingforms.jsp" class="btn">Book Wedding Event Plan</a>
        <a href="BatchForms.jsp" class="btn">Book Batch Party Event Plan</a>
        
        <!-- Future buttons can be added for other event types like Wedding, Corporate Events, etc. -->
        <!-- <a href="weddingEventForm.jsp" class="btn">Book Wedding Event</a> -->
    </div>
</div>

</body>
</html>
