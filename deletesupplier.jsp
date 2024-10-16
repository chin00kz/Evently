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
    		String email = request.getParameter("email");
            String username = request.getParameter("username");  	
    		String password = request.getParameter("password");
    %>
    
    <div class="update-container">
    <h2>Delete Your Account</h2>

    <form action="deletesup" method="POST">
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
                <td><label for="email">Email:</label></td>
                <td><input type="text" id="email" name="email" value="<%=email%>" readonly></td>
            </tr>
           
        </table>

        <input type="submit" name="submit" value="Delete My Account" class="btn">
    </form>
</div>

</body>
</html>