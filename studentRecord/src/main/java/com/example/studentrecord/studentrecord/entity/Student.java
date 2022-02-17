package com.example.studentrecord.studentrecord.entity;

import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;


@Entity

public class Student {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer student_Id;
    private String stud_Name;
    private Integer course_Id;
    private String address;

    public Student() {
    }

    public Integer getStudent_Id() {
        return student_Id;
    }

    public Student(Integer student_Id, String stud_Name, Integer course_Id, String address) {
        this.student_Id = student_Id;
        this.stud_Name = stud_Name;
        this.course_Id = course_Id;
        this.address = address;
    }

    public void setStudent_Id(Integer student_Id) {
        this.student_Id = student_Id;
    }

    public String getStud_Name() {
        return stud_Name;
    }

    public void setStud_Name(String stud_Name) {
        this.stud_Name = stud_Name;
    }

    public Integer getCourse_Id() {
        return course_Id;
    }

    public void setCourse_Id(Integer course_Id) {
        this.course_Id = course_Id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
