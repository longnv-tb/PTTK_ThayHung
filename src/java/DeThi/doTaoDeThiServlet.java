/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DeThi;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.CauHoiDeThi;
import model.DeThi;
import model.LichThi;
import model.NhanVienRaDe;
import model.ThanhVien;

/**
 *
 * @author Long Coi
 */
public class doTaoDeThiServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String maDe = request.getParameter("maDe");
        String tongSoCau = request.getParameter("tongSoCau");
        String moTa = request.getParameter("moTa");
        String indexLT = request.getParameter("slLichThi");
        ArrayList<LichThi> listLT = (ArrayList<LichThi>) session.getAttribute("listLT");
        LichThi lt = listLT.get(Integer.parseInt(indexLT));
        
        DeThi dt = new DeThi();
        dt.setLichThi(lt);
        dt.setChungChi(lt.getChungChi());
        dt.setMaDe(maDe);
        dt.setTongSoCau(Integer.parseInt(tongSoCau));
        dt.setMoTa(moTa);
        
        ArrayList<CauHoiDeThi> listCHDT = (ArrayList<CauHoiDeThi>)session.getAttribute("listCHDT");
        dt.setCauHoiDeThi(listCHDT);
        
        ThanhVien nvrd = (ThanhVien) session.getAttribute("thanhVien");
        dt.setNhanVienRaDe((NhanVienRaDe)nvrd);
        
        session.setAttribute("dethi", dt);
        String url = "/test.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

}
