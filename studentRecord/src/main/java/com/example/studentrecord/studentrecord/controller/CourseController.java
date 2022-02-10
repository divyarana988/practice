package com.example.studentrecord.studentrecord.controller;

import com.example.studentrecord.studentrecord.entity.Course;
import com.example.studentrecord.studentrecord.entity.Student;
import com.example.studentrecord.studentrecord.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/course")
    public Course saveCourse(@RequestBody Course course){
        return courseService.saveCourse(course);
    }

    @GetMapping("/course")
    public List<Course> getCourseList(){
        return courseService.getCourseList();
    }

    @GetMapping("/course/{id}")
    public Course getCourseById(@PathVariable("id") Integer course_Id){
        return courseService.getCourseById(course_Id);
    }

    @DeleteMapping("/course/{id}")
    public String deleteCourseById(@PathVariable("id") Integer course_Id){
        courseService.delCourseById(course_Id);
        return "Successfully deleted";
    }

    @PutMapping("/course/{id}")
    public Course updateCourseInfo(@PathVariable("id")Integer course_Id, @RequestBody Course course ){
        return courseService.updateCourseInfo(course_Id, course);
    }

}
