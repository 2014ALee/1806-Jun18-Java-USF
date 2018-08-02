package com.revature;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.revature.beans.FlashCard;

public class ClientDriver {
	
	private static final Logger LOG = LoggerFactory.getLogger(ClientDriver.class);
	private static final String API_URL = "http://localhost:9999/spring-hibernate/flashcards/";
	
	public static void main(String[] args) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		try {
			
			System.out.println("GET ALL FLASH CARDS");
//			List<FlashCard> cards = new ArrayList<>();
			
			
//			ResponseEntity<List> response = restTemplate.getForEntity(API_URL, cards, List.class);
//			ResponseEntity<List> response = restTemplate.getForEntity(API_URL, List.class);
			ResponseEntity<FlashCard[]> response = restTemplate.getForEntity(API_URL, FlashCard[].class);
			
			System.out.println("Status Code: [" + response.getStatusCodeValue() + "] - " + response.getStatusCode());
			System.out.println("Response Headers: " + response.getHeaders());
			
			FlashCard[] cards = response.getBody();
			System.out.println("Payload: " + cards + "\n");
			
		} catch(Exception e) {
			LOG.error("Resource consumtion failed");
		}
		
		try {
			
			System.out.println("Get flashcard by id");
			ResponseEntity<FlashCard> response = restTemplate.getForEntity(API_URL + "1", FlashCard.class);
			LOG.info(response.toString());
			
			System.out.println("Status Code: [" + response.getStatusCodeValue() + "] - " + response.getStatusCode());
			
			
		} catch(Exception e) {
			LOG.error("Resource consumption failed");
		}
		
		try {
			
			System.out.println("ADD NEW FLASH CARD");
			FlashCard card = new FlashCard("What is the minimum number of beans required to configure Hibernate with Spring", "3");
			
			ResponseEntity<FlashCard> response = restTemplate.postForEntity(API_URL, card, FlashCard.class);
			
			System.out.println("Status Code: [" + response.getStatusCodeValue() + "] - " + response.getStatusCode());
			System.out.println("Response Headers: " + response.getHeaders());
			
			card = response.getBody();
			System.out.println("Payload: " + card + "\n");
			
		} catch(Exception e) {
			LOG.error("Resource creation failed");
		}
	}

}
