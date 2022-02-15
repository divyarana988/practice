package com.example.integrateredis.integrateredis.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity

public class Course implements Serializable {

    @Id
    @Column(name="course_id")
   // @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer courseId;

    public Course() {
    }

    public Integer getCourseId() {
        return courseId;
    }

    public Course(Integer course_Id, String courseName, String courseDesc) {
        this.courseId = course_Id;
        this.courseName = courseName;
        this.courseDesc = courseDesc;
    }

    public void setCourseId(Integer course_Id) {
        this.courseId = course_Id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDesc() {
        return courseDesc;
    }

    public void setCourseDesc(String courseDesc) {
        this.courseDesc = courseDesc;
    }

    private String courseName;

    private String courseDesc;



}
