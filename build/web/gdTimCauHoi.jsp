<%-- 
    Document   : gdTimCauHoi
    Created on : Dec 1, 2020, 11:56:40 PM
    Author     : Long Coi
--%>

<%@page import="model.NhanVienRaDe"%>
<%@page import="model.CauHoi"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.ThanhVien"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="gdTimCauHoi\assets\css\main.css">
    <title>Giao diện tìm câu hỏi</title>
</head>

<body>
    <%
        String inputSearch = (String) request.getAttribute("inputSearch");
        NhanVienRaDe nvrd = (NhanVienRaDe) session.getAttribute("nhanVienRaDe");
        ArrayList<CauHoi> listCH = (ArrayList<CauHoi>) session.getAttribute("listCH");
    %>
    <div class="container-fluid">
        <div class="header">
            <div class="header_user">
                <p><%=nvrd.getTen()%></p>
                <p>|</p>
                <p><%=nvrd.getVaiTro()%></p>
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
                            <button type="button" class="btn">Thêm câu hỏi</button>
                            <button type="button" class="btn btn-active">Sửa câu hỏi</button>
                            <button type="button" class="btn">Xóa câu hỏi</button>
                            <button type="button" class="btn">Tạo đề thi</button>
                            <button type="button" class="btn">Xem thống kê</button>
                        </div>
                    </nav>
                </div>
                <div class="grid_column-10">
                    <div class="search-bar">
                        <span>Nhập nội dung tìm kiếm:</span>
                        <form action="doTim.jsp" method="post">
                            <input type="text" <%if(inputSearch!=null){%>value="<%=inputSearch%>" <%}%>class="input-search" name="noiDungSearch"/>
                            <input type="submit" value="Tìm" />
                        </form>
                    </div>
                    <%if(listCH != null){%>
                            <hr>
                            <div class="output">
                                <span>Kết quả tìm được</span>
                                <table class="table table-striped table-bordered">
                                    <thead class="thead-dark">
                                        <tr>
                                            <th class="first-column" scope="col">STT</th>
                                            <th class="second-column" scope="col">Nội dung</th>
                                            <th class="third-column" scope="col">Thuộc chứng chỉ</th>
                                            <th class="forth-column" scope="col">Mức độ</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <% for(int i=0; i<listCH.size(); i++){ %>
                                            <tr class="table-row">
                                                <th scope="row"><%=i+1%></th>
                                                <td>
                                                    <a href="gdSuaCauHoi.jsp?i=<%=i%>"><%=listCH.get(i).getNoiDung()%></a>
                                                </td>
                                                <td><%=listCH.get(i).getChungChi().getTenChungChi()%></td>
                                                <td><%=listCH.get(i).getMucDo()%></td>
                                            </tr>
                                        <%}%>
                                    </tbody>
                                </table>
                            </div>
                    <%}%>
                    <div style="display: flex; justify-content: center;">
                                <button style="width: 100%;" type="button" class="btn btn-secondary" onClick="location='gdNhanVienRaDe.jsp'">Trở về</button>
                    </div>
                </div>
            </div>
        </div>
        <div class="footer"></div>
    </div>
</body>
</html>
