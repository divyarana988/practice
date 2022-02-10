package com.demo.helloworld.controllers;

import com.demo.helloworld.entities.Course;
import com.demo.helloworld.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class HelloController {

    @Autowired
    private CourseService courseServ;


    @GetMapping("/home")

    public String home(){
        return ("This is home page");
    }

    @GetMapping("/courses")
    public List<Course> getCourses(){
        return this.courseServ.getCourses();
    }

    @GetMapping("/courses/{courseId}")
    public Course getCourse(@PathVariable String courseId){
        return this.courseServ.getCourse(Long.parseLong(courseId));
    }

    @PostMapping("/courses")
    public Course addCourse(@RequestBody Course course){
        return this.courseServ.addCourse(course);
    }

    @PutMapping("/courses")
     public Course updateCourse(@RequestBody  Course course){
        return this.courseServ.updateCourse(course);
    }
}
