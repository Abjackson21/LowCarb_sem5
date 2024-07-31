<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta charset="ISO-8859-1">
        <meta name="viewport" content="width=device-width, initial-scale=.1.0">
        <title>Electricity Usage</title>
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
                                <h2 class="center-align">Electric Usage Month: ${month}</h2>

                                <table class="water-table" >
                                    <thead>
                                        <tr>
                                            <th>Participant Id</th>
                                            <th>Month</th>
                                            <th>Num of Day</th>
                                            <th>Profacta Factor</th>
                                            <th>Usage (kWh)</th>
                                            <th>Usage (RM)</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="electric" items="${electricMonthList}">
                                            <c:if test="${electric.getElectric_month() eq month}">
                                                <tr class="colored hoverable">
                                                    <td>${electric.getUser_id()}</td>
                                                    <td>${electric.getElectric_month()}</td>
                                                    <td>${electric.getElectric_numday()}</td>
                                                    <td>${electric.getElectric_profacta()}</td>
                                                    <td>${electric.getElectric_usagekWh()}</td>
                                                    <td>${electric.getElectric_usagekWhRM()}</td>
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