package com.example.integrateredis.integrateredis.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Student implements Serializable {

    public Student() {
    }

    public Integer getStudent_id() {
        return student_id;
    }

    public Student(Integer student_id, String stud_name, String address, Integer course_id) {
        this.student_id = student_id;
        this.stud_name = stud_name;
        this.address = address;
        this.course_id = course_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    public String getStud_name() {
        return stud_name;
    }

    public void setStud_name(String stud_name) {
        this.stud_name = stud_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
    }

    @Id
    @GeneratedValue
    private Integer student_id;
    private String stud_name;
    private String address;
    private Integer course_id;


}
