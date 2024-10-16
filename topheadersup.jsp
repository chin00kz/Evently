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
            if (session != null && session.getAttribute("supUsername") != null) {
                String supUsername = (String) session.getAttribute("supUsername");
                out.print("Hello, " + supUsername);
            } else {
                out.print("Hello, Guest");
            }
        %>
    </div>
</body>
</html>
