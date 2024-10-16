<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Supplier Service Details</title>
    <link rel="stylesheet" href="css/service-details.css"> <!-- CSS file for styling -->
    <script src="javascript/service-details.js"></script> <!-- Optional JS file for additional functionality -->
</head>
<body>
    <%@ include file="header.jsp" %>  <!-- Include header and topheader -->
    <%@ include file="topheadersup.jsp" %> 

    <div class="container">
        <h1>Supplier Service Details</h1>

        <!-- Table for displaying service details -->
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Supplier Name</th>
                    <th>Company Name</th>
                    <th>Email</th>
                    <th>Phone Number</th>
                    <th>Country</th>
                    <th>Service Type</th>
                    <th>Service Description</th>                   
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <!-- Loop through each service using JSTL -->
                <c:forEach var="service" items="${serviceList}">
                    <tr>
                        <td>${service.id}</td>
                        <td>${service.supplierName}</td>
                        <td>${service.companyName}</td>
                        <td>${service.email}</td>
                        <td>${service.phoneNumber}</td>
                        <td>${service.country}</td>
                        <td>${service.serviceType}</td>
                        <td>${service.serviceDescription}</td>
                       
                        <td>
                            <!-- Form to delete service -->
                            <form action="deleteserv" method="POST" onsubmit="return confirmDelete()">
                                <input type="hidden" name="serviceId" value="${service.id}">
                                <button type="submit" class="delete-btn">Delete</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <!-- Button to add new service -->
        <a href="addservice.jsp" class="btn">Add New Service</a>
    </div>
</body>
</html>
