package com.skilldistillery.tudorjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EntityScan("com.skilldistillery.tudorjpa")
public class SpringMvcTutadvisorApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcTutadvisorApplication.class, args);
	}

}
