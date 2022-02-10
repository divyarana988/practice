package com.example.studentrecord.studentrecord.service;

import com.example.studentrecord.studentrecord.entity.Course;
import com.example.studentrecord.studentrecord.entity.Student;

import java.util.List;

public interface CourseService {
    public Course saveCourse(Course course);

    public List<Course> getCourseList();

    public Course getCourseById(Integer course_id);

    public void delCourseById(Integer course_id);

    public Course updateCourseInfo(Integer course_id, Course course);
}
