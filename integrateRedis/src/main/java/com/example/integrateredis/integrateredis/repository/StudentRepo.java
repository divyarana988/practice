package com.example.integrateredis.integrateredis.repository;


import com.example.integrateredis.integrateredis.entity.Student;

import java.util.List;

public interface StudentRepo {

    boolean saveStudent(Student student);

    List<Student> getAllStudent();

    

    String delStudentById(Integer student_id);

    Student getStudentById(Integer student_id);
}
