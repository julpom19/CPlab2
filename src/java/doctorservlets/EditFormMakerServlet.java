/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doctorservlets;

import dbhelpers.DoctorHelper;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "EditFormMakerServlet", urlPatterns = {"/EditFormMakerServlet"})
public class EditFormMakerServlet extends HttpServlet {

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
        String strDocId = request.getParameter("editBtn");
        int id = Integer.valueOf(strDocId);
        DoctorHelper helper = DoctorHelper.getInstance();
        Doctor doctor = helper.selectDoctor(id);        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Редагування доктора</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<form method=\"post\" onsubmit='return validate(this);'>\n" +
"            <table>\n" +
"                <tr>\n" +
"                    <td>Ім'я</td>\n" +
"                    <td><input type=\"text\" name=\"name\" value=\""+ doctor.getName() + "\"/></td>\n" +
"                </tr>\n" +
"                <tr>\n" +
"                    <td>Прізвище</td>\n" +
"                    <td><input type=\"text\" name=\"surname\" value=\""+ doctor.getSurname() + "\"/></td>\n" +
"                </tr>\n" +
"                <tr>\n" +
"                    <td>Спеціалізація</td>\n" +
"                    <td><input type=\"text\" name=\"spec\" value=\""+ doctor.getSpecialization() + "\"/></td>\n" +
"                </tr>\n" +
"                <tr>\n" +
"                    <td></td>\n" +
"                    <td><button formaction=\"DoctorEditServlet\" name=\"editBtn\" value=\"" + id +  "\">Зберегти зміни</button></td>\n" +
"                </tr>\n" +
"            </table>            \n" +
"        </form>\n" +
"        <form name=\"returnForm\" method=\"post\" action=\"DoctorSelectServlet\">\n" +
"            <input type=\"submit\" value=\"Повернутись до списку лікарів\">\n" +
"        </form>\n" +
"        <script>\n" +
"            function validate(form) {\n" +
"                var text_fields = form.getElementsByTagName('input');\n" +
"                var validated = true;\n" +
"\n" +
"                for (var i = 0; i < text_fields.length; i++) {\n" +
"                    if (text_fields[i].type != 'submit') {\n" +
"                        validated = validated && (text_fields[i].value !== '');\n" +
"                    }\n" +
"                }                \n" +
"\n" +
"                if (!validated) {\n" +
"                    alert('Заповність всі поля');\n" +
"                }\n" +
"                \n" +
"                return validated;\n" +
"            }\n" +
"        </script>");
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
