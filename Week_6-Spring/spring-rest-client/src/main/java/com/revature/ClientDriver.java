package com.revature;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.revature.beans.FlashCard;

public class ClientDriver {

	private static final Logger LOG = LoggerFactory.getLogger(ClientDriver.class);
	private static final String API_URL = "http://localhost:9999/spring-hibernate/flashcards/";

	public static void main(String[] args) {

		RestTemplate restTemplate = new RestTemplate();

		// Get all flash cards
		try {		
			//code from http://www.baeldung.com/spring-rest-template-list
			System.out.println("GET ALL FLASH CARDS");
			ResponseEntity<List<FlashCard>> response = restTemplate.exchange(API_URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<FlashCard>>(){});
			List<FlashCard> card = response.getBody();
			System.out.println(card);
			
			//more simple version
			//getForObject(url, Class<T> responseType)
			
		} catch (Exception e) {
			LOG.error("Resource consumption failed");
		}

		
		//works
//		// Get a flash card by id
//		try {
//			
//			System.out.println("GET FLASH CARD BY ID");
//			ResponseEntity<FlashCard> response = restTemplate.getForEntity(API_URL + "1" , FlashCard.class);
//			LOG.info(response.toString());
//			
//			System.out.println("Status Code: [" + response.getStatusCodeValue() + "] - " + response.getStatusCode());
//			System.out.println("Response Headers: " + response.getHeaders());
//			
//			FlashCard card = response.getBody();
//			System.out.println("Payload: " + card + "\n");
//			
//		} catch (Exception e) {
//			LOG.error("Resource consumption failed");
//		}

		
		
		//works
		// Add a new flash card
//		try {
//			System.out.println("ADD NEW FLASH CARD");
//			FlashCard card = new FlashCard("What is the minimum number of beans required to configure Hibernate with Spring?", "3");
//			ResponseEntity<FlashCard> response = restTemplate.postForEntity(API_URL, card, FlashCard.class);
//			LOG.info(response.toString());
//			
//			System.out.println("Status Code: [" + response.getStatusCodeValue() + "] - " + response.getStatusCode());
//			System.out.println("Response Headers: " + response.getHeaders());
//			
//			card = response.getBody();
//			System.out.println("Payload: " + card + "\n");
//			
//			
//		} catch (Exception e) {
//			LOG.error("Resource creation failed");
//		}

		
		
		//not working
		// Update a flash card
//		try {
//					
//			FlashCard card = new FlashCard("What comes after 1", "2");
//		------------------------------------------------------	
//			//set params for id
////			Map<String, String> params = new HashMap<String, String>();
////		    params.put("id", "2");
//		   	
////			restTemplate.put( API_URL, card, params);
	//	-------------------------------------------------------
//		    restTemplate.put( API_URL + "2", card, FlashCard.class);
//	---------------------------------------------------------------------	    	   
		// create builder and Add query parameter
//		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(API_URL).queryParam("2");
//			restTemplate.put(builder.toUriString(), card);
			
//		} catch (Exception e) {
//			LOG.error("Resource update failed");
//		}

		
		
		//works
		// Delete a flash card
//		try {
//
//			//delete card by id
//			restTemplate.delete(API_URL + "1" , FlashCard.class);		
//			
//		} catch (Exception e) {
//			LOG.error("Resource deletion failed");
//		}
	}

}
