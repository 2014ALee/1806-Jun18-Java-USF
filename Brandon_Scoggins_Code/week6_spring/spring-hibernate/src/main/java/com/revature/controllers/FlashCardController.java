package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.FlashCard;
import com.revature.beans.FlashCardErrorResponse;
import com.revature.exceptions.FlashCardNotFoundException;
import com.revature.services.FlashCardService;

@RestController
@RequestMapping(value="/flashcards")
public class FlashCardController {

	static {
		System.out.println("[DEBUG] - FlashCardController instantiated");
	}
	
	@Autowired
	private FlashCardService fcService;
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<FlashCard> getAllCards() {
		System.out.println("[DEBUG] - In flashCardController.getAllCards()");
		return fcService.getAll();
	}
	
	@GetMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public FlashCard getCardById(@PathVariable int id) {
		System.out.println("[DEBUG] - In flashCardController.getCardById()");
		FlashCard card = fcService.getById(id);
		
		if(card == null) {
			throw new FlashCardNotFoundException("Flash card with id " + id + " not found");
		}
		
		return card;
	}
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FlashCard> addCard(@RequestBody FlashCard newCard) {
		System.out.println("[DEBUG] - In flashCardController.addCard()");
		FlashCard card = fcService.addCard(newCard);
		return new ResponseEntity<FlashCard>(card, HttpStatus.CREATED);	// Http status code = 201
	}
	
	@PutMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FlashCard> updateCard(@RequestBody FlashCard updatedCard) {
		System.out.println("[DEBUG] - In flashCardController.updateCard()");
		FlashCard card = fcService.updateCard(updatedCard);
		
		if(card == null) {
			throw new FlashCardNotFoundException("Flash card with id " + updatedCard.getId() + " not found");
		} 
		
		return new ResponseEntity<FlashCard>(HttpStatus.OK); 	// Http status code = 200
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<FlashCard> deleteCard(@PathVariable int id) {
		System.out.println("[DEBUG] - In flashCardController.updateCard()");
		int deleted = fcService.deleteCard(id);
		
		if (deleted == -1) {
			throw new FlashCardNotFoundException("Flash card with id " + id + " not found");
		}
		
		return new ResponseEntity<FlashCard>(HttpStatus.OK);
	}
	
	@ExceptionHandler
	public ResponseEntity<FlashCardErrorResponse> flashCardNotFound(FlashCardNotFoundException e){
		
		// Create a FlashCardErrorResponse object
		FlashCardErrorResponse error = new FlashCardErrorResponse();
		
		// Set its values
		error.setStatusCode(HttpStatus.NOT_FOUND.value());
		error.setMessage(e.getMessage());
		error.setTimestamp(System.currentTimeMillis());
		
		// Return ResponseEntity
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
//		return new ResponseEntity<>(error, HttpStatus.I_AM_A_TEAPOT);
		
	}
}
