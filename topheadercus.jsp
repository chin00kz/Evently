<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" href="css/topheader.css">

</head>
<body>
    <div class="top-header">
        <%
            // Use the implicit session object
            if (session != null && session.getAttribute("userUsername") != null) {
                String userUsername = (String) session.getAttribute("userUsername");
                // Display username in the top header
                out.print("Hello, " + userUsername);
            } else {
                out.print("Hello, Guest");
            }
        %>
    </div>
</body>
</html>
