/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dbmanager.MessageDbManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Messages;
import model.Student;
import model.Tutor;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author A12
 */
public class SendMessage extends HttpServlet {

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
        HttpSession session = request.getSession();
        String user_type = (String)session.getAttribute("USER_TYPE");
        int user_id;
        boolean isTeacher = true;//get from sssion
        if(user_type.compareToIgnoreCase("TEACHER")==0){
            Tutor t = (Tutor)session.getAttribute("USER");
            user_id = t.getTutorId();
        }else{
            Student t = (Student)session.getAttribute("USER");
            user_id = t.getStudentId();
            isTeacher = false;
        }
        
        

        int student_id, teacher_id;
        String message;
        Messages dto = new Messages();

        if (isTeacher) {
            dto.setTeacher_id(user_id);
            dto.setSender(0);
        } else {
            dto.setStudent_id(user_id);
            dto.setSender(1);

        }

        PrintWriter out = response.getWriter();
        try {
            String jsonString = "";
            BufferedReader br
                    = new BufferedReader(new InputStreamReader(request.getInputStream()));
            String line;
            //String json = "";
            while ((line = br.readLine()) != null) {
                jsonString += line;
                //System.out.println("recieve" + jsonString);
            }
            //System.out.println(jsonString != null);
            if (jsonString != null) {
                System.out.println(jsonString);
                JSONObject obj = new JSONObject(jsonString);

                student_id = obj.getInt("student_id");
                
                teacher_id = obj.getInt("teacher_id"); 
                
                message = obj.getString("message");
                
                dto.setMessage(message);
                boolean isSessionMatched = false;
                if (isTeacher) {
                    dto.setStudent_id(student_id);
                    if (student_id == dto.getStudent_id()) {
                        isSessionMatched = true;
                    }

                } else {
                    dto.setTeacher_id(teacher_id);
                    if (teacher_id == dto.getStudent_id()) {
                        isSessionMatched = true;
                    }
                }
                if (isSessionMatched) {
                    MessageDbManager db = new MessageDbManager();
                    Messages sendObj=db.getMessageByID(db.insert(dto));
                    if(sendObj!=null)
                    {
                        JSONObject json=new JSONObject(sendObj);
                        out.print(json.toString());
                    }
                    else
                    {
                    out.print("null");
                    }

                } else {
                    out.print("null");
                }

            }

        }catch(Exception ex){
            ex.printStackTrace();
        } 
        finally {
            
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
