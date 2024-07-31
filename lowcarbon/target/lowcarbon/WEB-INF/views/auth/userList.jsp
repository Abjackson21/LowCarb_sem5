<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta charset="ISO-8859-1">
        <meta name="viewport" content="width=device-width, initial-scale=.1.0">
        <title>Participant List</title>
        <%@ include file="/WEB-INF/views/app/include-style.jsp" %>
        <%@ include file="/WEB-INF/views/app/include-js.jsp" %>
    </head>
    <body>
        <div id="mySidebar" class="sidebar-container">
            <jsp:include page = "/WEB-INF/views/app/sidebarAdmin.jsp"/>
        </div>
        <div id="main" class="main-container">
            <jsp:include page = "/WEB-INF/views/app/header.jsp"/>
            <div class="body-container">
                <div class="body-waterList">
                    <div class="waterList-table-container">
                        <div class="waterList-table">
                            <h2 class="center-align">List of Participant</h2>

                            <table class="water-table" >
                                <thead>
                                    <tr>
                                        <th>Category</th>
                                        <th>Id</th>
                                        <th>Name</th>
                                        <th>Email</th>
                                        <th>Phone Number</th>
                                        <th>Address</th>
                                        <th>Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="user" items="${userA1}">
                                        <tr class="colored hoverable">
                                            <td>${user.getCategory()}</td>
                                            <td>${user.getUser_id()}</td>
                                            <td>${user.getFullName()}</td>
                                            <td>${user.getEmail()}</td>
                                            <td>${user.getPhoneNumber()}</td>
                                            <td>${user.getAddress()}</td>
                                            <td>
                                                <div class="btn-table">
                                                    <!-- <a class="btn-delete" href="javascript:void(0);" onclick="confirmDelete('${water.getMonth()}')">
                                                        delete
                                                    </a>  -->
                                                    <a class="btn-delete" href=" " >
                                                        delete
                                                    </a> 
                                                </div>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    <c:forEach var="user" items="${userA2}">
                                        <tr class="colored hoverable">
                                            <td>${user.getCategory()}</td>
                                            <td>${user.getUser_id()}</td>
                                            <td>${user.getFullName()}</td>
                                            <td>${user.getEmail()}</td>
                                            <td>${user.getPhoneNumber()}</td>
                                            <td>${user.getAddress()}</td>
                                            <td>
                                                <div class="btn-table">
                                                    <!-- <a class="btn-delete" href="javascript:void(0);" onclick="confirmDelete('${water.getMonth()}')">
                                                        delete
                                                    </a>  -->
                                                    <a class="btn-delete" href="/deleteParticipant?participantId=${user.getUser_id()} " >
                                                        delete
                                                    </a> 
                                                </div>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    <c:forEach var="user" items="${userB1}">
                                        <tr class="colored hoverable">
                                            <td>${user.getCategory()}</td>
                                            <td>${user.getUser_id()}</td>
                                            <td>${user.getFullName()}</td>
                                            <td>${user.getEmail()}</td>
                                            <td>${user.getPhoneNumber()}</td>
                                            <td>${user.getAddress()}</td>
                                            <td>
                                                <div class="btn-table">
                                                    <!-- <a class="btn-delete" href="javascript:void(0);" onclick="confirmDelete('${water.getMonth()}')">
                                                        delete
                                                    </a>  -->
                                                    <a class="btn-delete" href="# " >
                                                        delete
                                                    </a> 
                                                </div>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    <c:forEach var="user" items="${userB2}">
                                        <tr class="colored hoverable">
                                            <td>${user.getCategory()}</td>
                                            <td>${user.getUser_id()}</td>
                                            <td>${user.getFullName()}</td>
                                            <td>${user.getEmail()}</td>
                                            <td>${user.getPhoneNumber()}</td>
                                            <td>${user.getAddress()}</td>
                                            <td>
                                                <div class="btn-table">
                                                    <!-- <a class="btn-delete" href="javascript:void(0);" onclick="confirmDelete('${water.getMonth()}')">
                                                        delete
                                                    </a>  -->
                                                    <a class="btn-delete" href="# " >
                                                        delete
                                                    </a> 
                                                </div>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
            <jsp:include page = "/WEB-INF/views/app/footer.jsp"/>
        </div>
    </body>
</html>