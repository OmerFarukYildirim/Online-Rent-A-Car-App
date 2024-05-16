package com.System_Design_Project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class SystemDesignProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SystemDesignProjectApplication.class, args);
	}

}
