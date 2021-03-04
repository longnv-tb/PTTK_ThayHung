<%-- 
    Document   : test1
    Created on : Dec 8, 2020, 12:08:35 AM
    Author     : Long Coi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String value = request.getParameter("test");
        %>
        <h1><%=value%></h1>
        <form action="test1.jsp" method="get">
            <input type="text" name="test" />
            <input type="submit" value="Submit"/>
        </form>
    </body>
</html>
