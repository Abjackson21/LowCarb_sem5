<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>
    <%@ include file="/WEB-INF/views/app/include-style.jsp" %>
    <%@ include file="/WEB-INF/views/app/include-js.jsp" %>
</head>
<body>
    <div class="auth-container">
        <div class="auth-register-form-container">
            <div class="auth-body">
                <div class="auth-title">
                    <h3>Register Account</h3>
                    <p>
                        Welcome! Create you account for Low Carbon Initiatives Community Monitoring System
                    </p>
                </div>

                <div class="auth-form">
                    <form action="/register" method="post" id="loginForm">
                        <div class="auth-in-form">
                            <input type="hidden" id="role" name="role" value="participant">
                            <div class="auth-form-left">
                                <div class="auth-input">
                                    <label for="email">Email:</label>
                                    <input type="email" id="email" name="email" style="width: 90%" required>
                                </div>
                                <div class="auth-input">
                                    <label for="password">Password:</label>
                                    <input type="password" id="password" name="password" style="width: 90%" minlength="8" required>
                                </div>
                                <div class="auth-input">
                                    <label for="fname">Full Name</label>
                                    <input type="text" id="fname" name="fname" style="width: 90%">
                                </div>
                                <div class="auth-input">
                                    <label for="phone">Phone number</label>
                                    <input type="text" id="phone" name="phone" style="width: 90%">
                                </div>
                            </div>
                            <div class="auth-form-right">
                                <div class="auth-input">
                                    <label for="address">Address</label>
                                    <textarea id="address" name="address" style="height:60px; width: 90%"></textarea>
                                </div>
                                <div class="auth-input">
                                    <label for="participant-category">Category</label>
                                    <select id="category" name="category" style="height:45px">
                                        <option value="A1">A1: High-Rise House in MBIP</option>
                                        <option value="A2">A2: Landed House in MBIP</option>
                                        <option value="B1">B1: Institution more than 2000</option>
                                        <option value="B2">B2: Institution less than 2000</option>
                                    </select>
                                </div>
                                <br>
                                <div class="auth-action">
                                    <input type="submit" value="Register" style= "width: 95%; font-size: larger;">
                                    <br><br>
                                    <div class="action-left">
                                        Have account already?
                                        <a href="/" class="auth-link">Login</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>