package com.example.studentrecord.studentrecord.entity;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Course {

    @Id
    private Integer course_Id;

    public Course() {
    }

    public Integer getCourse_Id() {
        return course_Id;
    }

    public Course(Integer course_Id, String courseName, String courseDesc) {
        this.course_Id = course_Id;
        this.courseName = courseName;
        this.courseDesc = courseDesc;
    }

    public void setCourse_Id(Integer course_Id) {
        this.course_Id = course_Id;
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
