/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dbmanager.StudentDbManager;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Student;


@WebServlet(name = "StudentServlet", urlPatterns = {"/StudentServlet"})
public class StudentServlet extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet StudentServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet StudentServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
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
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * 
     * 
     * 
     * https://krazytech.com/programs/java-registration-page-using-servlet-mysql-mvc
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameter("id") == null){
            if(!request.getParameter("name").equals("") && !request.getParameter("email").equals("") && !request.getParameter("password").equals("")){
            Student student = new Student();
            student.setName(request.getParameter("name"));
            student.setEmail(request.getParameter("email"));
            student.setPassword(request.getParameter("password"));
            student.setDescription(request.getParameter("description"));
            student.setLocationId(Integer.parseInt(request.getParameter("location")));
            StudentDbManager.saveStudent(student);
            response.sendRedirect("login.jsp");
            }
        }
        else{
            if(!request.getParameter("name").equals("") && !request.getParameter("email").equals("") && !request.getParameter("password").equals("")){
            Student student = new Student();
            student.setStudentId(Integer.parseInt(request.getParameter("id")));
            student.setName(request.getParameter("name"));
            student.setEmail(request.getParameter("email"));
            student.setPassword(request.getParameter("password"));
            student.setDescription(request.getParameter("description"));
            //student.setLocationId(Integer.parseInt(request.getParameter("location")));
            StudentDbManager.updateStudent(student);
            
            response.sendRedirect("login.jsp");
            }
        }
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
