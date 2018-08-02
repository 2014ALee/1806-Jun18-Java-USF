package com.revature.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.beans.Flashcard;

@Repository
public class FlashcardRepositories {
	
	static {
		System.out.println("[DEBUG] - Flashcard Repository instanciated");
	}
	
	@Autowired
	SessionFactory sessionFactory;
	
	public List<Flashcard> getAll() {
		System.out.println("[DEBUG] - In FlashcardRepositories.getAll");
		Session s = sessionFactory.getCurrentSession();
		return s.createQuery("from Flashcard", Flashcard.class).getResultList();
	}
	
	public Flashcard getById(int id) {
		System.out.println("[DEBUG] - In FlashcardRepositories.getById");
		Session s = sessionFactory.getCurrentSession();
		return s.get(Flashcard.class, id);
	}
	
	public Flashcard addCard(Flashcard newCard) {
		System.out.println("[DEBUG] - In FlashcardRepositories.addCard");
		Session s = sessionFactory.getCurrentSession();
		s.save(newCard);
		return newCard;
	}
	
	public Flashcard updateCard(Flashcard updatedCard) {
		System.out.println("[DEBUG] - In FlashcardRepositories.addCard");
		Session s = sessionFactory.getCurrentSession();
		Flashcard card = s.get(Flashcard.class, updatedCard.getId());
		if(card != null) {
//			return card;
			card = updatedCard;
		}
		return card;
	}
	
	public int deleteCard(int id) {
		System.out.println("[DEBUG] - In FlashcardRepositories.addCard");
		Session s = sessionFactory.getCurrentSession();
		Flashcard card = s.get(Flashcard.class, id);
		
		if(card == null) {
			return -1;
		}
		s.delete(card);
		return 1;
	}

}
