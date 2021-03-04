<%-- 
    Document   : doLogin
    Created on : Dec 8, 2020, 5:05:11 PM
    Author     : Long Coi
--%>

<%@page import="dao.NhanVienRaDeDAO"%>
<%@page import="model.NhanVienRaDe"%>
<%@page import="dao.NhanVienDAO"%>
<%@page import="model.NhanVien"%>
<%@page import="dao.ThanhVienDAO"%>
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
            String tenDangNhap = request.getParameter("username");
            String matKhau = request.getParameter("password");
            ThanhVien tv = new ThanhVien();
            tv.setTenDangNhap(tenDangNhap);
            tv.setMatKhau(matKhau);
            String url = "";
            ThanhVienDAO tvDAO = new ThanhVienDAO();
            if(tvDAO.checkLogin(tv)){
                if(tv.getVaiTro().equalsIgnoreCase("nhanvien")){
                     NhanVien nv = new NhanVienDAO().getNhanVien(tv);
                     if(nv.getViTri().equalsIgnoreCase("nhanvienrade")){
                         NhanVienRaDe nvrd = new NhanVienRaDeDAO().getNhanVienRaDe(nv);
                         url = "/gdNhanVienRaDe.jsp";
                         session.setAttribute("nhanVienRaDe", nvrd);
                     }
                }
            }
            // forward request and response to the view
             RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
             dispatcher.forward(request, response); 
        %>
    </body>
</html>
