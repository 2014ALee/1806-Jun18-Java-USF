package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.Flashcard;
import com.revature.repositories.FlashcardRepositories;

@Service
@Transactional
public class FlashcardService {
	
	private static ArrayList<Flashcard> cards;
	static int count;
	
	@Autowired
	FlashcardRepositories repo;
	
	static {
		System.out.println("[DEBUG] - Flashcard Instance instantiated");
	}
	
	public List<Flashcard> getAll() {
		System.out.println("[DEBUG] - In FlashcardService.getAll");
		return repo.getAll();
	}
	
	public Flashcard getById(int id) {
		System.out.println("[DEBUG] - In FlashcardService.getById");
		return repo.getById(id);
	}
	
	public Flashcard addCard(Flashcard fc) {
		System.out.println("[DEBUG] - In FlashcardService.addCard");
		return repo.addCard(fc);
	}
	
	public Flashcard updateCard(Flashcard fc) {
		System.out.println("[DEBUG] - In FlashcardService.updateCard");
		return repo.updateCard(fc);
	}
	
	public int deleteCard(int id) {
		System.out.println("[DEBUG] - In FlashcardService.deleteCard");
		return repo.deleteCard(id);
	}

}
