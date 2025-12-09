<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register - Quiz Portal</title>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/register.css">
</head>
<body>
    <div class="register-container">
    <h2>Register</h2>
    <form action="<%= request.getContextPath() %>/RegisterServlet" method="post">
        <input type="text" name="username" placeholder="Username" required>
        <input type="email" name="email" placeholder="Email" required>
        <input type="password" name="password" placeholder="Password" required>
        <button type="submit">Register</button>
    </form>
    <hr>
    <p>Already have an account? <a href="<%= request.getContextPath() %>/views/login.jsp">Login here</a></p>
</div>

</body>
</html>
