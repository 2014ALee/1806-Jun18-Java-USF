package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.FlashCard;
import com.revature.repositories.FlashCardRepository;

@Service
@Transactional // this annotation could go on top of methods instead of whole class
public class FlashCardService {

	static {
		System.out.println("debug - FlashCardService instantiated..");
	}
	
	@Autowired
	FlashCardRepository repo;
	
	public List<FlashCard> getAll(){
		System.out.println("debug - FlashCardService getAll..");
		return repo.getAll();
	}
	
	public FlashCard getById(int id) {
		System.out.println("debug - FlashCardService getById..");
		return repo.getById(id);
	}

	public FlashCard addCard(FlashCard fc) {
		System.out.println("debug - FlashCardService addCard..");
		return repo.addCard(fc);
	}
	public FlashCard updateCard(FlashCard fc) {
	
		System.out.println("debug - FlashCardService updateCard..");
		return repo.updateCard(fc);
	}
	
	public void deleteCard(int id) {
		System.out.println("debug - FlashCardService deleteCard..");
		repo.deleteCard(id);
	}
}
