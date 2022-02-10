package com.example.studentrecord.studentrecord.controller;


import com.example.studentrecord.studentrecord.entity.Student;
import com.example.studentrecord.studentrecord.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;


    @PostMapping("/student")
    public Student saveStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }

    @GetMapping("/student")
    public List<Student> getStudentList(){
        return studentService.getStudentList();
    }

    @GetMapping("/student/{id}")
    @Cacheable()
    public Student getStudentById(@PathVariable("id") Integer student_Id){
        return studentService.getStudentById(student_Id);
    }

    @DeleteMapping("/student/{id}")
    public String deleteStudentById(@PathVariable("id") Integer student_Id){
        studentService.delStudentById(student_Id);
        return "Successfully deleted";
    }

    @PutMapping("/student/{id}")
    public Student updateStudentInfo(@PathVariable("id")Integer student_Id, @RequestBody Student student ){
        return studentService.updateStudentInfo(student_Id, student);
    }

    @GetMapping("/student/course/{id}")
    public Student getStudByCourseId(@PathVariable("id") Integer course_Id){
        return studentService.getStudByCourseId(course_Id);
    }


}
