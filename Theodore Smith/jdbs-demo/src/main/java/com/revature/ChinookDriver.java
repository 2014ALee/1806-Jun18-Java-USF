package com.revature;

import java.util.ArrayList;

import com.revature.dao.ArtistDAO;
import com.revature.dao.ArtistDAOImpl;
import com.revature.models.Artist;

public class ChinookDriver {

	public static void main(String[] args) {

		System.out.println("Spinning up the application");
		
		ArtistDAO artistDao = new ArtistDAOImpl();
		
		ArrayList<Artist> artists = artistDao.getAllArtists();
		
		for (Artist art : artists) {
			System.out.println(art);
		}
		
		Artist art = artistDao.getArtistById(274);
		System.out.println(art);
		
		Artist myArtist = new Artist();
		myArtist.setName("A Day to Remeber");
		System.out.println("1");
		myArtist = artistDao.addArtist(myArtist);
		System.out.println("2");
		System.out.println(myArtist);
		
		Artist thisArtist = artistDao.getArtistById(1);
		
		for (Album artistAlbum : artistDao.getArtistsAlbums(thisArtist)) {
			System.out.println(artistAlbum);
		}

	}

}
