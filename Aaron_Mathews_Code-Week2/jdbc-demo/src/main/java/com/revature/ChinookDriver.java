package com.revature;

import java.sql.Connection;
import java.util.ArrayList;

import com.revature.dao.ArtistDAO;
import com.revature.dao.ArtistDAOImpl;
import com.revature.models.Album;
import com.revature.models.Artist;
import com.revature.util.ConnectionFactory;

public class ChinookDriver {
	
	public static void main(String[] args) {
		
		System.out.println("Spinning up the app...");
		
		Connection conn = ConnectionFactory.getInstance().getConnection();
		
		ArtistDAO artistDAO = new ArtistDAOImpl();
//		
//		//Get all artist
//		ArrayList<Artist> artists = artistDAO.getAllArtists();
//		
//		for(Artist art : artists) {
//			System.out.println(art);
//		}
//		
//		Artist a = artistDAO.getArtistById(273);
//		System.out.println(a);
//		
//		ArrayList<Artist> artistByName = artistDAO.getArtistsByName("Nash Ensemble");
//		System.out.println(artistByName);
//		
//		Artist createArtist = artistDAO.createArtist(new Artist(277, "DMX"));
//		System.out.println(createArtist);
//		
//		createArtist.setName("Tyga");
//		boolean updated = artistDAO.updateArtist(createArtist);
//		
//		System.out.println("DMX was updated to " + createArtist + ": " + updated);
//		
//		Artist b = artistDAO.createArtist(new Artist(1, "Phoenix"));
//		
//		System.out.println(artistDAO.getArtistsByName("Phoenix"));
		
		Artist thisArtist = artistDAO.getArtistById(1);
		
		for (Album artistAlbum : artistDAO.getArtistAlbums(thisArtist)) {
			System.out.println(artistAlbum);
		}
		
	}

}
