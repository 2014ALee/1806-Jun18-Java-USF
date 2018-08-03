package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.FlashCard;
import com.revature.repositories.FlashCardRepository;

@Service
//@Transaction
public class FlashCardService {

	static ArrayList<FlashCard> cards;
	static int count;
	
	// Mocking up a persistence layer
	static {
		System.out.println("[DEBUG] - In FlashCardService instantiated...");
		
		
	}
	
	@Autowired
	FlashCardRepository repo;
	
	public List<FlashCard> getAll() {
		System.out.println("[DEBUG] - In FlashCardService.getById(int id)...");
		return repo.getAll();
	}
	
	public FlashCard getById(int id) {
		System.out.println("[DEBUG] - In FlashCardService.getById()...");
		return repo.getById(id);
	}
	
	public FlashCard addCard(FlashCard fc) {
		System.out.println("[DEBUG] - In FlashCardService.addCard()...");
		return repo.addCard(fc);
	}
	
	public FlashCard updateCard(FlashCard fc) {
		System.out.println("[DEBUG] - In FlashCardService.updateCard()...");

		return repo.updateCard(fc);
	}
	
	public void delete(int id) {
		System.out.println("[DEBUG] - In FlashCardService.deleteCard()...");
		repo.deleteCard(id);
	}

}
