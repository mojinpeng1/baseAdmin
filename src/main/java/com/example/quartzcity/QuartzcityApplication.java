package com.example.quartzcity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = "com.example.quartzcity")
public class QuartzcityApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuartzcityApplication.class, args);
    }

}
