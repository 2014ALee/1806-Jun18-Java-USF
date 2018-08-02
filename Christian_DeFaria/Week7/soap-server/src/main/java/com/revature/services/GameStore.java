package com.revature.services;

import java.util.List;

import javax.jws.WebService;

import com.revature.exceptions.GameNotFound;
import com.revature.models.Game;

@WebService
public interface GameStore {
	
	List<Game> getAllGames();
	String addGame(Game g);
	Game getGame(String title) throws GameNotFound;

}
