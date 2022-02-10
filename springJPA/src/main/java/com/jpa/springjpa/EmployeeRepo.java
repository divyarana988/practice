package com.jpa.springjpa;

import org.springframework.data.repository.CrudRepository;
import java.util.List;


public interface EmployeeRepo extends CrudRepository<Employee, Long> {

    List<Employee> findEmployeeById(int x);

}
