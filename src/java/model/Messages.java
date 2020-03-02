/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author A12
 */
public class Messages {
    private int id;
    private int student_id;
    private int teacher_id;
    private int sender;
    private String message;
    private String dateTime;

   
   

    public Messages() {
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }

    public int getSender() {
        return sender;
    }

    public void setSender(int sender) {
        this.sender = sender;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
     public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }


    @Override
    public String toString() {
        return "Messages{" + "id=" + id + ", student_id=" + student_id + ", teacher_id=" + teacher_id + ", sender=" + sender + ", message=" + message + ", dateTime=" + dateTime + '}';
    }

 
    
    
    
}
