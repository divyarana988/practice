package com.jpa.springjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class SpringJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringJpaApplication.class, args);
    }


    @Bean
    public CommandLineRunner run(EmployeeRepo repository) {
        return (args) -> {
            insert(repository);
            System.out.println(repository.findAll());

            System.out.println(repository.findEmployeeById(2));
        };
    }


    private void insert(EmployeeRepo repository) {
        repository.save(new Employee(1,"John", "araham"));
        repository.save(new Employee(2,"Trisha", "disha"));
        repository.save(new Employee(3,"Helena", "Miss"));
    }

}
