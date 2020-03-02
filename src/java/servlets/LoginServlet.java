/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dbmanager.DBConnection;
import dbmanager.StudentDbManager;
import dbmanager.TutorDbManager;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Student;
import model.Tutor;


@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

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
            out.println("<title>Servlet LoginServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
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
        if(!request.getParameter("email").equals("") && !request.getParameter("password").equals(""))
        {
           
            if(request.getParameter("userType").equals("1")){
                
                boolean chk = StudentDbManager.checkLogin(request.getParameter("email"), request.getParameter("password"));
                
                if(chk){
                    Student st = StudentDbManager.getStudentInformation(request.getParameter("email"));
                    HttpSession session = request.getSession();
                    session.setAttribute("USER_TYPE", "STUDENT");
                    session.setAttribute("USER", st);
                    request.getSession().setAttribute("email", request.getParameter("email"));
                    
                    response.sendRedirect("searchStudent.jsp");
                }
                else{
                    response.sendRedirect("login.jsp?error=true");
                }
            }
            else{
                boolean chk = TutorDbManager.checkLogin(request.getParameter("email"), request.getParameter("password"));
                if(chk){
                    Tutor tutor = TutorDbManager.getTutorInformation(request.getParameter("email"));
                    HttpSession session = request.getSession();
                    session.setAttribute("USER_TYPE", "TEACHER");
                    session.setAttribute("USER", tutor);
                    request.getSession().setAttribute("email", request.getParameter("email"));
                    
                    response.sendRedirect("messanger.jsp");
                }
                else{
                    response.sendRedirect("login.jsp?error=true");
                }
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
