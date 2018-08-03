package com.revature;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.revature.services.BookService;

@RestController
@EnableCircuitBreaker
@SpringBootApplication
@EnableHystrixDashboard
public class ReadingServiceDriver {

	@Autowired
	private BookService bookService;

	@Bean
	public RestTemplate rest(RestTemplateBuilder builder) {
		return builder.build();
	}

	@GetMapping(value = "/reading-list")
	public String getReadingList() {
		return bookService.fetchReadingList();
	}

	public static void main(String[] args) {
		SpringApplication.run(ReadingServiceDriver.class, args);
	}
}
