package com.example.integrateredis.integrateredis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class IntegrateRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(IntegrateRedisApplication.class, args);
    }

}
