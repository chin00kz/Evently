<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Birthday Booking</title>
    <link rel="stylesheet" href="css/bootstrap/bootstrap.min.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            background-color: black;
        }
        .container {
            display: grid;
            grid-template-columns: 1fr 1fr;
            grid-gap: 20px;
        }
        .form-container {
            background-color: #FFD700;
            padding: 30px;
            width: 400px;
            border-radius: 15px;
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
            transition: transform 0.3s ease-in-out;
        }
        .form-container:hover {
            transform: scale(1.02);
        }
        h2 {
            text-align: center;
            font-size: 24px;
            color: #333;
        }
        button {
            width: 100%;
            padding: 12px;
            background-color: #007BFF;
            color: white;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <jsp:include page="headerafterlog.jsp" />
    <%@ include file="topheadercus.jsp" %> 
    <div class="form-container">
        <h2>Birthday Booking Form</h2>
        <form action="BirthdayServlet" method="post">
            <div class="form-floating mb-3">
                <input type="text" class="form-control" id="name" name="name" placeholder="Your Name" required>
                <label for="name">Your Name</label>
            </div>

            <div class="form-floating mb-3">
                <input type="email" class="form-control" id="email" name="email" placeholder="name@example.com" required>
                <label for="email">Email</label>
            </div>

            <div class="form-floating mb-3">
                <input type="text" class="form-control" id="phone" name="phone" placeholder="Phone Number" required>
                <label for="phone">Phone Number</label>
            </div>
            
            <div class="form-floating mb-3">
                <input type="text" class="form-control" id="location" name="location" placeholder="Enter the address of the event location" required>
                <label for="location">Location</label>
            </div>

            <div class="form-floating mb-3">
                <input type="date" class="form-control" id="date" name="eventDate" placeholder="Event Date" required>
                <label for="date">Event Date</label>
            </div>

            <div class="form-floating mb-3">
                <input type="number" class="form-control" id="participants" name="participants" required min="1">
                <label for="participants">Participants:</label>
            </div>

            <div class="form-floating mb-3">
                <textarea class="form-control" id="requests" name="specialRequests" placeholder="Special Requests" style="height: 100px"></textarea>
                <label for="requests">Special Requests</label>
            </div>

            <button type="submit">Submit Booking</button>
        </form>
    </div>
</body>
</html>
