<%-- 
    Document   : gdChonCauHoi
    Created on : Dec 5, 2020, 10:14:08 PM
    Author     : Long Coi
--%>

<%@page import="model.NhanVienRaDe"%>
<%@page import="model.CauHoiDeThi"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<%@page import="dao.CauHoiDAO"%>
<%@page import="model.CauHoi"%>
<%@page import="model.ChungChi"%>
<%@page import="java.util.ArrayList"%>
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
        <link rel="stylesheet" href="gdChonCauHoi\css\main.css">
        <title>Giao diện chọn câu hỏi</title>
    </head>

    <body>
        <%
            NhanVienRaDe tv = (NhanVienRaDe) session.getAttribute("nhanVienRaDe");
            
            String maDe = request.getParameter("maDe");
            String tongSoCau = request.getParameter("tongSoCau");

            if(maDe.equalsIgnoreCase("") || tongSoCau.equalsIgnoreCase("")){
                request.setAttribute("message", "Nhập mã đề và tổng số câu trước");
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/gdTaoDeThi.jsp");
                dispatcher.forward(request, response);  
                return;
            }
            try{
                int tsc = Integer.parseInt(tongSoCau);
            }catch(Exception e){
                request.setAttribute("message", "Tổng số câu không hợp lệ!");
//                request.setAttribute("tongSoCauErr",tongSoCau);
//                request.setAttribute("maDe", maDe);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/gdTaoDeThi.jsp");
                dispatcher.forward(request, response);  
                return;
            }
            
            session.setAttribute("tongSoCau", tongSoCau);
            session.setAttribute("maDe", maDe);
            
            String moTa = request.getParameter("moTa");
            session.setAttribute("moTa", moTa);

            String indexOfLichThi = request.getParameter("slLichThi");
            session.setAttribute("indexOfLichThi", indexOfLichThi);
            
            String indexOfChungChi = (String)session.getAttribute("indexOfChungChi");

            /*danh sách câu hỏi theo mức độ*/
            String strMucDo = request.getParameter("slMucDoXemNH");
            ArrayList<CauHoi> listch = new CauHoiDAO().getCauHoiByMucDo(strMucDo);
            ArrayList<CauHoiDeThi> listchdt = (ArrayList<CauHoiDeThi>) session.getAttribute("listchdt");
            if(listchdt!=null){
                for(int i=0; i<listch.size(); i++){
                    for(int j=0; j<listchdt.size(); j++){
                        if(listchdt.get(j).getCauHoi().getId() == listch.get(i).getId()){
                            listch.remove(listch.get(i));
                        }
                    }
                }
            }
            session.setAttribute("listSelectCH", listch);
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
                            <h3><%=indexOfLichThi%></h3>
                            <h3><%=indexOfChungChi%></h3>
                            <div class="category_list">
                            </div>
                        </nav>
                    </div>
                    <div class="grid_column-10">
                        <span>Mức độ: <%=strMucDo%></span>
                        <br>
                        <%if (listch != null) {%>
                            <form action="doNewCauHoiDeThi.jsp" method="post">
                                <table class="table table-striped table-bordered">
                                    <thead class="thead-dark">
                                        <tr>
                                            <th style="width: 4%;" scope="col">TT</th>
                                            <th style="width: 12%">Chứng chỉ</th>
                                            <th scope="col">Nội dung</th>
                                            <th style="width: 10%;" scope="col">Select?</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%for(int i=0; i<listch.size(); i++){ CauHoi ch = listch.get(i);%>
                                            <tr>
                                                <th scope="row"><%=(i+1)%></th>
                                                <td><%=ch.getChungChi().getTenChungChi()%></td>
                                                <td><%=ch.getNoiDung()%></td>
                                                <td style="text-align: center;"><input name="slCauHoi" value="<%=i%>" class="form-check-input" type="checkbox" id="inlineCheckbox1"></td>
                                            </tr>
                                        <%}%>
                                    </tbody>
                                </table>
                                <button style="width: 50%; margin-left: 25%;" type="submit" class="btn btn-primary">OK</button>
                            </form>
                        <%}%>
                    </div>
                </div>
            </div>
            <div class="footer"></div>
        </div>
    </body>

</html>
