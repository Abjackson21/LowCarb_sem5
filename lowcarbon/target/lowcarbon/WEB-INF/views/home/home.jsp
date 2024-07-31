<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="com.google.gson.JsonArray" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta charset="ISO-8859-1">
        <meta name="viewport" content="width=device-width, initial-scale=.1.0">
        <title>Home Page</title>
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
                <div class="dashboard-row">
                    <div class="full-row-container">
                        <h3>Total Carbon Emission</h3>
                        <p>${total_emission} (kg of CO2)</p>
                    </div>
                </div>
                <div class="dashboard-row">
                    <div class="carbon-emission-container">
                        <p>Carbon Emission By Water </p>
                        <p>(kg of CO2)</p> 
                        <h3>${water_emission}</h3>
                    </div>
                    <div class="carbon-emission-container">
                        <p>Carbon Emission By Electrict </p>
                        <p>(kg of CO2)</p> 
                        <h3>${electric_emission}</h3>
                    </div>
                    <div class="carbon-emission-container">
                        <p>Carbon Reduction By Recycle </p>
                        <p>(kg of CO2)</p> 
                        <h3>${recycle_emission}</h3>
                    </div>
                </div>
                <c:if test="${role eq 'admin'}">
                    <div class="dashboard-row">
                        <div class="full-row-container">
                            <h3>Number of Participant</h3>
                            <p>${numParticipant}</p>
                        </div>
                    </div>
                </c:if>
            </div>
            <jsp:include page = "/WEB-INF/views/app/footer.jsp"/>
        </div>
    </body>
</html>