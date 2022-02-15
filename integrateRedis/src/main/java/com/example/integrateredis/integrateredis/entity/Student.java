package com.example.integrateredis.integrateredis.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Student implements Serializable {

    public Student() {
    }

    public Integer getId() {
        return id;
    }

    public Student(Integer student_id, String stud_name, String address, Integer course_id) {
        this.id = student_id;
        this.studName = stud_name;
        this.address = address;
        this.courseId = course_id;
    }

    public void setId(Integer student_id) {
        this.id = student_id;
    }

    public String getStudName() {
        return studName;
    }

    public void setStudName(String stud_name) {
        this.studName = stud_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer course_id) {
        this.courseId = course_id;
    }

    @Id
    @Column(name="student_id")
    @GeneratedValue
    private Integer id;
    private String studName;
    private String address;

    @Column(name="course_id")
    private Integer courseId;


}
