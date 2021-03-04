/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CauHoiDeThi;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.CauHoi;
import model.CauHoiDeThi;

/**
 *
 * @author Long Coi
 */
public class doNewCauHoiDeThiServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        
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
    }

}
