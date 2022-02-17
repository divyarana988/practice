package com.example.rediswithdatabase.service;

import com.example.rediswithdatabase.entity.Course;
import com.example.rediswithdatabase.entity.Student;
import com.example.rediswithdatabase.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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

        studentRepo.deleteById(student_id);
        redisTemplate.opsForValue().getAndDelete("Student: " + student_id.toString());

        return "student deleted";
    }


    @Override
    public Student getStudentById(Integer student_id) {
        Student getStudentFromRedis = (Student)redisTemplate.opsForValue().get("Student: " + student_id.toString());
        if( getStudentFromRedis!=null){
            return getStudentFromRedis;
        }else{
            Student getStudent =  studentRepo.findById(student_id).get();
            redisTemplate.opsForValue().set("Student: " + getStudent.getId().toString(), getStudent);
            return getStudent;
        }
    }

    @Override
    public List<Student> getStudentList() {
        List<Student> studentListFromDb = studentRepo.findAll();

        for(int i=0; i<studentListFromDb.size(); i++){
            Student accessEachStudentFromList = studentListFromDb.get(i);
            redisTemplate.opsForValue().set("Student: " + accessEachStudentFromList.getId().toString(), accessEachStudentFromList);
        }

        return studentListFromDb;

    }

    @Override
    public Student updateStudentById(Integer student_id, Student student) {
        Student stdFromDB = studentRepo.findById(student_id).get();

        redisTemplate.opsForValue().getAndDelete("Student: " + student_id.toString() );

        if(Objects.nonNull(student.getStudName()) && !"".equalsIgnoreCase(student.getStudName())){
            stdFromDB.setStudName(student.getStudName());
        }


        if(Objects.nonNull(student.getAddress()) && !"".equalsIgnoreCase(student.getAddress())){
            stdFromDB.setAddress(student.getAddress());
        }

        return studentRepo.save(stdFromDB);
    }
}