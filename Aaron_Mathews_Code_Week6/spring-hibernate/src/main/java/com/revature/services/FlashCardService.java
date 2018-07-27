package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.FlashCard;
import com.revature.repositories.FlashCardRepository;

@Service
@Transactional
public class FlashCardService {
	
	@Autowired
	FlashCardRepository fcr;
	
	static {
		System.out.println("[Debug] - FlashCardService instantiated");
	}

	public List<FlashCard> getAll() {
		return fcr.getAll();
	}
	
	public FlashCard getById(int id) {
		return fcr.getById(id);
	}
	
	public FlashCard addCard(FlashCard fc) {
		return fcr.addCard(fc);
	}
	
	public FlashCard updateCard(FlashCard fc) {
		return fcr.updateCard(fc);
	}
	
	public void deleteCard(int id) {
		fcr.deleteCard(id);
	}

}
