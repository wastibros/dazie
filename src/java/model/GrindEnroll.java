/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Usman
 */
public class GrindEnroll {
    private int id;
    private int grind_id;
    private int student_id;
    private String dateTimeEnroll;

    public GrindEnroll() {
    }

    public GrindEnroll(int id, int grind_id, int student_id, String dateTimeEnroll) {
        this.id = id;
        this.grind_id = grind_id;
        this.student_id = student_id;
        this.dateTimeEnroll = dateTimeEnroll;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGrind_id() {
        return grind_id;
    }

    public void setGrind_id(int grind_id) {
        this.grind_id = grind_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getDateTimeEnroll() {
        return dateTimeEnroll;
    }

    public void setDateTimeEnroll(String dateTimeEnroll) {
        this.dateTimeEnroll = dateTimeEnroll;
    }

    @Override
    public String toString() {
        return "GrindEnroll{" + "id=" + id + ", grind_id=" + grind_id + ", student_id=" + student_id + ", dateTimeEnroll=" + dateTimeEnroll + '}';
    }
    
    
}
