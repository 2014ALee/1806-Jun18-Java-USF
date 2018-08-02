package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import com.revature.exceptions.GameNotFound;
import com.revature.models.Game;

@WebService(endpointInterface="com.revature.services.GameStore")
public class GameStoreImpl implements GameStore {
	
	private static List<Game> games = new ArrayList<>();

	@Override
	public List<Game> getAllGames() {
		games.add(new Game("Splatoon 2", "E", "Nintendo"));
		games.add(new Game("Call of Duty: Black Ops", "T" , "All"));
		games.add(new Game("Halo", "T", "Xbox"));
		return games;
	}

	@Override
	public String addGame(Game g) {
		games.add(g);
		return "Added " + g.getTitleName() + " to game inventory.";
	}

	@Override
	public Game getGame(String title) throws GameNotFound {
		for(Game g : games) {
			if(g.getTitleName() == title) {
				return g;
			}
		}
		throw new GameNotFound(title + ": isn't in our inventory");
	}

}
