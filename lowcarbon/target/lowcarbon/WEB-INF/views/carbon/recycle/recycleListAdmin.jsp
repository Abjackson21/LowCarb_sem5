<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta charset="ISO-8859-1">
        <meta name="viewport" content="width=device-width, initial-scale=.1.0">
        <title>Recycle Activity</title>
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
                                <h2 class="center-align">Recycle Activity Month: ${month}</h2>

                                <table class="water-table" >
                                    <thead>
                                        <tr>
                                            <th>Participant Id</th>
                                            <th>Month</th>
                                            <th>Collected Ammount (kWh)</th>
                                            <th>Collected Amount (RM)</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="recycle" items="${recycleMonthList}">
                                            <c:if test="${recycle.getRecycle_month() eq month}">
                                                <tr class="colored hoverable">
                                                    <td>${recycle.getUser_id()}</td>
                                                    <td>${recycle.getRecycle_month()}</td>
                                                    <td>${recycle.getCollectedKG()}</td>
                                                    <td>${recycle.getCollectedRM()}</td>
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