package com.revature;

import java.util.ArrayList;

import com.revature.dao.ArtistDAO;
import com.revature.dao.ArtistDAOImpl;
import com.revature.models.Album;
import com.revature.models.Artist;

public class ChinookDriver {

	public static void main(String[] args) {
		
		System.out.println("Spinning up the application...");
		
		ArtistDAO artistDao = new ArtistDAOImpl();
		
		//Get all artists
//		ArrayList<Artist> artists = artistDao.getAllArtists();
//	
//		for(Artist art : artists) {
//			System.out.println(art);
//			System.out.println("-------------------------------------------------------------------");
//		}
//		
//		//Get artist by ID
//		Artist art = artistDao.getArtistById(274);
//		System.out.println(art);
//		
//		//Add artist
//		Artist myArtist = new Artist();
//		myArtist.setName("A Day to Remember");
//		myArtist = artistDao.addArtist(myArtist);
//		System.out.println(myArtist);
//		
//		// Get artist albums

		Artist thisArtist = artistDao.getArtistById(1);

		for(Album artistAlbum : artistDao.getArtistAlbums(thisArtist)) {
			System.out.println(artistAlbum);
		}
	}
}
