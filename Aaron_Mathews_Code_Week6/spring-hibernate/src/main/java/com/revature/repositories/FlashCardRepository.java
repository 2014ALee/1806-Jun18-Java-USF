package com.revature.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.beans.FlashCard;

@Repository
public class FlashCardRepository {
	
	static {
		System.out.println("FlashCardRepository instantiated");
	}
	
	@Autowired
	SessionFactory sessionFactory;
	
	public List<FlashCard> getAll() {
		System.out.println("in flashcardrepo.getAll()");
		Session s = sessionFactory.getCurrentSession();
		return s.createQuery("from FlashCard", FlashCard.class).getResultList();
	}
	
	public FlashCard getById(int id) {
		System.out.println("in flashcardrepo.getById()");
		Session s = sessionFactory.getCurrentSession();
		return s.get(FlashCard.class, id);
	}
	
	public FlashCard addCard(FlashCard newCard) {
		System.out.println("in addCard");
		Session s = sessionFactory.getCurrentSession();
		s.save(newCard);
		return newCard;
	}
	
	public FlashCard updateCard(FlashCard updatedCard) {
		System.out.println("in updateCard");
		Session s = sessionFactory.getCurrentSession();
		FlashCard card = s.get(FlashCard.class, updatedCard.getId());
		card = updatedCard;
		return card;
	}
	
	public void deleteCard(int id) {
		System.out.println("in flashcardrepo.deleteCard()");
		Session s = sessionFactory.getCurrentSession();
		FlashCard card = s.get(FlashCard.class, id);
		s.delete(card);
	}

}
