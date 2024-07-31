<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta charset="ISO-8859-1">
        <meta name="viewport" content="width=device-width, initial-scale=.1.0">
        <title>Electricity Form</title>
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
                    <div class="waterForm-container">
                        <div class="water-bill-container">
                            <h2 class="center-align">Electricity Usage</h2>

                            <c:choose>
                                <c:when test="${mode eq 'add'}">
                                    <c:set var="action" value="/addElectric" />
                                </c:when>
                                <c:otherwise>
                                    <c:set var="action" value="/editElectric" />
                                </c:otherwise>
                            </c:choose>
                            
                            <div id="water-bil">
                                <img src="/img/electric-bill.jpg" alt="electric-bill" width="400" >
                            </div>
                        </div>
                        <div class="water-container">
                            <form action="${action}" method="post" id="electricForm">
                                <div class="water-row">
                                    <div class="water-col-10">
                                        <label for="Month">Month</label>
                                    </div>
                                    <div class="water-col-35">
                                        <select id="month" name="month" style="height:45px" value="${electric.getElectric_month()}">
                                            <option value="1" ${electric.getElectric_month() == 1 ? 'selected' : ''}>January</option>
                                            <option value="2" ${electric.getElectric_month() == 2 ? 'selected' : ''}>Febuary</option>
                                            <option value="3" ${electric.getElectric_month() == 3 ? 'selected' : ''}>March</option>
                                            <option value="4" ${electric.getElectric_month() == 4 ? 'selected' : ''}>April</option>
                                            <option value="5" ${electric.getElectric_month() == 5 ? 'selected' : ''}>May</option>
                                            <option value="6" ${electric.getElectric_month() == 6 ? 'selected' : ''}>June</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="water-row">
                                    <div class="water-col-10">
                                        <label for="numday">Number of Day</label>
                                    </div>
                                    <div class="water-col-85">
                                        <input type="number" id="numday" name="numday" value="${electric.getElectric_numday()}" step="1" min="0" max="31" placeholder="Input here..." style="height:20px">
                                    </div>
                                </div>
                                <div class="water-row">
                                    <div class="water-col-10">
                                        <label for="profacta">Profacta Factor</label>
                                    </div>
                                    <div class="water-col-85">
                                        <input type="number" id="profacta" name="profacta" value="${electric.getElectric_profacta()}" step="0.0001" min="0" placeholder="Input here..." style="height:20px" required>
                                    </div>
                                </div>
                                <div class="water-row">
                                    <div class="water-col-10">
                                        <label for="usagekWh">Usage (m3)</label>
                                    </div>
                                    <div class="water-col-85">
                                        <input type="number" id="usagekWh" name="usagekWh" value="${electric.getElectric_usagekWh()}" step=".01"  min="0" placeholder="Input here..." style="height:20px" required>
                                    </div>
                                </div>
                                <div class="water-row">
                                    <div class="water-col-10">
                                        <label for="usagekWhRM">Amount (RM)</label>
                                    </div>
                                    <div class="water-col-85">
                                        <input type="number" id="usagekWhRM" name="usagekWhRM" value="${electric.getElectric_usagekWhRM()}" step="0.01" min="0" placeholder="Input here..." style="height:20px" required>
                                    </div>
                                </div>
                                
                                <br>
                                <div class="profile-row">
                                    <input type="button" onclick="window.history.back()" value="Cancel">
                                    <input type="submit" value="Submit">
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <jsp:include page = "/WEB-INF/views/app/footer.jsp"/>
        </div>
    </body>
</html>