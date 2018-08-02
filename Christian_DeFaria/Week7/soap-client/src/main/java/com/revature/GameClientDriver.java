package com.revature;

import java.io.PrintWriter;
import java.util.List;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.revature.beans.Game;
import com.revature.services.GameStore;

public class GameClientDriver {
	
	private static final String serviceUrl = "http://soap-server.us-east-1.elasticbeanstalk.com/games";
	
	public static void main(String[] args) {
		
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setServiceClass(GameStore.class);
		factory.setAddress(serviceUrl);
		
		LoggingInInterceptor inInterceptor = new LoggingInInterceptor();
		LoggingOutInterceptor outInterceptor = new LoggingOutInterceptor();
		inInterceptor.setPrintWriter(new PrintWriter(System.out));
		outInterceptor.setPrintWriter(new PrintWriter(System.out));
		
		factory.getInInterceptors().add(inInterceptor);
		factory.getOutInterceptors().add(outInterceptor);
		
		GameStore gameStore = (GameStore) factory.create();
		
		System.out.println("[DEBUG] - GameStore.getAllGames");
		List<Game> games = gameStore.getAllGames();
		for(Game g : games) {
			System.out.println(g);
		}
		
		System.out.println("[DEBUG] - GameStore.addGame");
		System.out.println(gameStore.addGame(new Game("Legend of Zelda: Breath of the Wild", "E10+", "Nintendo")));
		
		System.out.println("[DEBUG] - GameStore.getGame");
		try {
			System.out.println(gameStore.getGame("Splatoon 2"));
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("[DEBUG] - GameStore.getGame");
		try {
			System.out.println(gameStore.getGame("Super Mario"));
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}

}
