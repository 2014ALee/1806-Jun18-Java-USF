package com.revature;

import java.util.HashMap;
import java.util.Map;

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

		// Get all flash cards
		try {
			
			ResponseEntity<FlashCard[]> response = restTemplate.getForEntity(API_URL, FlashCard[].class);
			System.out.println(response.getBody() + "\n");
			
			LOG.info(response.toString());
			
			FlashCard[] cards = response.getBody();
			for (FlashCard card : cards) {
				System.out.println("Card: " + card);
			}
			
		} catch (Exception e) {
			LOG.error("Resource consumption failed");
		}

		// Get a flash card by id
		try {
			
			System.out.println("GET FLASH CARD BY ID");
			ResponseEntity<FlashCard> response = restTemplate.getForEntity(API_URL + "2" , FlashCard.class);
			LOG.info(response.toString());
			
			System.out.println("Status Code: [" + response.getStatusCodeValue() + "] - " + response.getStatusCode());
			System.out.println("Response Headers: " + response.getHeaders());
			
			FlashCard card = response.getBody();
			System.out.println("Payload: " + card + "\n");
			
		} catch (Exception e) {
			LOG.error("Resource consumption failed");
		}

		// Add a new flash card
		try {
			System.out.println("ADD NEW FLASH CARD");
			FlashCard card = new FlashCard("What is the minimum number of beans required to configure Hibernate with Spring?", "3");
			ResponseEntity<FlashCard> response = restTemplate.postForEntity(API_URL, card, FlashCard.class);
			LOG.info(response.toString());
			
			System.out.println("Status Code: [" + response.getStatusCodeValue() + "] - " + response.getStatusCode());
			System.out.println("Response Headers: " + response.getHeaders());
			
			card = response.getBody();
			System.out.println("Payload: " + card + "\n");
			
			
		} catch (Exception e) {
			LOG.error("Resource creation failed");
		}

		// Update a flash card
		try {
			System.out.println("UPDATE FLASH CARD");
			System.out.println("Current card with id 2: " + restTemplate.getForEntity(API_URL + "2" , FlashCard.class));
		    Map<String, String> params = new HashMap<String, String>();
		    params.put("id", "2");
		     
		    FlashCard updatedFlashCard = new FlashCard(2, "What is Java?", "An OOP coding language");
		     
		    restTemplate.put (API_URL, updatedFlashCard, params);
			System.out.println("Payload for update: " + restTemplate.getForEntity(API_URL + "2" , FlashCard.class) + ".\n");

		} catch (Exception e) {
			LOG.error("Resource update failed");
		}

		// Delete a flash card
		try {
			System.out.println("DELETE A FLASH CARD");
			restTemplate.delete(API_URL + 17);

		} catch (Exception e) {
			LOG.error("Resource deletion failed");
		}
	}

}
