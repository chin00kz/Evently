<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Account</title>
 <link rel="stylesheet" href="css/delete-account-style.css">

</head>
<body>

   <%
            String id = request.getParameter("id");
    		String name = request.getParameter("name");
            String username = request.getParameter("username");
    		String phone_number = request.getParameter("phone_number");
    		String country = request.getParameter("country");
    		String address = request.getParameter("address");
    		String gender = request.getParameter("gender");
    		String password = request.getParameter("password");
    %>
    
    <div class="update-container">
    <h2>Delete Your Account</h2>

    <form action="delete" method="POST">
        <input type="hidden" name="id" value="<%=id%>">

        <table>
            <tr>
                <td><label for="username">Username:</label></td>
                <td><input type="text" id="username" name="username" value="<%=username%>" readonly></td>
            </tr>
            <tr>
                <td><label for="name">Name:</label></td>
                <td><input type="text" id="name" name="name" value="<%=name%>" readonly></td>
            </tr>
            <tr>
                <td><label for="password">Password:</label></td>
                <td><input type="password" id="password" name="password" value="<%=password%>" readonly></td>
            </tr>
            <tr>
                <td><label for="phone">Phone Number:</label></td>
                <td><input type="text" id="phone" name="phone_number" value="<%=phone_number%>" readonly></td>
            </tr>
            <tr>
                <td><label for="country">Country:</label></td>
                <td><input type="text" id="country" name="country" value="<%=country%>" readonly></td>
            </tr>
            <tr>
                <td><label for="address">Address:</label></td>
                <td><input type="text" id="address" name="address" value="<%=address%>" readonly></td>
            </tr>
        </table>

        <input type="submit" name="submit" value="Delete My Account" class="btn">
    </form>
</div>

</body>
</html>