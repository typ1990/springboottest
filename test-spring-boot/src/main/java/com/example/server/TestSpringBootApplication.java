package com.example.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example")
public class TestSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestSpringBootApplication.class, args);
	}
}
