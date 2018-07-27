package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.Channel;
import com.revature.repositories.ChannelRepository;

@Service
@Transactional
public class ChannelService {
	static {
		System.out.println("Log - ChannelService instantiated...");
	}
	
	@Autowired
	ChannelRepository ChannelRepo;
	
	public List<Channel> getAll() {
		System.out.println("Log - In ChannelService.getAll()...");
		return ChannelRepo.getAll();
	}

}
