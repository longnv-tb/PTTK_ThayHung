<%-- 
    Document   : doTim
    Created on : Dec 8, 2020, 5:04:21 PM
    Author     : Long Coi
--%>

<%@page import="model.CauHoi"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.CauHoiDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String noiDung = request.getParameter("noiDungSearch").trim();
            CauHoiDAO chDAO = new CauHoiDAO();
            ArrayList<CauHoi> listCH = new ArrayList<>();
            listCH = chDAO.searchCauHoi(noiDung);
            session.setAttribute("listCH", listCH);
            request.setAttribute("inputSearch", noiDung);
            String url = "/gdTimCauHoi.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response); 
        %>
    </body>
</html>
