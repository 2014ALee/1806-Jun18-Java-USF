package com.revature.beans;

import org.springframework.stereotype.Component;

@Component
public class FlashCard {
	private int id;
	private String Question;
	private String answer;
	
	FlashCard() {
		System.out.println("[DEBUG] - FlashCard instantiated...");
	}

	public FlashCard(String question, String answer) {
		super();
		Question = question;
		this.answer = answer;
	}

	public FlashCard(int id, String question, String answer) {
		super();
		this.id = id;
		Question = question;
		this.answer = answer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion() {
		return Question;
	}

	public void setQuestion(String question) {
		Question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	

}
