<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Database Home</title>
</head>
<body>
<h1><%= "Database login" %>
</h1>
<br/>
<a href="sign-up">Sign Up</a>
<form action="login-servlet" method="post">
    Enter username :<input type="text" name="username"> <br>
    Enter password :<input type="password" name="password"><br>
    <input type="submit" value="Login">
</form>
</form>
</body>
</html>