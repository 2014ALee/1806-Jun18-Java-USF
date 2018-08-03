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
		System.out.println("[DEBUG] - flashCardRepository Instantiated");
	}
	
	@Autowired
	SessionFactory sessionFactory;
	
	public List<FlashCard> getAll() {
		System.out.println("[DEBUG] - flashCardRepository.getAll()");
		Session s = sessionFactory.getCurrentSession();
		return s.createQuery("from FlashCard", FlashCard.class).getResultList();
	}
	
	public FlashCard getById(int id) {
		System.out.println("[DEBUG] - flashCardRepository.getById()");
		Session s = sessionFactory.getCurrentSession();
		return s.get(FlashCard.class, id);
	}
	
	public FlashCard addCard(FlashCard newCard) {
		System.out.println("[DEBUG] - flashCardRepository.addCard()");
		Session s = sessionFactory.getCurrentSession();
		s.save(newCard);
		return newCard;
	}
	
	public FlashCard updateCard(FlashCard updatedCard) {
		System.out.println("[DEBUG] - flashCardRepository.updateCard()");
		Session s = sessionFactory.getCurrentSession();
		FlashCard card = s.get(FlashCard.class, updatedCard.getId());
		
		if (card == null) {
			return card;
		}
		
		card = updatedCard;
		return card;
	}
	
	public int deleteCard(int id) {
		System.out.println("[DEBUG] - flashCardRepository.deleteCard()");
		Session s = sessionFactory.getCurrentSession();
		FlashCard card = s.get(FlashCard.class, id);
		
		if (card == null) {
			return -1;
		}
		
		s.delete(card);
		return 1;
	}
}
