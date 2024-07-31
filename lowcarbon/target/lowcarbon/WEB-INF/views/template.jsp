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
        <%@ include file="/WEB-INF/views/app/include-style.jsp" %>
        <%@ include file="/WEB-INF/views/app/include-js.jsp" %>
    </head>
    <body>
        <div id="mySidebar" class="sidebar-container">
            <jsp:include page = "/WEB-INF/views/app/sidebar.jsp"/>
        </div>
        <div id="main" class="main-container">
            <jsp:include page = "/WEB-INF/views/app/header.jsp"/>
            <div class="body-container">
                this is page template
            </div>
            <jsp:include page = "/WEB-INF/views/app/footer.jsp"/>
        </div>
    </body>
</html>