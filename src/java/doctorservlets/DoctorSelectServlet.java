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
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Doctors</title>");            
        out.println("</head>");
        out.println("<body>");
        if(list == null) {
            out.println("<h2>");
            out.println("Table Doctors doesn't have records!");
            out.println("</h2>");
        } else {           
            out.println("<h2>");
            out.println("Doctors:");
            out.println("</h2>");
            out.println("<table border=\"1\">");
            out.println("<tr>");
            out.println("<th>Id</th>");            
            out.println("<th>Name</th>"); 
            out.println("<th>Surname</th>"); 
            out.println("<th>Specialization</th>"); 
            out.println("<th></th>"); 
            out.println("</tr>");
            for(Doctor doctor: list) {
                out.println("</tr>");
                out.println("<td>"+ doctor.getId() +"</td>"); 
                out.println("<td>"+ doctor.getName() +"</td>"); 
                out.println("<td>"+ doctor.getSurname() +"</td>"); 
                out.println("<td>"+ doctor.getSpecialization() +"</td>"); 
                out.println("<td>"); 
                out.println("<form method=\"post\">");
                out.println("<button formaction = \"EditFormMakerServlet\" name = \"editBtn\" value = \"" + doctor.getId() + "\">Edit</button>");
                out.println("<button formaction = \"DoctorDeleteServlet\" name = \"deleteBtn\" value = \"" + doctor.getId() + "\">Delete</button>");
                //out.println("<input type=\"button\" onClick='location.href=\"http://index.html/\"' value=\"Редагувати\">");
                //out.println("<input type=\"button\" onClick='location.href=\"http://index.html/\"' value=\"Видалити\">");
                out.println("</form>");
                out.println("</td>"); 
                out.println("<tr>");
            }  
            out.println("</table>");
            out.println("<form>");
            out.println("<button formaction = \"DoctorShowAddServlet\">Add doctor</button>"); 
            out.println("</form>");
            out.println();
        }
        out.println("</body>");
        out.println("</html>");
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
