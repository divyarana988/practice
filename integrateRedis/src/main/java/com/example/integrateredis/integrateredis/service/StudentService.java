package com.example.integrateredis.integrateredis.service;

import com.example.integrateredis.integrateredis.entity.Student;

import java.util.List;

public interface StudentService {
    Student saveStudent(Student student);



    

    String delStudentById(Integer student_id);

    Student getStudentById(Integer student_id);
}
