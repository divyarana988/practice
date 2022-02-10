package com.example.studentrecord.studentrecord.service;

import com.example.studentrecord.studentrecord.entity.Student;
import com.example.studentrecord.studentrecord.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    private RedisTemplate redisTemplate;


    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getStudentList() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Integer student_Id) {
        return studentRepository.findById(student_Id).get();
    }

    @Override
    public void delStudentById(Integer student_Id) {
        studentRepository.deleteById(student_Id);
    }

    @Override
    public Student updateStudentInfo(Integer student_id, Student student) {
        Student stdFromDB = studentRepository.findById(student_id).get();

        if(Objects.nonNull(student.getStud_Name()) && !"".equalsIgnoreCase(student.getStud_Name())){
            stdFromDB.setStud_Name(student.getStud_Name());
        }


        if(Objects.nonNull(student.getAddress()) && !"".equalsIgnoreCase(student.getAddress())){
            stdFromDB.setAddress(student.getAddress());
        }


        return studentRepository.save(stdFromDB);
    }

   @Override
    public Student getStudByCourseId(Integer course_Id) {

        return studentRepository.findByCourse_Id(course_Id);
    }
}
