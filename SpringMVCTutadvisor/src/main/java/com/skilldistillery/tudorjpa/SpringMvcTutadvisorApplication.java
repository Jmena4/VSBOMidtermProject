package com.skilldistillery.tudorjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@EntityScan("com.skilldistillery.tudorjpa")
public class SpringMvcTutadvisorApplication extends SpringBootServletInitializer{
	 @Override
	  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	    return application.sources(SpringMvcTutadvisorApplication.class);
	  }
	public static void main(String[] args) {
		SpringApplication.run(SpringMvcTutadvisorApplication.class, args);
	}

}
