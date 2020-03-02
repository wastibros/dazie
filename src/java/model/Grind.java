/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;


public class Grind {
    private int grindId;
    private String name;
    private int teacher_id;
    private int subjectId;
    private String subject;
    private int locationId;
    private String location;
    private String glocation;
    private String date;
    private String time;
    private String price;
    private String capacity;
    private ArrayList<String> subjects;

    public int getGrindId() {
        return grindId;
    }

    public void setGrindId(int grindId) {
        this.grindId = grindId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getGlocation() {
        return glocation;
    }

    public void setGlocation(String glocation) {
        this.glocation = glocation;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }
    
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
    
     public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }
    
     public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    
     public String getGLocation() {
        return glocation;
    }

    public void setGLocation(String Glocation) {
        this.glocation = Glocation;
    }
    
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }


    public ArrayList<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList<String> subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return "Grind{" + "grindId=" + grindId + ", name=" + name + ", teacher_id=" + teacher_id + ", subjectId=" + subjectId + ", subject=" + subject + ", locationId=" + locationId + ", location=" + location + ", glocation=" + glocation + ", date=" + date + ", time=" + time + ", price=" + price + ", capacity=" + capacity + ", subjects=" + subjects + '}';
    }

   

    
    
}


