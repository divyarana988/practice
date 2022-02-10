package com.example.integrateredis.integrateredis.repository;

import com.example.integrateredis.integrateredis.entity.Course;
import com.example.integrateredis.integrateredis.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class CourseRepoImpl implements CourseRepo{


    @Autowired
    private RedisTemplate redisTemplate;

    private static final String KEY = "COURSE";


    @Override
    public boolean saveCourse(Course course) {
        try {
            redisTemplate.opsForHash().put(KEY, course.getCourse_Id().toString(), course);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Course> getCourseList() {
        List<Course> courseList;
        courseList = redisTemplate.opsForHash().values(KEY);
        return courseList;
    }

    @Override
    public Course getCourseById(Integer course_id) {
        return (Course) redisTemplate.opsForHash().get(KEY, course_id.toString());
    }

    @Override
    public String delCourseById(Integer course_id) {
        redisTemplate.opsForHash().delete(KEY, course_id.toString());
        return "student deleted";
    }
}
