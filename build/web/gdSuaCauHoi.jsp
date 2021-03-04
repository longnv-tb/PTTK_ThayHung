<%-- 
    Document   : gdSuaCauHoi
    Created on : Dec 2, 2020, 12:02:04 AM
    Author     : Long Coi
--%>

<%@page import="model.NhanVienRaDe"%>
<%@page import="model.ChungChi"%>
<%@page import="model.LuaChon"%>
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
        <link rel="stylesheet" href="gdSuaCauHoi\assets\css\main.css">

        <title>Giao diện sửa câu hỏi</title>
    </head>

    <body>
        <%
            NhanVienRaDe tv = (NhanVienRaDe) session.getAttribute("nhanVienRaDe");
            String istr = request.getParameter("i");
            ArrayList<CauHoi> listCH = (ArrayList<CauHoi>) session.getAttribute("listCH");
            if(istr!=null) {
                int i = Integer.parseInt(istr);
                session.setAttribute("selectedCH", listCH.get(i));
            }
            CauHoi ch = (CauHoi)session.getAttribute("selectedCH");
            String message = (String) request.getAttribute("message");
        %>
        <div class="container-fluid">
            <div class="header">
                <div class="header_user">
                    <p><%=tv.getTen()%></p>
                    <p>|</p>
                    <p><%=tv.getViTri()%></p>
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
                        <div class="output">
                            <form action="doLuu.jsp" method="post">
                                <table class="table table-striped table-bordered">
                                    <thead class="thead-dark">
                                        <tr>
                                            <th style="width: 5%;" scope="col">STT</th>
                                            <th style="width: 13%;" scope="col">Tiêu đề</th>
                                            <th style="width: 64%;" scope="col">Nội dung</th>
                                            <th style="width: 8%;" scope="col">Is true?</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%if(ch!=null){%>
                                        <tr class="table-row">
                                            <th scope="row">1</th>
                                            <td>Nội dung</td>
                                            <td><input type="text" style="width: 100%;" value="<%=ch.getNoiDung()%>" name="noiDungCh"/></td>
                                            <td>####</td>
                                        </tr>
                                        <tr class="table-row">
                                            <th scope="row">2</th>
                                            <td>Mức độ</td>
                                            <td>
                                                <select name="mucDo">
                                                    <option value="easy" <%if (ch.getMucDo().equalsIgnoreCase("easy")) {%> selected="selected" <%}%>>Easy</option>
                                                    <option value="normal" <%if (ch.getMucDo().equalsIgnoreCase("normal")) {%> selected="selected" <%}%>>Normal</option>
                                                    <option value="hard" <%if (ch.getMucDo().equalsIgnoreCase("hard")) {%> selected="selected" <%}%>>Hard</option>
                                                </select>
                                            </td>
                                            <td>####</td>
                                        </tr>
                                        <%
                                            ArrayList<LuaChon> listLuaChon = ch.getLuaChon();
                                            if (listLuaChon != null) {
                                                for (int j = 0; j < listLuaChon.size(); j++) {
                                        %>
                                        <tr class="table-row">
                                            <th scope="row"><%=(j + 3)%></th>
                                            <td>Lựa chọn <%=(j + 1)%>:</td>
                                            <td><input type="text" style="width: 100%;" value="<%=listLuaChon.get(j).getNoiDung()%>" name="noiDungLC<%=j%>"/></td>
                                            <td><input type="radio" value="<%=j%>" name="istrue" <%if (listLuaChon.get(j).isIsTrue()) {%>checked="checked"<%}%>></td>
                                        </tr>
                                        <%
                                                }
                                            }
                                        %>
                                        <%}%>
                                    </tbody>
                                </table>
                                <%if(message!=null){%>
                                <span style="color: green; text-align: center; margin-left: 36%; font-size:22px"><%=message%></span>
                                <%}%>
                                <div style="display: flex; justify-content: center; margin-top: 10px">
                                    <button style="width: 30%; margin-right: 20px" class="btn btn-secondary" onclick="location='gdTimCauHoi.jsp'" type="button">Quay lại</button>
                                    <button style="width: 50%;" type="submit" class="btn btn-success">Lưu</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <div class="footer"></div>
        </div>
    </body>
</html>
