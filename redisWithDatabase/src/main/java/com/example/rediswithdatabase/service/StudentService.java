package com.example.rediswithdatabase.service;

import com.example.rediswithdatabase.entity.Student;

import java.util.List;

public interface StudentService {
    Student saveStudent(Student student);





    String delStudentById(Integer student_id);

    Student getStudentById(Integer student_id);

    List<Student> getStudentList();

    Student updateStudentById(Integer student_id, Student student);
}
