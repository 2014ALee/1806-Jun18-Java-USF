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

import com.revature.beans.Flashcard;
import com.revature.beans.FlashcardErrorResponse;
import com.revature.exceptions.FlashcardNotFoundException;
import com.revature.services.FlashcardService;

@RestController
@RequestMapping("/flashcards")
public class FlashcardController {
	
	static {
		System.out.println("[DEBUG] - FlashcardController instanciated...");
	}
	
	@Autowired
	private FlashcardService fcService;
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Flashcard> getAllCards() {
		System.out.println("[DEBUG] - In FlashcardController.getAllCards");
		return fcService.getAll();
	}
	
	@GetMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Flashcard getCardById(@PathVariable int id) {
		System.out.println("[DEBUG] - In FlashcardController.getCardById");
		Flashcard card = fcService.getById(id);
		
		if(card == null) {
			throw new FlashcardNotFoundException("Flashcard with id: " + id + " not found");
		}
		return card;
	}
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Flashcard> addCard(@RequestBody Flashcard card) {
		System.out.println("[DEBUG] - In FlashcardController.addCard");
		Flashcard fc = fcService.addCard(card);
		return new ResponseEntity<Flashcard>(fc, HttpStatus.CREATED);
	}
	
	@PutMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Flashcard> updateCard(@RequestBody Flashcard card) {
		System.out.println("[DEBUG] - In FlashcardController.updateCard");
		Flashcard fc = fcService.updateCard(card);
		if(fc == null) {
			throw new FlashcardNotFoundException("Flashcard with id: " + card.getId() + " not found");
		}
		return new ResponseEntity<Flashcard>(HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Flashcard> deleteCard(@PathVariable int id) {
		System.out.println("[DEBUG] - In FlashcardController.deleteCard");
		int deleted = fcService.deleteCard(id);
		if(deleted < 0) {
			throw new FlashcardNotFoundException("Flashcard with id: " + id + " not found");
		}
		return new ResponseEntity<Flashcard>(HttpStatus.OK);
	}
	
	@ExceptionHandler
	public ResponseEntity<FlashcardErrorResponse> flashcardNotFound(FlashcardNotFoundException e) {
		
		FlashcardErrorResponse error = new FlashcardErrorResponse();
		
		error.setStatusCode(HttpStatus.NOT_FOUND.value());
		error.setMessage(e.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
		
	}
}
