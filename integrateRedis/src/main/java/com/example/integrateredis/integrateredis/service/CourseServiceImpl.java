package com.example.integrateredis.integrateredis.service;

import com.example.integrateredis.integrateredis.entity.Course;
import com.example.integrateredis.integrateredis.repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseRepo courseRepo;


    @Override
    public boolean saveCourse(Course course) {
        return courseRepo.saveCourse(course);
    }

    @Override
    public List<Course> getCourseList() {
        return courseRepo.getCourseList();
    }

    @Override
    public Course getCourseById(Integer course_id) {
        return courseRepo.getCourseById(course_id);
    }

    @Override
    public String delCourseById(Integer course_id) {
        return courseRepo.delCourseById(course_id);
    }
}
