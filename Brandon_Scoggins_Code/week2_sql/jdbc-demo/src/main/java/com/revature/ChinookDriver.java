package com.revature;

import java.util.ArrayList;

import com.revature.dao.ArtistDAO;
import com.revature.dao.ArtistDAOImpl;
import com.revature.models.Album;
import com.revature.models.Artist;

public class ChinookDriver {

	public static void main(String[] args) {
		
		System.out.println("Spinning up the connection...");
		
		ArtistDAO artistDao = new ArtistDAOImpl();
		
//		 Get all artists
		ArrayList<Artist> artists = artistDao.getAllArtists();
		
		for(Artist art : artists) {
			System.out.println(art);
		}
//		
//		System.out.println("\n");
//		
//		// Get artist by id
//		System.out.println(artistDao.getArtistById(275));
//		
//		System.out.println("\n");
//		
//		// Get artist by name
//		System.out.println(artistDao.getArtistsByName("Nash Ensemble"));
//		
//		System.out.println("\n");
		
		// Insert new artist
//		artistDao.addArtist(new Artist(300, "Howard Shore"));
//		System.out.println(artistDao.getArtistsByName("Howard Shore"));
		
//		Artist testArtist = new Artist();
////		testArtist.setArtist_name("Jeremy Soule");
////		testArtist = artistDao.addArtist(testArtist);
////		System.out.println(testArtist);
//
//		testArtist.setArtist_id(1);
//		for(Album artistAlbum : artistDao.getArtistAlbums(testArtist)) {
//			System.out.println(artistAlbum);
//		}
	}
}
