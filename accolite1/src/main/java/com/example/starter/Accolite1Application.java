package com.example.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin(origins = "http://localhost:4200")
@ComponentScan({"com.example.assignments","com.example.starter","com.example.user", "com.example.config","com.example.service","com.example.model"})
public class Accolite1Application {

	public static void main(String[] args) {
		SpringApplication.run(Accolite1Application.class, args);
	}

}
