<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Support Staff Details</title>
    <link rel="stylesheet" href="css/staff-details.css">
    <script src="javascript/staff-details.js"></script>
</head>
<body>
    <%@ include file="header.jsp" %>
    <%@ include file="topheader.jsp" %>
    <div class="container">
        <h1>Support Staff Details</h1>

        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Username</th>
                    <th>Password</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="staff" items="${staffList}">
                    <tr>
                        <td>${staff.id}</td>
                        <td>${staff.name}</td>
                        <td>${staff.email}</td>
                        <td>${staff.username}</td>
                        <td>${staff.password}</td>
                        <td>
                            <form action="deletestaffad" method="POST" onsubmit="return confirmDelete()">
                                <input type="hidden" name="staffid" value="${staff.id}">
                                <button type="submit" class="delete-btn">Delete</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <a href="addstaff.jsp" class="btn">Add New Staff Account</a>
    </div>
</body>
</html>