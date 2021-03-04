<%-- 
    Document   : test
    Created on : Dec 2, 2020, 2:38:01 PM
    Author     : Long Coi
--%>

<%@page import="model.CauHoiDeThi"%>
<%@page import="model.DeThi"%>
<%@page import="model.LuaChon"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.CauHoi"%>
<%@page import="model.ThanhVien"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            DeThi dt = (DeThi) session.getAttribute("dethi");
            ArrayList<CauHoiDeThi> listCHDT = dt.getCauHoiDeThi();
        %>
        <h1>IDChungChi:<%=dt.getChungChi()%></h1>
        <h1>Id lich thi:<%=dt.getLichThi()%></h1>
         <h1>ma de:<%=dt.getMaDe()%></h1>
         <h1>tong so cau:<%=dt.getTongSoCau()%></h1>
         <h1>mo ta: <%=dt.getMoTa()%></h1>
        <h1>id:<%=dt.getId()%></h1>
        <h1>nvrd: <%=dt.getNhanVienRaDe()%></h1>
        <h1><%=dt.getCauHoiDeThi()%></h1>
        <%for(int i=0; i<listCHDT.size(); i++){%>
        <h5><%=i%>:<%=listCHDT.get(i).getCauHoi().getNoiDung()%></h5>
        <%}%>
        
    </body>
</html>
