package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	
	

	@Override
	public void run(String... arg0) throws Exception {
		System.out.println("My First Program ");
		
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
