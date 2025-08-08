package com.example.ahihi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.ahihi.entities.Room;

// @SpringBootApplication
@SpringBootApplication(exclude = org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class)
public class AhihiApplication {
	public static void main(String[] args) {
		SpringApplication.run(AhihiApplication.class, args);

	}
}
