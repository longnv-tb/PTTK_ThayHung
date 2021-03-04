/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CauHoi;

import dao.CauHoiDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.CauHoi;
import model.LuaChon;

/**
 *
 * @author Long Coi
 */
public class doLuuServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String noiDungCh = request.getParameter("noiDungCh");
        String mucDo = request.getParameter("mucDo");
        CauHoi ch = (CauHoi) session.getAttribute("selectedCH");
        if(mucDo!=null) ch.setMucDo(mucDo);
        if(noiDungCh!=null) ch.setNoiDung(noiDungCh);
        
        ArrayList<LuaChon> listLC = ch.getLuaChon();
        String isTrue =  request.getParameter("istrue");
        int indexIsTrue = Integer.parseInt(isTrue);
        for(int i=0; i<listLC.size(); i++){
            LuaChon lc = listLC.get(i);
            String ndlc = request.getParameter("noiDungLC"+i);
            lc.setNoiDung(ndlc);
            if(i==indexIsTrue)
                lc.setIsTrue(true);
            else
                lc.setIsTrue(false);
        }
        String url = "";
        session.setAttribute("ndch", noiDungCh);
        session.setAttribute("md", mucDo);
        session.setAttribute("istrueindex", isTrue);
        CauHoiDAO chDao = new CauHoiDAO();
        if(chDao.updateCauHoi(ch))
            url = "/gdTimCauHoi.jsp";
        else
            url = "/failed.jsp";
        
         // forward request and response to the view
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);  
    }
}
