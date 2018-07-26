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
		System.out.println("debug- FlashCardController instantiated...");
	}
	
	@Autowired
	private FlashCardService fcService;
	
	@ResponseBody
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<FlashCard> getAllCards(){
		System.out.println("debug- FlashCardController getAllCards()...");

		return fcService.getAll();
	}
	
	@ResponseBody
	@GetMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public FlashCard getCardById(@PathVariable int id) {
		System.out.println("debug- FlashCardController getCardById()...");
		return fcService.getById(id);
	}
	
	@ResponseBody
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	//return a response entity with a status code rather than sending back a database object to check if it was successful or found
	public ResponseEntity<FlashCard> addCard(@RequestBody FlashCard newCard){
		System.out.println("debug- in FlashCardController.addCard()...");
		fcService.addCard(newCard);
		return new ResponseEntity<FlashCard>(HttpStatus.CREATED); //http status code 201
	}
	
	@ResponseBody
	@PutMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FlashCard> updateCard(@RequestBody FlashCard updatedCard){
		
		System.out.println("debug - in flashcardcontroller updateCard()");
		FlashCard card = fcService.updateCard(updatedCard);
		
		if (card == null) {
			return new ResponseEntity<FlashCard>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<FlashCard>(card, HttpStatus.OK); //this provides card as well as status
		}
	}

	@ResponseBody
	@DeleteMapping(value="/{id}")
	public ResponseEntity<FlashCard> deleteCard(@PathVariable int id){
		
		System.out.println("in delete card");
		fcService.deleteCard(id);
		return new ResponseEntity<FlashCard>(HttpStatus.OK);
	}
	
	
	
	
	
	
	
}
