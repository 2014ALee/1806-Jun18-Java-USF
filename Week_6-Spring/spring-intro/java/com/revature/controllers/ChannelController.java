package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Channel;
import com.revature.services.ChannelService;	

@RestController
@RequestMapping(value="/channel")
public class ChannelController {
	static {
		System.out.println("Log - In ChannelController");
	}
		
	
	@Autowired
	private ChannelService channelService;
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Channel> getAll() {
		System.out.println("Log - In ChannelController.getAll()");
		return channelService.getAll();
	}
	

}
