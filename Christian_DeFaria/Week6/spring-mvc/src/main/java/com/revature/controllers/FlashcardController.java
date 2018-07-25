package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.beans.Flashcard;
import com.revature.services.FlashcardService;

@Controller
@RequestMapping("/flashcards")
public class FlashcardController {
	
	static {
		System.out.println("[DEBUG] - FlashcardController instanciated...");
	}
	
	@Autowired
	private FlashcardService fcService;
	
	@ResponseBody
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Flashcard> getAllCards() {
		System.out.println("[DEBUG] - In FlashcardController.getAllCards");
		return fcService.getAll();
	}
	
	@ResponseBody
	@GetMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Flashcard getCardById(@PathVariable int id) {
		System.out.println("[DEBUG] - In FlashcardController.getCardById");
		return fcService.getById(id);
	}
	
	@ResponseBody
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Flashcard> addCard(@RequestBody Flashcard card) {
		System.out.println("[DEBUG] - In FlashcardController.addCard");
		fcService.addCard(card);
		return new ResponseEntity<Flashcard>(HttpStatus.CREATED);
	}
	
	@ResponseBody
	@PutMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Flashcard> updateCard(@RequestBody Flashcard card) {
		System.out.println("[DEBUG] - In FlashcardController.updateCard");
		Flashcard fc = fcService.updateCard(card);
//		if(fc == null) {
//			return new ResponseEntity<Flashcard>(HttpStatus.NOT_FOUND);
//		} else {
//			return new ResponseEntity<Flashcard>(HttpStatus.OK);
//		}
		return (fc == null) ? new ResponseEntity<Flashcard>(fc, HttpStatus.NOT_FOUND) : new ResponseEntity<Flashcard>(fc, HttpStatus.OK);
	}
	
	@ResponseBody
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Flashcard> deleteCard(@PathVariable int id) {
		System.out.println("[DEBUG] - In FlashcardController.deleteCard");
		fcService.deleteCard(id);
		return new ResponseEntity<Flashcard>(HttpStatus.OK);
	}
}
