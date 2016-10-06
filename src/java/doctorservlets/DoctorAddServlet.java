/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doctorservlets;

import dbhelpers.DoctorHelper;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
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
@WebServlet(name = "DoctorAddServlet", urlPatterns = {"/DoctorAddServlet", "/addDoctor.html"})
public class DoctorAddServlet extends HttpServlet {

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
        String name = request.getParameter("name");        
        String surname = request.getParameter("surname");
        String spec = (String) request.getAttribute("spec");
        System.out.println("name: " + name);
        DoctorHelper helper = DoctorHelper.getInstance();
        Doctor doctor = new Doctor(name, surname, spec);
        boolean isAdded = true;
        String strError = null;
        
        try {
            helper.addDoctor(doctor);
        } catch (SQLException ex) {
            isAdded = false;   
            strError = ex.getMessage();
        }
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {     
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Додавання доктора</title>");            
            out.println("</head>");
            out.println("<body>");
            if(isAdded) {
                out.println("<h1>Доктора " + doctor.getName() + " " + doctor.getSurname() + 
                        " було успішно додано</h1>");
            } else {
                out.println("<h1>Помилка додавання</h1>");
                out.println(strError);
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
