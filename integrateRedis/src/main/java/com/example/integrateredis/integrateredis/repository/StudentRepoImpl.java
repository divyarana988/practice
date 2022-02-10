package com.example.integrateredis.integrateredis.repository;

import com.example.integrateredis.integrateredis.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepoImpl implements StudentRepo {

    @Autowired
    private RedisTemplate redisTemplate;

    private static final String KEY = "STUDENT";

    @Override
    @CacheEvict(value = "student", allEntries = true)
    public boolean saveStudent(Student student) {

        try {
            redisTemplate.opsForHash().put(KEY, student.getStudent_id().toString(), student);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    @Cacheable("student")
    public List<Student> getAllStudent() {
        System.out.println("called from db");
        List<Student> studentList;
        studentList = redisTemplate.opsForHash().values(KEY);
        return studentList;
    }

    @Override
    public String delStudentById(Integer student_id) {
        redisTemplate.opsForHash().delete(KEY, student_id.toString());
        return "student deleted";
    }

    @Override
    @Cacheable("student")
    public Student getStudentById(Integer student_id) {
        System.out.println("called from db");
        return (Student) redisTemplate.opsForHash().get(KEY, student_id.toString());
    }
}
