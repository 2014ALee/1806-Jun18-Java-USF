package com.revature.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.beans.FlashCard;

//same as dao class
@Repository
public class FlashCardRepository {

	static {
		System.out.println("debug- flashcardrepository instantiated...");
		
	}
	
	@Autowired
	SessionFactory sessionFactory;
	
	public List<FlashCard> getAll(){
		System.out.println("debug - in flashcardrepository getAll()...");
		Session s = sessionFactory.getCurrentSession();
		return s.createQuery("from FlashCard", FlashCard.class).getResultList();
	}
	
	public FlashCard getById(int id){
		System.out.println("debug - in flashcardrepository getById()...");
		Session s = sessionFactory.getCurrentSession();
		return s.get(FlashCard.class, id);
	}
	
	public FlashCard addCard(FlashCard newCard) {
		System.out.println("debug cool addCard()");
		Session s = sessionFactory.getCurrentSession();
		s.save(newCard);
		return newCard;
	}
	
	
	public FlashCard updateCard(FlashCard updatedCard) {
		System.out.println("updateCard()");
		Session s = sessionFactory.getCurrentSession();
		FlashCard card = s.get(FlashCard.class, updatedCard.getId());
		card = updatedCard;
		return card;
	}
	
	public void deleteCard(int id) {
		System.out.println("updateCard()");
		Session s = sessionFactory.getCurrentSession();
		FlashCard card = s.get(FlashCard.class, id);
		s.delete(card);
	}
}