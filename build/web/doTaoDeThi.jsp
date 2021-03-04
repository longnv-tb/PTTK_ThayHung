<%-- 
    Document   : doTaoDeThi
    Created on : Dec 7, 2020, 2:42:47 PM
    Author     : Long Coi
--%>

<%@page import="model.ChungChi"%>
<%@page import="dao.DeThiDAO"%>
<%@page import="model.CauHoiDeThi"%>
<%@page import="model.NhanVienRaDe"%>
<%@page import="model.ThanhVien"%>
<%@page import="model.DeThi"%>
<%@page import="model.LichThi"%>
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
            DeThi dt = new DeThi();
            
            ArrayList<LichThi> listLT = (ArrayList<LichThi>) session.getAttribute("listLT");
            String indexOfLichThi = (String)session.getAttribute("indexOfLichThi");
            LichThi lt = listLT.get(Integer.parseInt(indexOfLichThi));
            dt.setLichThi(lt);
            
            String moTa = (String)session.getAttribute("moTa");
            dt.setMoTa(moTa);
            
            String maDe = (String)session.getAttribute("maDe");
            dt.setMaDe(maDe);
            
            String tongSoCau = (String)session.getAttribute("tongSoCau");
            dt.setTongSoCau(Integer.parseInt(tongSoCau));
            
            NhanVienRaDe nvrd = (NhanVienRaDe)session.getAttribute("nhanVienRaDe");
            dt.setNhanVienRaDe(nvrd);
            
            ArrayList<CauHoiDeThi> listCHDT = (ArrayList<CauHoiDeThi>)session.getAttribute("listchdt");
            dt.setCauHoiDeThi(listCHDT);
            
            ArrayList<ChungChi> listCC = (ArrayList<ChungChi>)session.getAttribute("listCC");
            String indexOfChungChi = (String)session.getAttribute("indexOfChungChi");
            dt.setChungChi(listCC.get(Integer.parseInt(indexOfChungChi)));
            
            session.setAttribute("dethi", dt);
            DeThiDAO dtDAO = new DeThiDAO();
            if(dtDAO.addDeThi(dt)){
                request.setAttribute("message", "Thêm thành công");
                session.removeAttribute("listchdt");
                session.removeAttribute("listLT");
                session.removeAttribute("tongSoCau");
                session.removeAttribute("moTa");
                session.removeAttribute("maDe");
                session.removeAttribute("indexOfChungChi");
                session.removeAttribute("indexOfLichThi");
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/gdTaoDeThi.jsp");
                dispatcher.forward(request, response);
                
            }else{
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/failed.jsp");
                dispatcher.forward(request, response);
            }
        %>
    </body>
</html>
