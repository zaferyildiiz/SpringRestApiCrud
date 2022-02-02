package com.spring.springApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories; 
 
@SpringBootApplication
@ComponentScan(basePackages = {"com.spring.springApi"})
@EnableJpaRepositories("com.spring.springApi")
public class SpringApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringApiApplication.class, args);
	}

}
