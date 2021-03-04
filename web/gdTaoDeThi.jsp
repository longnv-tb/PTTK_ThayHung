<%-- 
    Document   : gdTaoDeThi
    Created on : Dec 5, 2020, 3:39:35 PM
    Author     : Long Coi
--%>

<%@page import="model.NhanVienRaDe"%>
<%@page import="model.CauHoiDeThi"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="dao.LichThiDAO"%>
<%@page import="model.LichThi"%>
<%@page import="dao.ChungChiDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.ChungChi"%>
<%@page import="model.ThanhVien"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="gdTaoDeThi\assets\main.css">

        <title>Giao diện tổ hợp đề thi</title>
    </head>

    <body>
        <%
            NhanVienRaDe tv = (NhanVienRaDe) session.getAttribute("nhanVienRaDe");
            ArrayList<ChungChi> listCC = (ArrayList<ChungChi>) session.getAttribute("listCC");
            if(listCC==null){
                listCC = new ChungChiDAO().getChungChi();
                session.setAttribute("listCC", listCC);
            }
            ArrayList<LichThi> listLT = (ArrayList<LichThi>) session.getAttribute("listLT");
            String indexOfLichThi = (String)session.getAttribute("indexOfLichThi");
            
            if(listLT==null){
                listLT = new LichThiDAO().getLichThiByChungChi(listCC.get(0).getId(), java.util.Calendar.getInstance().getTime());
                session.setAttribute("listLT", listLT);
                session.setAttribute("indexOfChungChi", "0");
            }
            
            String strIndexCC = request.getParameter("slChungChi");

            if(strIndexCC!=null){
                    listLT = new LichThiDAO().getLichThiByChungChi(listCC.get(Integer.parseInt(strIndexCC)).getId(), java.util.Calendar.getInstance().getTime());
                    session.setAttribute("listLT", listLT);
                    session.setAttribute("indexOfChungChi", strIndexCC);
            }
            
            listLT = (ArrayList<LichThi>) session.getAttribute("listLT");
            String indexOfChungChi = (String)session.getAttribute("indexOfChungChi");
            ArrayList<CauHoiDeThi> listCHDT = (ArrayList<CauHoiDeThi>) session.getAttribute("listchdt");
            String maDe = (String)session.getAttribute("maDe");
            String tongSoCau = (String)session.getAttribute("tongSoCau");
        //    String moTa = (String)session.getAttribute("moTa");
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
                                <button type="button" class="btn ">Sửa câu hỏi</button>
                                <button type="button" class="btn">Xóa câu hỏi</button>
                                <button type="button" class="btn btn-active">Tạo đề thi</button>
                                <button type="button" class="btn">Xem thống kê</button>
                            </div>
                        </nav>
                    </div>
                    <div class="grid_column-10">
                        <div class="output">
                            <form action="gdTaoDeThi.jsp" method="post">
                                <div class="output_option">
                                    <div class="output_title"><span>Chọn chứng chỉ:</span></div>
                                    <select name="slChungChi" class="form-control form-control-lg" onchange="this.form.submit()">
                                        <%  if (listCC != null) {
                                                for (int i = 0; i < listCC.size(); i++) {
                                                    ChungChi cc = listCC.get(i);
                                        %>        
                                        <option value="<%=i%>" <%if(indexOfChungChi !=null && i==Integer.parseInt(indexOfChungChi)){%>selected="selected" <%}%>><%=listCC.get(i).getTenChungChi() + "-" + listCC.get(i).getTenNgoaiNgu()%></option>
                                        <%}
                                            }%>
                                    </select>
                                </div>
                            </form>
                            <form action="gdChonCauHoi.jsp" method="post">
                                <div class="output_option">
                                    <div class="output_title"><span>Chọn lịch thi:</span></div>
                                    <select class="form-control form-control-lg" name="slLichThi">
                                        <% if (listLT != null) {
                                                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
                                                for (int j = 0; j < listLT.size(); j++) {
                                                    LichThi lt = listLT.get(j);
                                        %>
                                        <option value="<%=j%>" <%if(indexOfLichThi!=null && j==Integer.parseInt(indexOfLichThi)){%>selected="selected"<%}%>><%="Ngày: " + sdf.format(lt.getNgayThi()) + ", bắt đầu lúc: " + lt.getGioThi() + " - " + lt.getPhongThi().getTen()%></option>
                                        <%}}%>
                                    </select>
                                </div>
                                <div class="form-group output_option">
                                    <div class="output_title"><span>Mã đề: </span></div>
                                    <input name="maDe" type="text" class="form-control form-control-lg" id="inputMaDe" placeholder="Mã đề" <%if(maDe!=null){%>value="<%=maDe%>"<%}%>>
                                </div>

                                <div class="form-group output_option">
                                    <div class="output_title"><span>Tổng số câu: </span></div>
                                    <input name="tongSoCau" type="text" class="form-control form-control-lg" id="inputTongSoCau" placeholder="Tổng số câu" <%if(tongSoCau!=null){%>value="<%=tongSoCau%>"<%}%>>
                                </div>
                                    
                                <div class="form-group output_option">
                                    <div class="output_title"><span>Mô tả: </span></div>
                                    <input name="moTa" type="text" class="form-control form-control-lg" id="inputMoTa" placeholder="Mô tả" <%if(session.getAttribute("moTa")!=null){%>value="${moTa}"<%}%>>
                                </div>
                                <div class="output_option">
                                    <div class="output_title"><span>Chọn mức độ:</span></div>
                                    <select name="slMucDoXemNH" class="form-control form-control-lg" style="width: 68%; margin-right: 12px;">
                                        <option value="easy">Easy</option>
                                        <option value="normal">Normal</option>
                                        <option value="hard">Hard</option>
                                    </select>
                                    <button type="submit" class="btn btn-outline-success" style="width: 29%; height: 48px;">Xem ngân hàng</button>
                                </div>
                            </form>  
                            <hr>
                            <br>
                            <%if(message!=null){%>
                                <h5 style="color: red; text-align: center; font-style: italic"><%=message%></h5>
                            <%}%>
                            <%if(listCHDT!=null){%>
                                <h5 style="text-align: center;">Danh sách các câu hỏi đã chọn</h5>
                                <span style="font-style: italic">Đã chọn: <%=listCHDT.size()%></span>
                                <table class="table table-striped">
                                    <thead class="thead-dark">
                                        <tr>
                                            <th style="width: 4%;" scope="col">TT</th>
                                            <th style="text-align: center;" scope="col">Nội dung</th>
                                            <th style="width: 10%;" scope="col">Mức độ</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%for(int m=0; m<listCHDT.size(); m++){%>
                                            <tr>
                                                <th scope="row"><%=(m+1)%></th>
                                                <td><%=listCHDT.get(m).getCauHoi().getNoiDung()%></td>
                                                <td><%=listCHDT.get(m).getCauHoi().getMucDo()%></td>
                                            </tr>
                                        <%}%>
                                    </tbody>
                                </table>
                            <%}%>
                            <div style="display: flex; justify-content: center;">
                                <button style="width: 100%;" type="button" class="btn btn-success" onClick="location='doTaoDeThi.jsp'">Tạo</button>
                            </div>
                            <div style="display: flex; justify-content: center;">
                                <button style="width: 100%;" type="button" class="btn btn-secondary" onClick="location='gdNhanVienRaDe.jsp'">Trở về</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="footer"></div>
        </div>
    </body>

</html>
