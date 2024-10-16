<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Wedding Details</title>
    <link rel="stylesheet" href="css/staff-details.css">
    <script src="javascript/staff-details.js"></script>
</head>
<body>
    <%@ include file="headerafterlog.jsp" %>
    <%@ include file="topheadercus.jsp" %>
    <div class="container">
        <h1>Wedding Details</h1>

        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Phone</th>
                    <th>Location</th>
                    <th>Event Date</th>
                    <th>Participants</th>
                    <th>Special Requests</th>
                    <th>Actions</th> <!-- Added Actions Column -->
                </tr>
            </thead>
            <tbody>
                <c:forEach var="wed" items="${wedlist}">
                    <tr>
                        <td>${wed.id}</td>
                        <td>${wed.name}</td>
                        <td>${wed.email}</td>
                        <td>${wed.phone}</td>
                        <td>${wed.location}</td>
                        <td>${wed.eventDate}</td>
                        <td>${wed.participants}</td>
                        <td>${wed.specialRequests}</td>
                        <td>
                            <!-- Form to delete the event -->
                            <form action="WeddingEventDeleteServlet" method="POST" style="display: inline;">
                                <input type="hidden" name="eventId" value="${wed.id}">
                                <button type="submit" class="delete-btn">Delete</button>
                            </form>

                            <!-- Button to update the event -->
                            <form action="WeddingUpdateFormServlet" method="GET" style="display: inline;">
                                <input type="hidden" name="eventId" value="${wed.id}">
                                <button type="submit" class="update-btn">Update</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
