/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doctorservlets;

import dbhelpers.DoctorHelper;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.Doctor;

/**
 *
 * @author Интернет
 */
@WebServlet(name = "DoctorDeleteServlet", urlPatterns = {"/DoctorDeleteServlet"})
public class DoctorDeleteServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String strDocId = request.getParameter("deleteBtn");
        int id = Integer.valueOf(strDocId);
        DoctorHelper helper = DoctorHelper.getInstance();
        Doctor doctor = helper.selectDoctor(id);
        boolean isDeleted = true;
        try { 
            helper.deleteDoctor(doctor);
        } catch (SQLException ex) {
            isDeleted = false;
        }
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {     
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Видалення доктора</title>");            
            out.println("</head>");
            out.println("<body>");
            if(isDeleted) {
                out.println("<h1>Доктора " + doctor.getName() + " " + doctor.getSurname() + 
                        " було успішно видалено</h1>");
            } else {
                out.println("<h1>Помилка видалення</h1>");
            }
            out.println("<form method=\"post\" action=\"DoctorSelectServlet\">\n" +
                        "<input type=\"submit\" value=\"Повернутися до списку докторів\">\n" +
                        "</form>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
