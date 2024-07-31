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
            <jsp:include page = "/WEB-INF/views/app/sidebarAdmin.jsp"/>
        </div>
        <div id="main" class="main-container">
            <jsp:include page = "/WEB-INF/views/app/header.jsp"/>
            <div class="body-container">
                <div class="body-waterList">
                    <div class="waterList-table-container">
                        <c:forEach var="month" items="${months}">  
                            <div class="waterList-table">
                                <h2 class="center-align">Water Usage Month: ${month}</h2>

                                <table class="water-table" >
                                    <thead>
                                        <tr>
                                            <th>Participant Id</th>
                                            <th>Month</th>
                                            <th>Num of Day</th>
                                            <th>Profacta Factor</th>
                                            <th>Usage (m3)</th>
                                            <th>Usage (RM)</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="water" items="${waterMonthList}">
                                            <c:if test="${water.getMonth() eq month}">
                                                <tr class="colored hoverable">
                                                    <td>${water.getUserId()}</td>
                                                    <td>${water.getMonth()}</td>
                                                    <td>${water.getNumday()}</td>
                                                    <td>${water.getProfacta()}</td>
                                                    <td>${water.getUsagem3()}</td>
                                                    <td>${water.getUsagem3RM()}</td>
                                                </tr>
                                            </c:if>
                                        </c:forEach>
                                    </tbody>
                                </table>
                                <br><br><br><br><br><br>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
            <jsp:include page = "/WEB-INF/views/app/footer.jsp"/>
        </div>
    </body>
</html>