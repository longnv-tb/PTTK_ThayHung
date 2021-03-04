<%-- 
    Document   : doNewCauHoiDeThi
    Created on : Dec 8, 2020, 5:09:46 PM
    Author     : Long Coi
--%>

<%@page import="model.CauHoi"%>
<%@page import="model.CauHoiDeThi"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            /*danh sách checked box = danh sách index câu hỏi trong ds câu hỏi theo mức độ*/
            String[] listIndex = request.getParameterValues("slCauHoi");
            
            ArrayList<CauHoiDeThi> listchdt = (ArrayList<CauHoiDeThi>) session.getAttribute("listchdt");
            if(listchdt==null) listchdt = new ArrayList<>();

            String tongSoCau = (String)session.getAttribute("tongSoCau");
            if(Integer.parseInt(tongSoCau) < (listIndex.length + listchdt.size())){
                request.setAttribute("message", "Đã chọn quá tổng sổ câu. Chọn lại!");
                String url="/gdTaoDeThi.jsp";
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
                dispatcher.forward(request, response); 
                return;
            }

            /*danh sách câu hỏi theo mức độ trong session ở gd trước*/
            ArrayList<CauHoi> listCH = (ArrayList<CauHoi>) session.getAttribute("listSelectCH");

            /*gọi danh sách CHĐT bổ sung*/
            if (listIndex != null) {
                for(int i=0; i<listIndex.length; i++){
                    CauHoi ch = listCH.get(Integer.parseInt(listIndex[i])); /*get câu hỏi*/
                    CauHoiDeThi chdt = new CauHoiDeThi();
                    chdt.setCauHoi(ch);
                    listchdt.add(chdt);                           /*bổ sung vào ds chdt*/
                }
            }

            session.setAttribute("listchdt", listchdt);
            String url="/gdTaoDeThi.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response); 
        %>
    </body>
</html>
