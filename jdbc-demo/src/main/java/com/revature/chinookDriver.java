package com.revature;

import java.util.ArrayList;

import com.revature.dao.ArtistDAO;
import com.revature.dao.ArtistDAOImpl;
import com.revature.models.Album;
import com.revature.models.Artist;

public class chinookDriver {

	public static void main(String[] args) {
	
		
		System.out.println("Spinning up the application...");
		
		ArtistDAO artistDao = new ArtistDAOImpl();
		
		/*
		//get all artists
		ArrayList<Artist> artists = artistDao.getAllArtists();
		
		for(Artist art : artists) {
			System.out.println(art);
		}
		
		Artist artist = artistDao.getArtistById(5);
		System.out.println(artist);
		
		Artist myArtist = new Artist();
		myArtist.setName("House vs Huriccanes");
		myArtist = artistDao.addArtist(myArtist);
		
		System.out.println(myArtist);
		*/
		
		Artist thisArtist = artistDao.getArtistById(1);
		for(Album artistAlbum : artistDao.getArtistAlbums(thisArtist)) {
			System.out.println(artistAlbum);
			
		}
	}
	
		
}
