<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta charset="ISO-8859-1">
        <meta name="viewport" content="width=device-width, initial-scale=.1.0">
        <title>Home Page</title>
        <link rel="stylesheet" href="/static/css/main-style.css">
        <%@ include file="/WEB-INF/views/app/include-style.jsp" %>
        <%@ include file="/WEB-INF/views/app/include-js.jsp" %>
    </head>
    <body>
        <div id="mySidebar" class="sidebar-container">
            <c:choose>
                <c:when test="${role eq 'admin'}">
                    <jsp:include page = "/WEB-INF/views/app/sidebarAdmin.jsp"/>
                </c:when>
                <c:otherwise>
                    <jsp:include page = "/WEB-INF/views/app/sidebarParticipant.jsp"/>
                </c:otherwise>
            </c:choose>
        </div>
        <div id="main" class="main-container">
            <jsp:include page = "/WEB-INF/views/app/header.jsp"/>
            <div class="body-container">
                <div class="body-profile">
                    <div class="profile-pic-container">
                        <div id="profile-pic">
                            <img src="/img/user.png" alt="userpic" width="100" height="100">
                        </div>
                        <div id="profile-name">
                            <p><b>Category ${user.getCategory()}</b></p>
                            <p>${user.getFullName()}</p>
                        </div>
                    </div>
                    <div class="profile-edit-btn">
                        <a href="profileUpdateForm">Edit Profile</a>
                    </div>
                    <div class="profile-container">
                        <div class="profile-row">
                            <div class="profile-col-10">
                                <label for="fname">Full Name</label>
                            </div>
                            <div class="profile-col-85">
                                <div class="profile-data" style="height:20px">
                                    ${user.getFullName()}
                                </div>
                            </div>
                        </div>
                        <div class="profile-row">
                            <div class="profile-col-10">
                                <label for="address">Address</label>
                            </div>
                            <div class="profile-col-85">
                                <div class="profile-data" style="height:60px">
                                    ${user.getAddress()}
                                </div>
                            </div>
                        </div>
                        <div class="profile-row">
                            <div class="profile-col-10">
                                <label for="email">Email</label>
                            </div>
                            <div class="profile-col-35">
                                <div class="profile-data" style="height:20px">
                                    ${user.getEmail()}
                                </div>
                            </div>
                        </div>
                        <div class="profile-row">
                            <div class="profile-col-10">
                                <label for="phone">Phone number</label>
                            </div>
                            <div class="profile-col-35">
                                <div class="profile-data" style="height:20px">
                                    ${user.getPhoneNumber()}
                                </div>
                            </div>
                        </div>
                        <div class="profile-row">
                            <div class="profile-col-10">
                                <label for="participant-category">Category</label>
                            </div>
                            <div class="profile-col-35">
                                <div class="profile-data" style="height:20px">
                                    <c:choose>
                                        <c:when test="${user.getCategory() eq 'A1'}">
                                            A1: High-Rise House in MBIP
                                        </c:when>
                                        <c:when test="${user.getCategory() eq 'A2'}">
                                            A2: Landed House in MBIP
                                        </c:when>
                                        <c:when test="${user.getCategory() eq 'B1'}">
                                            B1: Institution more than 2000
                                        </c:when>
                                        <c:when test="${user.getCategory() eq 'B2'}">
                                            B2: Institution less than 2000
                                        </c:when>
                                        <c:otherwise>
                                            Admin
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                            </div>
                        </div>
                        </div>
                    </div>
                </div>
            </div>
            <jsp:include page = "/WEB-INF/views/app/footer.jsp"/>
        </div>
    </body>
</html>