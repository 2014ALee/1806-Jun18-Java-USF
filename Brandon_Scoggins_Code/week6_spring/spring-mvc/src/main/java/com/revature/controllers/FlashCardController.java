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

import com.revature.beans.FlashCard;
import com.revature.services.FlashCardService;

@Controller
@RequestMapping(value="/flashcards")
public class FlashCardController {

	static {
		System.out.println("[DEBUG] - FlashCardController instantiated");
	}
	
	@Autowired
	private FlashCardService fcService;
	
	// Tested with POSTMAN on 7/25/2018 by B.Scoggins
	@ResponseBody
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<FlashCard> getAllCards() {
		System.out.println("[DEBUG] - In flashCardController.getAllCards()");
		return fcService.getAll();
	}
	
	@ResponseBody
	@GetMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public FlashCard getCardById(@PathVariable int id) {
		System.out.println("[DEBUG] - In flashCardController.getCardById()");
		return fcService.getById(id);
	}
	
	@ResponseBody
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FlashCard> addCard(@RequestBody FlashCard newCard) {
		System.out.println("[DEBUG] - In flashCardController.addCard()");
		fcService.addCard(newCard);
		return new ResponseEntity<FlashCard>(HttpStatus.CREATED);	// Http status code = 201
	}
	
	@ResponseBody
	@PutMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FlashCard> updateCard(@RequestBody FlashCard updatedCard) {
		System.out.println("[DEBUG] - In flashCardController.updateCard()");
		FlashCard card = fcService.updateCard(updatedCard);
		
		if(card == null) {
			return new ResponseEntity<FlashCard>(HttpStatus.NOT_FOUND); 	// Http status code = 404
		} else {
			return new ResponseEntity<FlashCard>(card, HttpStatus.OK); 	// Http status code = 200
		}
	}
	
	@ResponseBody
	@DeleteMapping(value="/{id}")
	public ResponseEntity<FlashCard> deleteCard(@PathVariable int id) {
		System.out.println("[DEBUG] - In flashCardController.updateCard()");
		fcService.deleteCard(id);
		return new ResponseEntity<FlashCard>(HttpStatus.OK);
	}
}
