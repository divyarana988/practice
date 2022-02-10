package com.example.integrateredis.integrateredis.service;

import com.example.integrateredis.integrateredis.entity.Student;
import com.example.integrateredis.integrateredis.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public boolean saveStudent(Student student) {
        return studentRepo.saveStudent(student);
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepo.getAllStudent();
    }

    @Override
    public String delStudentById(Integer student_id) {
        return studentRepo.delStudentById(student_id);
    }

    @Override
    public Student getStudentById(Integer student_id) {
        return studentRepo.getStudentById(student_id);
    }
}
