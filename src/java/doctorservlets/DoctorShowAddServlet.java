/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doctorservlets;

import dbhelpers.SpecializationHelper;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 1310119
 */
@WebServlet(name = "DoctorShowAddServlet", urlPatterns = {"/DoctorShowAddServlet"})
public class DoctorShowAddServlet extends HttpServlet {

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
        SpecializationHelper helper = SpecializationHelper.getInstance();
        List<String> specList = helper.selectSpecs();
        StringBuilder options = new StringBuilder();
        for(String spec : specList) {
            options.append("<option>" + spec + "</option>");
        }
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>\n" +
"<html>\n" +
"    <head>\n" +
"        <title>Додавання лікаря</title>\n" +
"        <meta charset=\"utf-8\">\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"    </head>\n" +
"    <body>\n" +
"        <form method=\"post\" onsubmit='return validate(this);'>\n" +
"            <table>\n" +
"                <tr>\n" +
"                    <td>Ім'я</td>\n" +
"                    <td><input type=\"text\" name=\"name\"/></td>\n" +
"                </tr>\n" +
"                <tr>\n" +
"                    <td>Прізвище</td>\n" +
"                    <td><input type=\"text\" name=\"surname\"/></td>\n" +
"                </tr>\n" +
"                <tr>\n" +
"                    <td>Спеціалізація</td>\n" +
"                    <td><select name=\"spec\">" +
                     options + 
"                    </select>" + 
"                    </td>\n" +
"                </tr>\n" +
"                <tr>\n" +
"                    <td></td>\n" +
"                    <td><input type=\"submit\" formaction=\"DoctorAddServletProxy\" value=\"Додати лікаря\"></td>\n" +
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
"                    if (text_fields[i].type != 'submit' && text_fields[i].name != 'spec') {\n" +
"                        validated = validated && (text_fields[i].value !== '');\n" +
"                    }\n" +
"                }                \n" +
"\n" +
"                if (!validated) {\n" +
"                    alert('Заповність ім\\'я та прізвище доктора');\n" +
"                }\n" +
"                \n" +
"                return validated;\n" +
"            }\n" +
"        </script>\n" +
"    </body>\n" +
"    \n" +
"</html>");
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
