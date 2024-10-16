<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Account</title>
    <link rel="stylesheet" href="css/account.css"> <!-- External CSS -->
</head>
<body>
<jsp:include page="headerafterlog.jsp" />
   <%@ include file="topheadercus.jsp" %> 
    <div class="container">
        <h1>Welcome to Your Account</h1>

        <c:forEach var="cus" items="${cusDetails}">
        
        <c:set var="id" value="${cus.id}"/>
        <c:set var="name" value="${cus.name}"/>
        <c:set var="username" value="${cus.username}"/>
        <c:set var="phone_number" value="${cus.phone_number}"/>
        <c:set var="country" value="${cus.country}"/>
        <c:set var="address" value="${cus.address}"/>
        <c:set var="gender" value="${cus.gender}"/>
        <c:set var="password" value="${cus.password}"/>
        
            <table class="account-table">
                <tr>
                    <th>Field</th>
                    <th>Details</th>
                </tr>
                
                <tr>
                    <td>ID</td>
                    <td>${cus.id}</td>
                </tr>
                <tr>
                    <td>Name</td>
                    <td>${cus.name}</td>
                </tr>
                <tr>
                    <td>Username</td>
                    <td>${cus.username}</td>
                </tr>
                <tr>
                    <td>Phone Number</td>
                    <td>${cus.phone_number}</td>
                </tr>
                <tr>
                    <td>Country</td>
                    <td>${cus.country}</td>
                </tr>
                <tr>
                    <td>Address</td>
                    <td>${cus.address}</td>
                </tr>
                <tr>
                    <td>Gender</td>
                    <td>${cus.gender}</td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td>${cus.password}</td>
                </tr>
            </table>
        </c:forEach>
        
        <c:url value="updateaccount.jsp" var="cusupdate">
           <c:param name="id" value="${id}"/>
           <c:param name="name" value="${name}"/>
           <c:param name="username" value="${username}"/>
           <c:param name="phone_number" value="${phone_number}"/>
           <c:param name="country" value="${country}"/>
           <c:param name="address" value="${address}"/>
           <c:param name="gender" value="${gender}"/>
           <c:param name="password" value="${password}"/>
        </c:url>

        <a href="${cusupdate}" class="btn">Update My Data</a>
        
        <c:url value="deletecustomer.jsp" var="cusdelete">
           <c:param name="id" value="${id}"/>
           <c:param name="name" value="${name}"/>
           <c:param name="username" value="${username}"/>
           <c:param name="phone_number" value="${phone_number}"/>
           <c:param name="country" value="${country}"/>
           <c:param name="address" value="${address}"/>
           <c:param name="gender" value="${gender}"/>
           <c:param name="password" value="${password}"/>
        </c:url>
        <a href="${cusdelete}" class="btn">Delete Account</a>

        <!-- New Buttons for Manage Event and Manage Booking -->
        <a href="manageEvent.jsp" class="btn">Book Event</a>
        <a href="WeddingViewServle" class="btn">My Events</a>
        

        <!-- Static Quote -->
        <div class="quote">
            <p>"Great events are not just planned; they are created with passion and purpose."</p>
        </div>
        
        <a href="universallogin.jsp" class="btn">Log Out</a>
    </div>
</body>
</html>
