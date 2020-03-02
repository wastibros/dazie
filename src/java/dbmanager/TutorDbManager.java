/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbmanager;

import static java.lang.System.out;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Grind;
import model.Location;
import model.Subject;
import model.Tutor;


public class TutorDbManager {
     public static boolean checkLogin(String email,String password){
        try{
            PreparedStatement ps = DBConnection.getInstance().prepareCall("Select * from tutor where email = ? AND password = ?");
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
     
         public static void saveTutor(Tutor tutor){
        try{
            PreparedStatement ps = DBConnection.getInstance().prepareCall("Insert into tutor(name,email,description,location_id,password,availbility) values(?,?,?,?,?,?)");
            ps.setString(1, tutor.getName());
            ps.setString(2, tutor.getEmail());
            ps.setString(3, tutor.getDescription());
            ps.setInt(4, tutor.getLocationId());
            ps.setString(5, tutor.getPassword());
            ps.setString(6, tutor.getAvailability());
            ps.executeUpdate();
            saveSubjectsWithTutor(tutor.getSubjects());
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
         
         
             public static void saveSubjectsWithTutor(List<String> list){
        try{
            int tutorid = getTutorId();
            for(String subject:list){
                PreparedStatement ps = DBConnection.getInstance().prepareCall("Insert into tutor_subject(tutor_id,subject_id) select ?,subject_id from subject where subject = ?");
                ps.setInt(1, tutorid);
                ps.setString(2, subject);
                ps.executeUpdate();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    } 
         

         
    public static void updateTutor(Tutor tutor){
             try{
            PreparedStatement ps = DBConnection.getInstance().prepareCall("Update tutor set name = ?, email = ?,description = ?,location_id = ?,password = ?,availbility = ? where tutor_id = ?");
            ps.setString(1, tutor.getName());
            ps.setString(2, tutor.getEmail());
            ps.setString(3, tutor.getDescription());
            ps.setInt(4, tutor.getLocationId());
            ps.setString(5, tutor.getPassword());
            ps.setString(6, tutor.getAvailability());
            ps.setInt(7, tutor.getTutorId());
            ps.executeUpdate();
            deleteAllSubjectsWithTutor(tutor.getTutorId());
            updateSubjectsWithTutor(tutor.getSubjects(),tutor.getTutorId());
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
        public static void deleteAllSubjectsWithTutor(int tutorId){
        
        try{
            PreparedStatement ps = DBConnection.getInstance().prepareCall("Delete from tutor_subject where tutor_id = ?");
            ps.setInt(1, tutorId);
            ps.executeUpdate();
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        
    }
        
        public static void updateSubjectsWithTutor(List<String> list,int tutorid){
        try{
            
            for(String subject:list){
                PreparedStatement ps = DBConnection.getInstance().prepareCall("Insert into tutor_subject(tutor_id,subject_id) select ?,subject_id from subject where subject = ?");
                ps.setInt(1, tutorid);
                ps.setString(2, subject);
                ps.executeUpdate();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    } 
         

    
    public static int getTutorId(){
        try{
            PreparedStatement ps = DBConnection.getInstance().prepareCall("Select max(tutor_id) from tutor");
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return rs.getInt(1);
            }
            ps.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return -1;
    }
    
        public static Tutor getTutorInformation(String email){
        Tutor tutor = null;
        try{
            PreparedStatement ps = DBConnection.getInstance().prepareCall("Select * from tutor where email = ?");
            ps.setString(1, email);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
               tutor = new Tutor();
               tutor.setTutorId(rs.getInt(1));
               tutor.setName(rs.getString(2));
               tutor.setEmail(rs.getString(3));
               tutor.setPassword(rs.getString(4));
               tutor.setAvailability(rs.getString(5));
               tutor.setLocationId(rs.getInt(6));
               tutor.setDescription(rs.getString(7));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return tutor;
    }
        public static ArrayList<Tutor> getAllTutorInformation(){
        Tutor tutor = null;
        ArrayList<Tutor> arr = null;
        try{
            PreparedStatement ps = DBConnection.getInstance().prepareCall("Select * from tutor");
            arr = new ArrayList();
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
               tutor = new Tutor();
               tutor.setTutorId(rs.getInt(1));
               tutor.setName(rs.getString(2));
               tutor.setEmail(rs.getString(3));
               tutor.setPassword(rs.getString(4));
               tutor.setAvailability(rs.getString(5));
               tutor.setLocationId(rs.getInt(6));
               tutor.setDescription(rs.getString(7));
               arr.add(tutor);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return arr;
    }
     
        public static List<Subject> getAllSubjects(){
        ArrayList<Subject> list = new ArrayList<Subject>();
        try{
            PreparedStatement ps = DBConnection.getInstance().prepareCall("Select * from subject");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Subject subject = new Subject();
                subject.setSubjectId(rs.getInt(1));
                subject.setSubject(rs.getString(2));
                list.add(subject);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return list;
    }
        
    public static List<Integer> getAllSubjects(int tutorId){
        ArrayList<Integer> list = new ArrayList<Integer>();
        try{
            PreparedStatement ps = DBConnection.getInstance().prepareCall("Select subject_id from tutor_subject where tutor_id = ?");
            ps.setInt(1, tutorId);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){ 
                list.add(rs.getInt(1));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return list;
    }
    
         public static List<String> searchSubjectWithTutor(Integer tutorId){
        Tutor tutor = null;
        List<String> list = new ArrayList<String>();
        try{
            PreparedStatement ps = DBConnection.getInstance().prepareCall("SELECT SUBJECT FROM SUBJECT s \n" +
"INNER JOIN tutor_subject ts \n" +
"ON s.`subject_id` = ts.`subject_id` \n" +
"WHERE ts.`tutor_id` = ?");
            ps.setInt(1, tutorId);
            
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){               
               list.add(rs.getString(1));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    
     public static List<Tutor> searchTutorInformation(String subject,String location){
        Tutor tutor = null;
        List<Tutor> list = new ArrayList<Tutor>();
        try{
             //https://dba.stackexchange.com/questions/151904/mapping-many-to-many-relationship
            PreparedStatement ps = DBConnection.getInstance().prepareCall("SELECT t.`tutor_id`,t.`name`,s.`subject`,t.`availbility`,t.`description`,l.`location` FROM tutor t \n" +
                "INNER JOIN tutor_subject ts \n" +
                "ON t.`tutor_id` = ts.`tutor_id` \n" +
                "INNER JOIN SUBJECT s \n" +
                "ON ts.`subject_id` = s.`subject_id` \n" +
                "INNER JOIN location l \n" +
                "ON t.`location_id` = l.`location_id` \n" +
                "WHERE s.`subject` LIKE ? AND l.`location` LIKE ? GROUP BY t.`name`");
            ps.setString(1, "%"+subject+"%"); //https://stackoverflow.com/questions/40192410/how-to-implement-like-operator-in-prepared-statement
            ps.setString(2, "%"+location+"%");
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
               tutor = new Tutor();
               tutor.setTutorId(rs.getInt(1));
               tutor.setName(rs.getString(2));
               tutor.setSubject(rs.getString(3));
               tutor.setAvailability(rs.getString(4));
               tutor.setLocation(rs.getString(6));
               tutor.setDescription(rs.getString(5));
               
               list.add(tutor);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
     

public static List<Grind> searchGrindInformation(String subject,String location){
        Grind grind = null;
        List<Grind> list = new ArrayList<Grind>();
        try{
             //https://dba.stackexchange.com/questions/151904/mapping-many-to-many-relationship
            PreparedStatement ps = DBConnection.getInstance().prepareCall("SELECT g.`grind_id`,g.`name`,s.`subject`, l.`location`, g.`g_location`,g.`date`,g.`time`, g.`price`, g.`capacity` FROM grind g \n" +
                "INNER JOIN subject s \n" +
                "ON g.`subject_id` = s.`subject_id` \n" +
                "INNER JOIN location l \n" +
                "ON g.`location_id` = l.`location_id` \n" +
                "WHERE s.`subject` LIKE ? AND l.`location` LIKE ? GROUP BY g.`name`");
            ps.setString(1, "%"+subject+"%"); //https://stackoverflow.com/questions/40192410/how-to-implement-like-operator-in-prepared-statement
            ps.setString(2, "%"+location+"%");
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
               grind = new Grind();
               grind.setGrindId(rs.getInt(1));
               grind.setName(rs.getString(2));
               grind.setSubject(rs.getString(3));
               grind.setLocation(rs.getString(4));
               grind.setGLocation(rs.getString(5));
               grind.setDate(rs.getString(6));
               grind.setTime(rs.getString(7));
               grind.setPrice(rs.getString(8));
               grind.setCapacity(rs.getString(9));
               
               list.add(grind);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

public static void saveGrind(Grind grind){
        try{
            out.print("Jim");
            PreparedStatement ps = DBConnection.getInstance().prepareCall("Insert into grind(name,subject_id,location_id,g_location,date,time,price,capacity) values(?,?,?,?,?,?,?,?)");
            ps.setString(1, grind.getName());
            ps.setInt(2, grind.getSubjectId());
            ps.setInt(3, grind.getLocationId());
            ps.setString(4, grind.getGLocation());
            ps.setString(5, grind.getDate());
            ps.setString(6, grind.getTime());
            ps.setString(7, grind.getPrice());
            ps.setString(8, grind.getCapacity());
            ps.executeQuery();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

}