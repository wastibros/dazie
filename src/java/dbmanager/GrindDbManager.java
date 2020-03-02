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

/**
 *
 * @author Usman
 */
public  class GrindDbManager {

    public static ArrayList<Grind> getAllGrindByTeacherID(int teacher_id) {

        ArrayList<Grind> arr = new ArrayList<Grind>();
        String query = "SELECT * FROM `grind` g WHERE g.teacher_id=?";
        PreparedStatement pst = null;
        ResultSet rs = null;
        Grind obj = null;
        try {
            pst = DBConnection.getInstance().prepareCall(query);
            pst.setInt(1, teacher_id);
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
            Logger.getLogger(GrindDbManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public static ArrayList<Grind> getAllGrinds() {

        ArrayList<Grind> arr = new ArrayList<Grind>();
        String query = "SELECT * FROM `grind`";
        PreparedStatement pst = null;
        ResultSet rs = null;
        Grind obj = null;
        try {
            pst = DBConnection.getInstance().prepareCall(query);
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
            Logger.getLogger(GrindDbManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public static Grind getGrindById(int id) {

        String query = "SELECT * FROM `grind`";
        PreparedStatement pst = null;
        ResultSet rs = null;
        Grind obj = null;
        try {
            pst = DBConnection.getInstance().prepareCall(query);
            rs = pst.executeQuery();
            if (rs != null) {
                if (rs.next()) {
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

                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(GrindDbManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }

    public static int insert(Grind dto) {

        PreparedStatement pst = null;
        int rowAffected = 0;
        int index = -1;
        try {
            String query = "INSERT INTO `grind` (`grind_id`, `name`, `teacher_id`, `subject_id`, "
                    + "`location_id`, `g_location`, `date`, `time`, `price`, `capacity`) "
                    + "VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            pst = DBConnection.getInstance().prepareCall(query);
            pst.setString(1, dto.getName());
            pst.setInt(2, dto.getTeacher_id());
            pst.setInt(3, dto.getSubjectId());
            pst.setInt(4, dto.getLocationId());
            pst.setString(5, dto.getLocation());
            pst.setString(6, dto.getDate());
            pst.setString(7, dto.getTime());
            pst.setString(8, dto.getPrice());
            pst.setString(9, dto.getCapacity());

            rowAffected = pst.executeUpdate();
            if (rowAffected > 0) {
                ResultSet rs = pst.getGeneratedKeys();
                if (rs.next()) {
                    index = rs.getInt(1);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(GrindDbManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(GrindDbManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return index;
    }

    public static boolean delete(int id) {
        int affectedRows = 0;
        String query = "delete from grind  where grind_id=? ";
        PreparedStatement pst = null;

        try {
            pst = DBConnection.getInstance().prepareCall(query);
            pst.setInt(1, id);

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
}
