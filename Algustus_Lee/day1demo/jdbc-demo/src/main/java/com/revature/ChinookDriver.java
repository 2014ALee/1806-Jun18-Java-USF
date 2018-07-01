package com.revature;

import java.util.ArrayList;

import com.revature.dao.ArtistDAO;
import com.revature.dao.ArtistDAOImpl;
import com.revature.models.Album;
import com.revature.models.Artist;

public class ChinookDriver {
	
	public static void main(String[] args) {
		
		System.out.println("Starting App...");
		
		ArtistDAO artistDao = new ArtistDAOImpl();
		
//		Connection conn = ConnectionFactory.getInstanceMethod().getConnection();
		//Get all Artists
//		ArrayList<Artist> artists = artistDao.getAllArtists();
//		for(Artist art : artists) {
//			System.out.println(art);
//		}
//		
//		//get artist by id
//		Artist art = artistDao.getArtistById(200);
//		System.out.println(art);
//		
//		//add artist
//		Artist myArtist = new Artist();
//		myArtist.setName("A Day to Remember");
//		myArtist = artistDao.addArtist(myArtist);
//		System.out.println(myArtist);
		Artist thisArtist = artistDao.getArtistById(1);
		for(Album artistAlbum : artistDao.getArtistAlbums(thisArtist)){
			System.out.println(artistAlbum);
		}
	}

}
