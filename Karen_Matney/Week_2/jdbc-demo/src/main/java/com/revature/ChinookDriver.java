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
		System.out.println("Spinning up application...");

		// Connection conn = ConnectionFactory.getInstance().getConnection();
		
		ArtistDAO artistDao = new ArtistDAOImpl();
		
//		// Get all artists
//		ArrayList<Artist> artists = artistDao.getAllArtists();
//		
//		// Get artist by id
//		Artist a = artistDao.getArtistById(274);
//		System.out.println(a);
//		
//		// Get artist by name
//		ArrayList<Artist> b = artistDao.getArtistByName("Metallica");
		
		// Add artist
//		Artist myArtist = new Artist();
//		myArtist.setName("A Day to Remember");
//		myArtist = artistDao.addArtist(myArtist);
//		myArtist = new Artist();
//		myArtist.setName("Go Betty Go");
//		myArtist = artistDao.addArtist(myArtist);
//		System.out.println(myArtist);
		
//		for(Artist band : b) {
//			System.out.println(band);
//		}
//		
//		for(Artist art : artists)
//			System.out.println(art);
		
		// Get artist albums
		Artist thisArtist = artistDao.getArtistById(1);
		
		for(Album artistAlbum : artistDao.getArtistAlbums(thisArtist)) {
			System.out.println(artistAlbum);
		}
		
	}
}
