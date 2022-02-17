package com.example.integrateredis.integrateredis.service;

import com.example.integrateredis.integrateredis.entity.Course;
import com.example.integrateredis.integrateredis.repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseRepo courseRepo;

    @Autowired
    private RedisTemplate redisTemplate;

    private static final String KEY = "COURSE";


    @Override
    public Course saveCourse(Course course) {
   //     redisTemplate.opsForHash().put(KEY, course.getCourseId().toString(), course);
        Course savedCourse = courseRepo.save(course);

 //       redisTemplate.opsForHash().entries(KEY).clear();

        return savedCourse;
    }


    @Override
    public String delCourseById(Integer course_id) {
        redisTemplate.opsForHash().delete(KEY, course_id.toString());
        // courseRepo.deleteById(course_id);
        return "student deleted";
    }

    @Override
    public List<Course> getCourseList() {

        List<Course> getAllCourse = courseRepo.findAll();

        for (int i = 0; i < getAllCourse.size(); i++) {
            Course courseAtIndexFromList = getAllCourse.get(i);
            redisTemplate.opsForHash().put(KEY, courseAtIndexFromList.getCourseId(), courseAtIndexFromList);
        }

        return getAllCourse;
    }

    @Override
    public Course updateCourseById(Integer course_id, Course course) {

        Course courseFromDB = courseRepo.findById(course_id).get();

        redisTemplate.opsForHash().delete(KEY, course_id.toString());

        if (Objects.nonNull(course.getCourseName()) && !"".equalsIgnoreCase(course.getCourseName())) {
            courseFromDB.setCourseName(course.getCourseName());
        }

        if (Objects.nonNull(course.getCourseDesc()) && !"".equalsIgnoreCase(course.getCourseDesc())) {
            courseFromDB.setCourseDesc(course.getCourseDesc());
        }

        return courseRepo.save(courseFromDB);
    }
    @Override
    public Course getCourseById(Integer course_id) {

        Course getCourseFromRedis = (Course)redisTemplate.opsForHash().get(KEY, course_id.toString());

        if( getCourseFromRedis !=null){
            return getCourseFromRedis;
        }else {
            Course getCourse =  courseRepo.findById(course_id).get();
            getCourseFromRedis = getCourse;
            return getCourse;
        }
    }
}
