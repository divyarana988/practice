package com.example.integrateredis.integrateredis.service;

import com.example.integrateredis.integrateredis.entity.Course;

import java.util.List;

public interface CourseService {
    boolean saveCourse(Course course);

    List<Course> getCourseList();

    Course getCourseById(Integer course_id);

    String delCourseById(Integer course_id);
}
