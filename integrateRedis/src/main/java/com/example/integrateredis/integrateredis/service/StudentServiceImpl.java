package com.example.integrateredis.integrateredis.service;

import com.example.integrateredis.integrateredis.entity.Student;
import com.example.integrateredis.integrateredis.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public Student saveStudent(Student student) {
//        redisTemplate.opsForValue().set(  "Student: " + student.getStudent_id().toString(), student);
        Student savedStudent =  studentRepo.save(student);
        return savedStudent;
    }


    @Override
    public String delStudentById(Integer student_id) {
        redisTemplate.opsForValue().getAndDelete("Student: " + student_id).toString();
         studentRepo.deleteById(student_id);
        return "student deleted";
    }


    @Override
    public Student getStudentById(Integer student_id) {
        Student getStudentFromRedis = (Student)redisTemplate.opsForValue().get("Student: " + student_id.toString());
        if( getStudentFromRedis!=null){
            return getStudentFromRedis;
        }else{
            Student getStudent =  studentRepo.findById(student_id).get();
            redisTemplate.opsForValue().set("Student: " + getStudent.getId(), getStudent);
            return getStudent;
        }
    }
}
