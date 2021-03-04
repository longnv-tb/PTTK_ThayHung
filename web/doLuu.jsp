<%-- 
    Document   : doLuu
    Created on : Dec 8, 2020, 5:02:48 PM
    Author     : Long Coi
--%>

<%@page import="dao.CauHoiDAO"%>
<%@page import="model.LuaChon"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.CauHoi"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String noiDungCh = request.getParameter("noiDungCh");
            String mucDo = request.getParameter("mucDo");
            CauHoi ch = (CauHoi) session.getAttribute("selectedCH");
            if(mucDo!=null) ch.setMucDo(mucDo);
            if(noiDungCh!=null) ch.setNoiDung(noiDungCh);

            ArrayList<LuaChon> listLC = ch.getLuaChon();
            String isTrue =  request.getParameter("istrue");
            int indexIsTrue = Integer.parseInt(isTrue);
            for(int i=0; i<listLC.size(); i++){
                LuaChon lc = listLC.get(i);
                String ndlc = request.getParameter("noiDungLC"+i);
                lc.setNoiDung(ndlc);
                if(i==indexIsTrue)
                    lc.setIsTrue(true);
                else
                    lc.setIsTrue(false);
            }
            String url = "";
            session.setAttribute("ndch", noiDungCh);
            session.setAttribute("md", mucDo);
            session.setAttribute("istrueindex", isTrue);
            CauHoiDAO chDao = new CauHoiDAO();
            if(chDao.updateCauHoi(ch)){
                url = "/gdSuaCauHoi.jsp";
                request.setAttribute("message", "Sửa thành công!");
            }
            else
                url = "/failed.jsp";

             // forward request and response to the view
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);
        %>
    </body>
</html>
