/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dbmanager.TutorDbManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Grind;
import model.Tutor;


@WebServlet(name = "SearchServlet", urlPatterns = {"/SearchServlet"})
public class SearchServlet extends HttpServlet {

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
            out.println("<title>Servlet SearchServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SearchServlet at " + request.getContextPath() + "</h1>");
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
     */ 
//https://www.geeksforgeeks.org/getattribute-passing-data-from-server-to-jsp/
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameter("subject") != null || request.getParameter("location") != null){
        {
           
            if(request.getParameter("req").equals("1")){
         // List to hold Tutor objects
            List<Tutor> list = TutorDbManager.searchTutorInformation((request.getParameter("subject") == null)?"":request.getParameter("subject"), (request.getParameter("location") == null)?"":request.getParameter("location"));
         // Setting the attribute of the request object which will be later fetched by the JSP page 
            request.setAttribute("data", list);  
         // A RequestDispatcher object to dispatch the request to the resource which is the JSP
        request.getRequestDispatcher("searchStudent.jsp").forward(request, response);
    }
        else{
               
         // List to hold Tutor objects
            List<Grind> list = TutorDbManager.searchGrindInformation((request.getParameter("subject") == null)?"":request.getParameter("subject"), (request.getParameter("location") == null)?"":request.getParameter("location"));
         // Setting the attribute of the request object which will be later fetched by the JSP page 
            request.setAttribute("gdata", list);  
         // A RequestDispatcher object to dispatch the request to the resource which is the JSP
        request.getRequestDispatcher("searchStudent.jsp").forward(request, response);
    
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
