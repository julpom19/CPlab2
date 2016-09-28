/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doctorservlets;

import dbhelpers.DoctorHelper;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
@WebServlet(name = "DoctorSelectServlet", urlPatterns = {"/DoctorSelectServlet"})
public class DoctorSelectServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        DoctorHelper helper = DoctorHelper.getInstance();
        List<Doctor> list = helper.selectDoctors();
        PrintWriter out = response.getWriter();
        if(list == null) {
            out.println("<h2>");
            out.println("У таблиці Доктори не має жодного запису!");
            out.println("</h2>");
        } else {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Список докторів</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>");
            out.println("Список докторів:");
            out.println("</h2>");
            out.println("<ol>");
            for(Doctor doctor: list) {
                out.println("<li>");
                out.println(doctor);
                out.println("</li>");
            }
            out.println("</ol>");
            out.println("<form>");
            out.println("<input type=\"button\" onClick='location.href=\"http://index.html/\"' value=\"Додати лікаря\">");
            out.println("</form>");
            out.println();
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
