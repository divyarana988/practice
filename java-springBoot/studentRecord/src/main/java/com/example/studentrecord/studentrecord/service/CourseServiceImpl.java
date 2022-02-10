package com.example.studentrecord.studentrecord.service;


import com.example.studentrecord.studentrecord.entity.Course;
import com.example.studentrecord.studentrecord.entity.Student;
import com.example.studentrecord.studentrecord.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;


    @Override
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public List<Course> getCourseList() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourseById(Integer course_id) {
        return courseRepository.findById(course_id).get();
    }

    @Override
    public void delCourseById(Integer course_id) {
        courseRepository.deleteById(course_id);
    }

    @Override
    public Course updateCourseInfo(Integer course_id, Course course) {
        Course courseFromDB = courseRepository.findById(course_id).get();

        if(Objects.nonNull(course.getCourseName()) && !"".equalsIgnoreCase(course.getCourseName())){
            courseFromDB.setCourseName(course.getCourseName());
        }


        if(Objects.nonNull(course.getCourseDesc()) && !"".equalsIgnoreCase(course.getCourseDesc())){
            courseFromDB.setCourseDesc(course.getCourseDesc());
        }


        return courseRepository.save(courseFromDB);
    }
}
