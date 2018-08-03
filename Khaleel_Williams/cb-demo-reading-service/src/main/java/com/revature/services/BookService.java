package com.revature.services;

import java.net.URI;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@Service
public class BookService {
	
	private final RestTemplate restTemplate;
	
	public BookService(RestTemplate rest) {
		this.restTemplate = rest;
	}
	
	@HystrixCommand(fallbackMethod="fallbackReadingList")
	public String fetchReadingList() {
		URI uri = URI.create("http://localhost:8090/recommended");
		return this.restTemplate.getForObject(uri, String.class);
	}
	

	public String fallbackReadingList() {
		return "Cloud native Java (O'Reilly)";
	}
}
