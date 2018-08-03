package com.revature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class BookstoreServiceDriver {

	@GetMapping(value="/recommended")
	public String readingList() {
		return "Spring in Action (Manning), Cloud Natvie Java (O'Reilly), Learning Spring Boot (Pakt)";
	}
	public static void main(String[] args) {
		SpringApplication.run(BookstoreServiceDriver.class, args);
	}
}
