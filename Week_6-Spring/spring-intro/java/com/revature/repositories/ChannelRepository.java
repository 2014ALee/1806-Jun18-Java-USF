package com.revature.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.beans.Channel;
import com.revature.beans.User;

@Repository
public class ChannelRepository {

	@Autowired
	SessionFactory sessionFactory;
	
	public Channel createChannel(Channel newChannel){
		System.out.println("LOG - In ChannelRepository.addChannel");
		Session session = sessionFactory.getCurrentSession();
		session.save(newChannel);
		return newChannel;
	}


	public List<Channel> getAll() {
		System.out.println("Log - In ChannelRepository.getAll()...");
		Session s  = sessionFactory.getCurrentSession();
		return s.createQuery("from CHANNEL", Channel.class).getResultList();
	}
	
	
	/*
	updateUser(FlashCard)

	deleteUser(int)	
	
	getAllUsers()

	getUserById(int)
*/


}
