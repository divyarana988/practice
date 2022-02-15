package com.example.integrateredis.integrateredis.controller;


import com.example.integrateredis.integrateredis.entity.Student;
import com.example.integrateredis.integrateredis.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;
import java.util.List;

@RestController
@EnableCaching
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/student")
    public Student saveStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }




    @GetMapping("/student/{id}")

    public Student getStudentById(@PathVariable("id") Integer student_id){
        return studentService.getStudentById(student_id);
    }

    @DeleteMapping("student/{id}")
    public String deleteStudentById(@PathVariable("id") Integer student_Id){
        return studentService.delStudentById(student_Id);

    }
}
