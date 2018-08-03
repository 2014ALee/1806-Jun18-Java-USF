package com.revature;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.revature.beans.FlashCard;

public class ClientDriver {

	private static final Logger LOG = LoggerFactory.getLogger(ClientDriver.class);
	private static final String API_URL = "http://localhost:8080/spring-hibernate/flashcards/";
	
	public static void main(String[] args) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		// Get all Flashcards
		try {
			
		} catch(Exception e) {
			LOG.error("Resource consumption failed.");
		}
		
		// Get flash card by id
		try {
			System.out.println("Get flash card by id..");
			ResponseEntity<FlashCard> response = restTemplate.getForEntity(API_URL + 1, FlashCard.class);
			
			LOG.info(response.toString());
			
			System.out.println("Status code: [" + response.getStatusCodeValue() + "]" + response.getStatusCode());
			System.out.println("Response Headers: " + response.getHeaders());
			
			FlashCard card = response.getBody();
			System.out.println("PayLoad: " + card + "\n");
			
		} catch(Exception e) {
			LOG.error("Resource consumption failed.");
		}
		
		// Add new flash card
		try {
			System.out.println("Add new flash card");
			
			FlashCard card = new FlashCard("What is the min number of beans required to configure Hibernate with Spring?", "3");
			ResponseEntity<FlashCard> response = restTemplate.postForEntity(API_URL, card, FlashCard.class);
			
			LOG.info(response.toString());
			
			System.out.println("Status code: [" + response.getStatusCodeValue() + "]" + response.getStatusCode());
			System.out.println("Response Headers: " + response.getHeaders());
			
			card = response.getBody();
			System.out.println("PayLoad: " + card + "\n");			
		} catch(Exception e) {
			LOG.error("Resource post failed.");
		}
		
		// Update a flash card
		try {
			System.out.println("Update flash card");
			
			FlashCard card = new FlashCard(1, "Update question?", "Updated answer");
			restTemplate.put(API_URL, card);
			LOG.info(card.toString());
//			LOG.info(response.toString());
//			
//			System.out.println("Status code: [" + response.getStatusCodeValue() + "]" + response.getStatusCode());
//			System.out.println("Response Headers: " + response.getHeaders());
//			
//			card = response.getBody();
			System.out.println("PayLoad: " + card + "\n");
		} catch(Exception e) {
			LOG.error("Resource put failed.");
		}
		
		// Delete a flash card
		try {
			System.out.println("Delete flash card");
			
//			ResponseEntity<FlashCard> response = restTemplate.postForEntity(API_URL, card, FlashCard.class);
			restTemplate.delete(API_URL + "/1");
			
//			LOG.info(response.toString());
//			
//			System.out.println("Status code: [" + response.getStatusCodeValue() + "]" + response.getStatusCode());
//			System.out.println("Response Headers: " + response.getHeaders());
//			
//			card = response.getBody();
//			System.out.println("PayLoad: " + card + "\n");	
		} catch(Exception e) {
			LOG.error("Resource deletion failed.");
		}
	}
}
