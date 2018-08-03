package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.FlashCard;
import com.revature.services.FlashCardService;

@RestController //implies at controller and at response body inside each controller
@RequestMapping(value="/flashcards")
public class FlashCardController {
	
	@Autowired
	FlashCardService service;
	
	static {
		System.out.println("[DEBUG] - FlashCardController instantiated...");
	}

	@GetMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public FlashCard getById(@PathVariable int id) {
		System.out.println("[DEBUG] - In FlashCardController.getById(int id)...");
		return service.getById(id);
	}
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<FlashCard> getAll(){
		System.out.println("[DEBUG] - In FlashCardController.getAll()...");
		return service.getAll();
	}
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FlashCard> addFlashCard(@RequestBody FlashCard fc){
		System.out.println("[DEBUG] - In FlashCardController.addFlashCard(FlashCard fc)...");
		service.addCard(fc);
		return new ResponseEntity<FlashCard>(HttpStatus.CREATED); // HTTP status code = 201
	}
	
	@PutMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FlashCard> updateFlashCard(@RequestBody FlashCard fc) {
		System.out.println("[DEBUG] - In FlashCardController.getById(int id)...");
		
		FlashCard card = service.updateCard(fc);
		
		if(card==null) {
			return new ResponseEntity<FlashCard>(HttpStatus.NOT_FOUND); // HTTP status code = 404
		} else {
			return new ResponseEntity<FlashCard>(card, HttpStatus.OK); // HTTP status code = 200 (204, No Content, would be acceptable as well)
		}
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<FlashCard> deleteFlashCard(@PathVariable int id){
		service.delete(id);
		return new ResponseEntity<FlashCard>(HttpStatus.OK); // HTTP status code = 200
	}
	
}
