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

@RestController
@RequestMapping(value="/flashcards")
public class FlashCardController {
	
	@Autowired
	private FlashCardService fcs;
	
	 
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<FlashCard> getAllCards() {
		System.out.println("in flashcardcontroller.getallcards()");
		return fcs.getAll();
	}
	
	 
	@GetMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public FlashCard getCardById(@PathVariable int id) {
		System.out.println("in flashcardcontroller.getcardbyid()");
		return fcs.getById(id);
	}
	
	 
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FlashCard> addCard(@RequestBody FlashCard newCard) {
		System.out.println("in flashcardcontroller.addcard()");
		fcs.addCard(newCard);
		return new ResponseEntity<FlashCard>(HttpStatus.CREATED); //Http Status code is 201
	}
	
	 
	@PutMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FlashCard> updateCard(@RequestBody FlashCard updatedCard) {
		System.out.println("in fcc.updateCard()");
		FlashCard card = fcs.updateCard(updatedCard);
		if (card == null) {
			return new ResponseEntity<FlashCard>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<FlashCard>(card, HttpStatus.OK);
		}
	}
	
	 
	@DeleteMapping(value="/{id}")
	public ResponseEntity<FlashCard> deleteCard(@PathVariable int id) {
		System.out.println("in fcc.deletecard");
		fcs.deleteCard(id);
		return new ResponseEntity<FlashCard>(HttpStatus.OK);
	}

}
