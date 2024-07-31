<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <%@ include file="/WEB-INF/views/app/include-style.jsp" %>
    <%@ include file="/WEB-INF/views/app/include-js.jsp" %>
</head>
<body>
    <div class="auth-container">
        <div class="auth-form-container">
            <div class="auth-body">
                <div class="auth-title">
                    <h3>Login</h3>
                    <p>
                        Welcome back! Login to Low Carbon Initiatives Community Monitoring System
                    </p>
                </div>

                <div class="auth-form">
                    <form action="/login" method="post" id="loginForm">
                        <div class="auth-input">
                            <label for="email">Email:</label>
                            <input type="email" id="email" name="email" style="width: 90%" required>
                        </div>
                        <div class="auth-input">
                            <label for="password">Password:</label>
                            <input type="password" id="password" name="password" style="width: 90%" minlength="8" required>
                        </div>
                        <div class="auth-action">
                            <input type="submit" value="Login" style= "width: 95%; font-size: larger;">
                            <br><br>
                            <div class="action-left">
                                New Participant?
                                <a href="registerForm" class="auth-link">Register</a>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>