package com.example.ahihi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

// @SpringBootApplication
@SpringBootApplication(exclude = org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class)
@EnableJpaAuditing
// @EnableScheduling
public class AhihiApplication {
	public static void main(String[] args) {
		SpringApplication.run(AhihiApplication.class, args);

	}
}
