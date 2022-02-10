package com.example.studentrecord.studentrecord.service;

import com.example.studentrecord.studentrecord.entity.Student;
import java.util.List;
import java.util.Optional;

public interface StudentService {
    public Student saveStudent(Student student);
    public List<Student> getStudentList();

    public Student getStudentById(Integer student_Id);

    public void delStudentById(Integer student_Id);

    public Student updateStudentInfo(Integer student_id, Student student);

    public Student getStudByCourseId(Integer course_Id);
}
