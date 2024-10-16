<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Account</title>
    <link rel="stylesheet" href="css/account.css">
</head>
<body>
    <%@ include file="header.jsp" %>
      <%@ include file="topheader.jsp" %> 
    <div class="container">
        <h1>Welcome to Your Admin Account</h1>
        
        <c:forEach var="admin" items="${adminDetails}">
            <c:set var="id" value="${admin.id}"/>
            <c:set var="name" value="${admin.name}"/>
            <c:set var="username" value="${admin.username}"/>
            <c:set var="password" value="${admin.password}"/>
            
            <table class="account-table">
                <tr>
                    <th>Field</th>
                    <th>Details</th>
                </tr>
                <tr>
                    <td>ID</td>
                    <td>${admin.id}</td>
                </tr>
                <tr>
                    <td>Name</td>
                    <td>${admin.name}</td>
                </tr>
                <tr>
                    <td>Username</td>
                    <td>${admin.username}</td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td>${admin.password}</td>
                </tr>
            </table>
            </c:forEach>
            
            <c:url value="updateadmin.jsp" var="adminupdate">
               <c:param name="id" value="${id}"/>  <!-- Ensure 'aid' is being passed -->
               <c:param name="name" value="${name}"/>
               <c:param name="username" value="${username}"/>
               <c:param name="password" value="${password}"/>
           </c:url>
           <a href="${adminupdate}" class="btn">Update My Data</a>
           
           
           
      
           
           

        <a href="staffdetails" class="btn">Manage Staff</a>
        <a href="userinfo" class="btn">Manage Users</a>
        
        <div class="quote">
            <p>"A successful event is built on a foundation of thorough planning and attention to detail."</p>
        </div>
        
        <a href="universallogin.jsp" class="btn">Log Out</a>
    </div>
</body>
</html>