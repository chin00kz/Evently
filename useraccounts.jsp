<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Accounts Details</title>
    <link rel="stylesheet" href="css/staff-details.css">
    <script src="javascript/staff-details.js"></script>
</head>
<body>
    <%@ include file="header.jsp" %>
    <%@ include file="topheader.jsp" %>
    <div class="container">
        <h1>User Account Details</h1>

        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Phone Number</th>
                    <th>Address</th>
                    <th>Country</th>
                    <th>Gender</th>
                    <th>Username</th>
                    
                </tr>
            </thead>
            <tbody>
                <c:forEach var="cus" items="${cuslist}">
                    <tr>
                        <td>${cus.id}</td>
                        <td>${cus.name}</td>
                        <td>${cus.phone_number}</td>
                        <td>${cust.address}</td>
                        <td>${cus.country}</td>
                        <td>${cus.gender}</td>
                        <td>${cus.username}</td>
                        
                        
                    </tr>
                </c:forEach>
            </tbody>
        </table>

      
    </div>
</body>
</html>