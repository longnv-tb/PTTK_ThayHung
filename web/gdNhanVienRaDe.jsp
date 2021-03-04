<%-- 
    Document   : gdNhanVienRaDe
    Created on : Dec 1, 2020, 11:38:07 PM
    Author     : Long Coi
--%>

<%@page import="model.NhanVienRaDe"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="gdNhanVienRaDe\assets\css\main.css">

    <title>Giao diện nhân viên ra đề</title>
</head>

<body>
    <%
            NhanVienRaDe nvrd = (NhanVienRaDe) session.getAttribute("nhanVienRaDe");
    %>
    <div class="container-fluid">
        <div class="header">
            <div class="header_user">
                <p><%=nvrd.getTen()%></p>
                <p>|</p>
                <p><%=nvrd.getViTri()%></p>
                <p>|</p>
                <a href="">
                    <span>Sign out</span>
                </a>
            </div>
        </div>
        <div class="container">
            <div class="grid_row">
                <div class="grid_column-2">
                    <nav class="category">
                        <h3 class="category_heading">Chức năng</h3>
                        <div class="category_list">
                            <button type="button" class="btn" onclick="alert('Chức năng này đang được phát triển')">Thêm câu hỏi</button>
                            <button type="button" class="btn" onclick="location='gdTimCauHoi.jsp'">Sửa câu hỏi</button>
                            <button type="button" class="btn">Xóa câu hỏi</button>
                            <button type="button" class="btn" onclick="location='gdTaoDeThi.jsp'">Tạo đề thi</button>
                            <button type="button" class="btn">Xem thống kê</button>
                        </div>
                    </nav>
                </div>
                <div class="grid_column-10"></div>
            </div>
        </div>
        <div class="footer"></div>
    </div>
</body>

</html>
