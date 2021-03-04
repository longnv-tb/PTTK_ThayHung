/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import dao.NhanVienDAO;
import dao.NhanVienRaDeDAO;
import dao.ThanhVienDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.NhanVien;
import model.NhanVienRaDe;
import model.ThanhVien;

/**
 *
 * @author Long Coi
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String tenDangNhap = request.getParameter("username");
       String matKhau = request.getParameter("password");
       ThanhVien tv = new ThanhVien();
       tv.setTenDangNhap(tenDangNhap);
       tv.setMatKhau(matKhau);
       String url = "";
       ThanhVienDAO tvDAO = new ThanhVienDAO();
       HttpSession session = request.getSession();
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
    }
}
