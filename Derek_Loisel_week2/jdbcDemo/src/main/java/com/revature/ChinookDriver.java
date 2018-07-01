package com.revature;

import java.util.ArrayList;

import com.revature.dao.ArtistDAO;
import com.revature.dao.ArtistDaoImpl;
import com.revature.models.Album;
import com.revature.models.Artist;

public class ChinookDriver {

	public static void main(String[] args) {
		
		System.out.println("Spinning up the application....");
		
		ArtistDAO artistDao = new ArtistDaoImpl();
		
//		//get all artists
//		ArrayList<Artist> artists = artistDao.getAllArtists();
//		
//		for (Artist art : artists) {
//			System.out.println(art);
//		}
//		
//		System.out.println("--------------------");
//		
//		//get artist by id
//		Artist art = artistDao.getArtistById(274);
//		System.out.println(art);
//		
//		System.out.println("--------------------");
//		
//		//get artist by name
//		ArrayList<Artist> artistList = artistDao.getArtistByName("Black Sabbath");
//		System.out.println(artistList);
		
		System.out.println("--------------------");
		//add artist 
		Artist myArtist = new Artist();
		myArtist.setName("A Day to Remember");
		myArtist = artistDao.addArtist(myArtist);
		System.out.println(myArtist);
		
		System.out.println("--------------------");
		
//		Artist thisArtist = artistDao.getArtistById(1);
//		
//		for(Album artistAlbum : artistDao.getArtistAlbums(thisArtist)) {
//			System.out.println(artistAlbum);
		}
	}
}
