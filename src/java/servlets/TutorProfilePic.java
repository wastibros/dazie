/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dbmanager.TutorDbManager;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import model.Tutor;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;



/**
 *
 * @author Usman
 */
public class TutorProfilePic extends HttpServlet {

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
     
		HttpSession session=request.getSession();
		Tutor dto = TutorDbManager.getTutorInformation("ahsan@gmail.com");
		if (dto != null) {

		String pathdir = "C:\\Users\\Usman\\Desktop\\kumail\\vendingmachine\\src\\main\\webapp\\";
		String dir=pathdir+"adminProfilePic";
		PrintWriter out = response.getWriter();
		if (ServletFileUpload.isMultipartContent(request)) {
			try {
				List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);

				String uploadPath = getServletContext().getRealPath("/uploads");
				File file = new File(uploadPath);
				System.out.println("uploadpath: " + uploadPath);
				String path = file.getAbsolutePath();
				System.out.println("path: " + path);

				for (FileItem item : multiparts) {
					if (!item.isFormField()) {
						String type = item.getContentType();
						if (type.equalsIgnoreCase("image/png") || type.equalsIgnoreCase("image/jpeg")) {
							String name = new File(item.getName()).getName();
							String a=name;
							// System.out.println(dir + File.separator + name);
							File oldPic=new File(dir+ File.separator+dto.getPhoto());
							oldPic.delete();
							if(type.equalsIgnoreCase("image/png"))
							{
								name="admin-"+dto.getTutorId() +a.substring(0, 3)+".png";
							}
							if(type.equalsIgnoreCase("image/jpeg"))
							{
								name="admin-"+dto.getTutorId() +a.substring(0, 3)+".jpg";
							}
							item.write(new File(dir + File.separator + name));
							dto.setPhoto(name);
							
							if(true)
							{
								session.setAttribute("user", dto);
								request.setAttribute("message", "Profile picture Uploaded Successfully");
								request.setAttribute("text", "text-success");
							}
							else
							{
								request.setAttribute("message", "Somethin went wrong");
								request.setAttribute("text", "text-danger");
							}
						} else {
							request.setAttribute("message", "Invalid File Type");
							request.setAttribute("text", "text-danger");
						}

					}
				}

				// File uploaded successfully

			} catch (Exception ex) {
				request.setAttribute("message", "File Upload Failed due to " + ex);
				request.setAttribute("text", "text-danger");
			}

		} else {
			request.setAttribute("message", "Sorry this Servlet only handles file upload request");
			request.setAttribute("text", "text-danger");
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("/admin/admin_manage_profile.jsp").forward(request, response);
		}else
		{
			response.sendRedirect("/index.jsp");
		}
		
		
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
