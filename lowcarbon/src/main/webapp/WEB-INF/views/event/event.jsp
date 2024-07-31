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
            <jsp:include page = "/WEB-INF/views/app/sidebarAdmin.jsp"/>
        </div>
        <div id="main" class="main-container">
            <jsp:include page = "/WEB-INF/views/app/header.jsp"/>
            <div class="body-container">
                <div class="body-calendar">
                    <div class="calendar-title">
                        <h3>Iskandar Putri Calendar</h3>
                    </div>
                    <div class="calendar-container">
                        <div class="calendar-left">
                            <div class="calendar-header">
                                <div class="calendar-navigation">
                                    <span id="calendar-prev" class="material-symbols-rounded"><i class="arrow left"></i></span>
                                </div>
                                <p class="calendar-current-date"></p>
                                <div class="calendar-navigation">
                                    <span id="calendar-next" class="material-symbols-rounded"><i class="arrow right"></i></span>
                                </div>
                            </div>
                            <div class="calendar-body">
                                <ul class="calendar-weekdays">
                                    <li>Sun</li>
                                    <li>Mon</li>
                                    <li>Tue</li>
                                    <li>Wed</li>
                                    <li>Thu</li>
                                    <li>Fri</li>
                                    <li>Sat</li>
                                </ul>
                                <ul class="calendar-dates"></ul>
                            </div>
                        </div>
                        <div class="calendar-right">
                            
                            <div class="selected-date">
                                <div class="event-day"></div>
                                <div class="event-date"></div>
                            </div>

                            <div class="event-container">
                                <br>
                                <div class="events">
                                    <div class="event-name"></div>
                                    <div class="event-time">
                                        <div class="event-time-from">Time:  </div>
                                        <div class="event-time-to"> -  </div>
                                    </div>
                                    <div class="event-desc"></div>
                                </div>
                            </div>

                            <br>
                            <div class="add-event-footer">
                                <button class="open-add-event" onclick="openAddEventForm()">+</button>
                            </div>

                            <div class="add-event-form" id="addEventForm">
                                <span class="close-add-event" onclick="closeAddEventForm()">&times;</span>
                                <h3>Add Event</h3>
                                <form action="/addEvent" method="post">
                                    Event Name: 
                                    <input type="text" name="event_name" style="width:300px" required><br><br>
                                    Event Description:
                                    <div>
                                        <textarea id="event_desc" name="event_desc" style="width:300px" required></textarea>
                                    </div>
                                    <br>
                                    Event Date: <input type="date" name="event_date" required><br><br>
                                    Time From: <input type="time" name="time_from" required><br><br>
                                    Time To: <input type="time" name="time_to" required><br><br>
                                    <input type="submit" value="Add Event">
                                </form>
                            </div> 
                        </div> 
                    </div>
                </div>
            </div>
            <jsp:include page = "/WEB-INF/views/app/footer.jsp"/>
        </div>
        <script>
            var eventsList = ${events};
            console.log(eventsList);
        </script>
        <script src="/js/calendar.js"></script>
    </body>
</html>