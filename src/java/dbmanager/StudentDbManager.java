/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbmanager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Location;
import model.Student;

public class StudentDbManager {
    public static void saveStudent(Student student){
        try{
            PreparedStatement ps = DBConnection.getInstance().prepareCall("Insert into student(name,email,description,location_id,password) values(?,?,?,?,?)");
            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setString(3, student.getDescription());
            ps.setInt(4, student.getLocationId());
            ps.setString(5, student.getPassword());
            ps.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
        public static void updateStudent(Student student){
        try{
            PreparedStatement ps = DBConnection.getInstance().prepareCall("Update student set name = ? ,email = ?,description = ?,password = ? where std_id = ?");
            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setString(3, student.getDescription());
            ps.setString(4, student.getPassword());
            ps.setInt(5, student.getStudentId());
            ps.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static List<Location> getAllLocations(){
        ArrayList<Location> list = new ArrayList<Location>();
        try{
            PreparedStatement ps = DBConnection.getInstance().prepareCall("Select * from location");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Location location = new Location();
                location.setLocationId(rs.getInt(1));
                location.setLocation(rs.getString(2));
                list.add(location);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return list;
    }
    
    public static boolean checkLogin(String email,String password){
        try{
            PreparedStatement ps = DBConnection.getInstance().prepareCall("Select * from student where email = ? AND password = ?");
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                return true;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    public static Student getStudentInformation(String email){
        Student student = null;
        try{
            PreparedStatement ps = DBConnection.getInstance().prepareCall("Select * from student where email = ?");
            ps.setString(1, email);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
               student = new Student();
               student.setStudentId(rs.getInt(1));
               student.setName(rs.getString(2));
               student.setEmail(rs.getString(3));
               student.setDescription(rs.getString(4));
               student.setLocationId(rs.getInt(5));
               student.setPassword(rs.getString(6));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return student;
    }
    public static ArrayList<Student> getAllStudentInformation(){
        Student student = null;
        ArrayList<Student> arr = null;
        try{
            PreparedStatement ps = DBConnection.getInstance().prepareCall("Select * from student");
            arr = new ArrayList();
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
               student = new Student();
               student.setStudentId(rs.getInt(1));
               student.setName(rs.getString(2));
               student.setEmail(rs.getString(3));
               student.setDescription(rs.getString(4));
               student.setLocationId(rs.getInt(5));
               student.setPassword(rs.getString(6));
               arr.add(student);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return arr;
    }
}
