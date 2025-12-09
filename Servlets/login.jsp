<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login - Quiz Portal</title>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/login.css">
</head>
<body>
    <div class="login-container">
        <h2>Login</h2>
        <form action="<%= request.getContextPath() %>/LoginServlet" method="post">
            <input type="text" name="username" placeholder="Username" required>
            <input type="password" name="password" placeholder="Password" required>
            <button type="submit">Login</button>
        </form>
        <hr>
        <p>New user? <a href="<%= request.getContextPath() %>/views/register.jsp">Register here</a></p>
    </div>
</body>
</html>
