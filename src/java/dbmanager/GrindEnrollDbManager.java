/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbmanager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Grind;
import model.GrindEnroll;
import model.Student;

/**
 *
 * @author Usman
 */
public class GrindEnrollDbManager {

    public int insert(GrindEnroll dto) {
        PreparedStatement pst = null;
        int rowAffected = 0;
        int index = -1;
        try {
            String query = "INSERT INTO `grind_student` (`id`, `grind_id`, `student_id`, `timeofenroll`) VALUES (NULL, ?, ?, current_timestamp())";
            pst = DBConnection.getInstance().prepareCall(query);

            pst.setInt(1, dto.getGrind_id());
            pst.setInt(2, dto.getStudent_id());

            rowAffected = pst.executeUpdate();
            if (rowAffected > 0) {
                ResultSet rs = pst.getGeneratedKeys();
                if (rs.next()) {
                    index = rs.getInt(1);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(MessageDbManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(MessageDbManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return index;
    }

    public boolean remove(GrindEnroll dto) {
        int affectedRows = 0;
        String query = "delete from `grind_student`  where grind_id=? and student_id=?";
        PreparedStatement pst = null;

        try {
            pst = DBConnection.getInstance().prepareCall(query);
            pst.setInt(1, dto.getGrind_id());
            pst.setInt(2, dto.getStudent_id());
            affectedRows = pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GrindEnrollDbManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(MessageDbManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return affectedRows != 0;

    }

    public ArrayList<Student> getAllStudentByGrindID(int grind_id) {

        ArrayList<Student> arr = new ArrayList<Student>();
        String query = "SELECT `std_id`, `name`, `email`, "
                + "`description`, `location_id`, `password` from student s "
                + "INNER join grind_student e on s.std_id= e.student_id where e.grind_id=?";
        PreparedStatement pst = null;
        ResultSet rs = null;
        Student obj = null;
        try {
            pst = DBConnection.getInstance().prepareCall(query);
            pst.setInt(1, grind_id);
            rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    obj = new Student();
                    obj.setStudentId(rs.getInt(1));
                    obj.setName(rs.getString(2));
                    obj.setEmail(rs.getString(3));
                    obj.setDescription(rs.getString(4));
                    obj.setLocationId(rs.getInt(5));
                    arr.add(obj);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(GrindEnrollDbManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public ArrayList<Grind> getAllGrindByStudentID(int student_id) {

        ArrayList<Grind> arr = new ArrayList<Grind>();
        String query = "SELECT g.`grind_id`, `name`, `teacher_id`, `subject_id`, `location_id`, `g_location`, `date`, `time`, `price`, `capacity` "
                + "from grind g INNER join grind_student gr"
                + " on g.grind_id=gr.grind_id where gr.student_id=?";
        PreparedStatement pst = null;
        ResultSet rs = null;
        Grind obj = null;
        try {
            pst = DBConnection.getInstance().prepareCall(query);
            pst.setInt(1, student_id);
            rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    obj = new Grind();
                    obj.setGrindId(rs.getInt(1));
                    obj.setName(rs.getString(2));
                    obj.setTeacher_id(rs.getInt(3));
                    obj.setSubjectId(rs.getInt(4));
                    obj.setLocationId(rs.getInt(5));
                    obj.setLocation(rs.getString(6));
                    obj.setDate(rs.getString(7));
                    obj.setTime(rs.getString(8));
                    obj.setPrice(rs.getString(9));
                    obj.setPrice(rs.getString(10));
                    arr.add(obj);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(GrindEnrollDbManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }
    
    public int getEnrollStudent(int grind_id) {
        int arr = 0;
        String query = "SELECT count(*) from `grind_student` group by (grind_id) having grind_id=?";
        PreparedStatement pst = null;
        ResultSet rs = null;
        Grind obj = null;
        try {
            pst = DBConnection.getInstance().prepareCall(query);
            pst.setInt(1, grind_id);
            rs = pst.executeQuery();
            if (rs != null) {
                if (rs.next()) {

                    arr = rs.getInt(1);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(GrindEnrollDbManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

}
