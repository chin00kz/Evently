<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Account</title>
    <link rel="stylesheet" href="css/account.css"> <!-- External CSS -->
</head>
<body>
 <%@ include file="header.jsp" %>
      <%@ include file="topheadersup.jsp" %> 
    <div class="container">
        <h1>Welcome to Your Supplier Account</h1>

        <c:forEach var="sup" items="${supDetails}">
        
        <c:set var="id" value="${sup.id}"/>
        <c:set var="name" value="${sup.name}"/>
        <c:set var="email" value="${sup.email}"/>
        <c:set var="username" value="${sup.username}"/>
        <c:set var="password" value="${sup.password}"/>
        
        
        
        
            <table class="account-table">
                <tr>
                    <th>Field</th>
                    <th>Details</th>
                </tr>
                <tr>
                    <td>ID</td>
                    <td>${sup.id}</td>
                </tr>
                <tr>
                    <td>Name</td>
                    <td>${sup.name}</td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td>${sup.email}</td>
                </tr>
                <tr>
                    <td>Username</td>
                    <td>${sup.username}</td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td>${sup.password}</td>
                </tr>
                
            </table>
        </c:forEach>
             
         <c:url value="updatestaff.jsp" var="staffupdate">
               <c:param name="id" value="${id}"/>  <!-- Ensure 'aid' is being passed -->
               <c:param name="name" value="${name}"/>
               <c:param name="email" value="${email}"/>
               <c:param name="username" value="${username}"/>
               <c:param name="password" value="${password}"/>
           </c:url>
           <a href="${staffupdate}" class="btn">Update My Data</a>
           
        
        <c:url value="deletesupplier.jsp" var="supdelete">
           <c:param name="id" value="${id}"/>
           <c:param name="name" value="${name}"/>
           <c:param name="email" value="${email}"/>
           <c:param name="username" value="${username}"/>
           <c:param name="password" value="${password}"/>
          
        </c:url>
        <a href="${supdelete}" class="btn">Delete My Account</a>

        <!-- New Buttons for Manage Event and Manage Booking -->
        <a href="serviceinfo" class="btn">Manage Service</a>
        <a href="WeddingViewServle" class="btn">Events List</a>
        

        <!-- Static Quote -->
        <div class="quote">
            <p>"A successful event is built on a foundation of thorough planning and attention to detail."</p>
        </div>

        <a href="universallogin.jsp" class="btn">Log Out</a>
    </div>
</body>
</html>
