/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dbmanager.StudentDbManager;
import dbmanager.TutorDbManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Student;
import model.Tutor;

/**
 *
 * @author Rehan Ali Azeemi
 */
@WebServlet(name = "TutorServlet", urlPatterns = {"/TutorServlet"})
public class TutorServlet extends HttpServlet {

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
            out.println("<title>Servlet TutorServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TutorServlet at " + request.getContextPath() + "</h1>");
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
        //processRequest(request, response);
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
        Tutor tutor = new Tutor();
   
        if(request.getParameter("tutorId") == null){
            if(!request.getParameter("name").equals("") && !request.getParameter("email").equals("") && !request.getParameter("password").equals("")){
                String[] subjects = request.getParameterValues("subject");
                ArrayList<String> list = new ArrayList<String>();
                for(String str : subjects){
                    list.add(str);
            
                }
                tutor.setSubjects(list);
                tutor.setName(request.getParameter("name"));
                tutor.setEmail(request.getParameter("email"));
                tutor.setPassword(request.getParameter("password"));
                tutor.setDescription(request.getParameter("description"));
                tutor.setAvailability(request.getParameter("availability"));
                tutor.setLocationId(Integer.parseInt(request.getParameter("location")));
                TutorDbManager.saveTutor(tutor);
                response.sendRedirect("login.jsp");
            }
        }
        else{
            if(!request.getParameter("name").equals("") && !request.getParameter("email").equals("") && !request.getParameter("password").equals("")){
                String[] subjects = request.getParameterValues("subject");
                ArrayList<String> list = new ArrayList<String>();
                for(String str : subjects){
                    list.add(str);
                }
                tutor.setSubjects(list);
                tutor.setTutorId(Integer.parseInt(request.getParameter("tutorId")));
                tutor.setName(request.getParameter("name"));
                tutor.setEmail(request.getParameter("email"));
                tutor.setPassword(request.getParameter("password"));
                tutor.setDescription(request.getParameter("description"));
                tutor.setAvailability(request.getParameter("availability"));
                tutor.setLocationId(Integer.parseInt(request.getParameter("location")));
                TutorDbManager.updateTutor(tutor);
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
