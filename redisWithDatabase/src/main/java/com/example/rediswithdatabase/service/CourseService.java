package com.example.rediswithdatabase.service;

import com.example.rediswithdatabase.entity.Course;

import java.util.List;

public interface CourseService {
    Course saveCourse(Course course);



    Course getCourseById(Integer course_id);

    String delCourseById(Integer course_id);

    List<Course> getCourseList();

    Course updateCourseById(Integer course_id, Course course);
}