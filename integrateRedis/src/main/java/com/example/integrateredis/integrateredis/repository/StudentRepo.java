package com.example.integrateredis.integrateredis.repository;


import com.example.integrateredis.integrateredis.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepo extends JpaRepository<Student, Integer> {


}
