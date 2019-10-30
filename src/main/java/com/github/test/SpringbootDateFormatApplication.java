package com.github.test;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringbootDateFormatApplication{

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDateFormatApplication.class, args);
	}
	
	@GetMapping
	public String  DateFormateTest(@DateTimeFormat(pattern = "yyyyMMdd")Date date) {
		return "success";
	}
	
}
