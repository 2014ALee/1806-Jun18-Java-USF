package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.beans.Flashcard;

@Service
public class FlashcardService {
	
	private static ArrayList<Flashcard> cards;
	static int count;
	
	static {
		System.out.println("[DEBUG] - Flashcard Instance instanciated");
		
		cards = new ArrayList<>();
		cards.add(new Flashcard(1, "test", "answer"));
        cards.add(new Flashcard(2, "What does DI promote?", "loose-coupling"));
        cards.add(new Flashcard(3, "What is the primary IOC container in Spring?", "ApplicationContext"));
        cards.add(new Flashcard(4, "What are the Spring stereotype annotations?", "@Component, @Controller, @Service, and @Repository"));
        cards.add(new Flashcard(5, "What is the difference between ApplicationContext and BeanFactory with regard to bean instantiation?",
                "BeanFactory lazily instantiates beans, while ApplicationContext eagerly loads beans"));
        
        count = 5;
	}
	
	public List<Flashcard> getAll() {
		return cards;
	}
	
	public Flashcard getById(int id) {
//		for(Flashcard card : cards) {
//			if(card.getId() == id) {
//				return card;
//			}
//		}
//		return null;
		return cards.stream().filter(card -> card.getId() == id).findFirst().get();
	}
	
	public Flashcard addCard(Flashcard fc) {
		fc.setId(++count);
		cards.add(fc);
		return fc;
	}
	
	public Flashcard updateCard(Flashcard fc) {
		int id  = fc.getId();
		Flashcard card = getById(id);
		
		if(card == null) {
			return null;
		}
		
		card.setQuestion(fc.getQuestion());
		card.setAnswer(fc.getAnswer());
		
		return card;
	}
	
	public void deleteCard(int id) {
		cards.removeIf(card -> card.getId() == id);
	}

}
