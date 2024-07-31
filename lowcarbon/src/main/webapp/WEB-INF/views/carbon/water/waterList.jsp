<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta charset="ISO-8859-1">
        <meta name="viewport" content="width=device-width, initial-scale=.1.0">
        <title>Monthly Update</title>
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
                <div class="body-waterList">
                    <div class="waterList-table-container">
                        <div class="waterList-table">
                            <h2 class="center-align">Water Usage</h2>

                            <c:if test="${not empty errorMessage}">
                                <div style="text-align: center; color: red; font-weight: bold; border: 2px solid red; margin: 20px;">
                                    ${errorMessage}</div>
                            </c:if>

                            <table class="water-table" >
                                <thead>
                                    <tr>
                                        <th>Month</th>
                                        <th>Num of Day</th>
                                        <th>Profacta Factor</th>
                                        <th>Usage (m3)</th>
                                        <th>Usage (RM)</th>
                                        <th>Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="water" items="${waterUsageList}">
                                        <tr class="colored hoverable">
                                            <td>${water.getMonth()}</td>
                                            <td>${water.getNumday()}</td>
                                            <td>${water.getProfacta()}</td>
                                            <td>${water.getUsagem3()}</td>
                                            <td>${water.getUsagem3RM()}</td>
                                            <td>
                                                <div class=" btn-table">
                                                    <a class="btn-edit" href="/formEditWater?month=${water.getMonth()}">
                                                        edit
                                                    </a>
                                                </div>
                                                <div class="btn-table">
                                                    <!-- <a class="btn-delete" href="javascript:void(0);" onclick="confirmDelete('${water.getMonth()}')">
                                                        delete
                                                    </a>  -->
                                                    <a class="btn-delete" href="/deleteWater?month=${water.getMonth()} " >
                                                        delete
                                                    </a> 
                                                </div>
                                            </td>

                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                            <a class="btn-add" href="/formAddWater">Add Water Usage</a>
                        </div>
                    </div>
                </div>
            </div>
            <jsp:include page = "/WEB-INF/views/app/footer.jsp"/>
        </div>
    </body>
</html>