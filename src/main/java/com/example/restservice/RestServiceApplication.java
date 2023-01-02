package com.example.restservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class RestServiceApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(RestServiceApplication.class, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//@Bean
	
}
