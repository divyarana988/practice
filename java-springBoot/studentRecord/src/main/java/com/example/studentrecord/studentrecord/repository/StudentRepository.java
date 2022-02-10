package com.example.studentrecord.studentrecord.repository;

import com.example.studentrecord.studentrecord.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {



    @Query(value = "SELECT * FROM STUDENT WHERE COURSE_ID = ?1", nativeQuery = true)
    public Student findByCourse_Id(Integer course_Id);


}