<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="'viewport" content="width=device-width, initial-scale=1.0">
<%@ include file="/WEB-INF/views/app/include-style.jsp" %>
<%@ include file="/WEB-INF/views/app/include-js.jsp" %>
</head>
<body>
    <a href="javascript:void(0)" class="bar-closebtn" onclick="bar_close()">&times;</a>
    <div class="sidebar">
        <div class="bar-MBIPlogo">
            <div>
                <img class="bar-MBIPlogo" src="/img/logoMBIP.gif" alt="MBIP logo" width="85" height="75">
            </div>
            <div>
                <p style="font-size:14.5px;">MAJLIS<br/>BANDARAYA<br/>ISKANDAR PUTERI</p>
            </div>
        </div>
        <div class="bar-page-container">
            <div class="bar-page">
                <a href="home" class="bar-item">Dashboard</a>
            </div>
            <div class="bar-page">
                <a href="waterList" class="bar-item">Water Usage</a>
            </div>
            <div class="bar-page">
                <a href="electricList" class="bar-item">Electricity Usage</a>
            </div>
            <div class="bar-page">
                <a href="recycleList" class="bar-item">Recycle Activity</a>
            </div>
            <div class="bar-page">
                <a href="profileView" class="bar-item">Profile</a>
            </div>
        </div>
    </div>
</body>
</html>