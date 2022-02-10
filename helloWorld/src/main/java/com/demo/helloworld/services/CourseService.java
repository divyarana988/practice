package com.demo.helloworld.services;
import java.util.ArrayList;
import java.util.List;
import com.demo.helloworld.entities.Course;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    List<Course> list;

    public CourseService(){
        list = new ArrayList<>();
        list.add(new Course(1, "java course", "great"));
        list.add(new Course(2, "c course", "greater"));
    }

    public List<Course> getCourses(){
        return list;
    }

    public Course getCourse(long courseId){
        Course c = null;
        for(Course course: list){
            if(course.getId() == courseId){
                c = course;
                break;
            }
        }
        return c;
    }

    public Course addCourse(Course course){
        list.add(course);
        return course;
    }

    public Course updateCourse(Course course){
        for(int i=0; i<list.size(); i++){
            if(list.get(i).getId() == course.getId()){
                list.get(i).setTitle(course.getTitle());
                list.get(i).setDesc((course.getDesc()));
            }
        }
        return course;
    }

}
