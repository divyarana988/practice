package com.example.integrateredis.integrateredis.repository;

import com.example.integrateredis.integrateredis.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepo extends JpaRepository<Course, Integer>{



}
