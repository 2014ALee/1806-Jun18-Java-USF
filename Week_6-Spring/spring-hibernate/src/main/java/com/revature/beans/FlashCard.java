package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="FLASHCARDS")
@SequenceGenerator(name="flashcardSeq", sequenceName="FC_SEQ", allocationSize=1)
public class FlashCard {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="flashcardSeq")
	private int id;
	
	@Column(name="question")
	private String question;
	
	@Column(name="answer")
	private String answer;
	
	public FlashCard() {
		System.out.println("[DEBUG] - FlashCard instantiated...");
	}

	public FlashCard(String question, String answer) {
		super();
		this.question = question;
		this.answer = answer;
	}

	public FlashCard(int id, String question, String answer) {
		super();
		this.id = id;
		this.question = question;
		this.answer = answer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

}
