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

/**
 *
 * @author Long Coi
 */
public class doTimServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String noiDung = request.getParameter("noiDungSearch").trim();
        CauHoiDAO chDAO = new CauHoiDAO();
        ArrayList<CauHoi> listCH = new ArrayList<>();
        listCH = chDAO.searchCauHoi(noiDung);
        HttpSession session = request.getSession();
        session.setAttribute("listCH", listCH);
        request.setAttribute("inputSearch", noiDung);
        String url = "/gdTimCauHoi.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response); 
    }

}
