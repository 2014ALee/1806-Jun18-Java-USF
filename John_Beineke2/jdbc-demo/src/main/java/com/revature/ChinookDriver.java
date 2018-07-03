package com.revature;

import java.util.ArrayList;

import com.revature.dao.ArtistDao;
import com.revature.dao.ArtistDaoImpl;
import com.revature.models.Album;
import com.revature.models.Artist;

public class ChinookDriver {

	public static void main(String[] args) {

		System.out.println("Spinning up the application...");


		ArtistDao artistDao = new ArtistDaoImpl();

		// get all artists
		ArrayList<Artist> artists = artistDao.getAllArtists();

		for(Artist art : artists) {
			System.out.println(art);		
		}

		System.out.println(" ");

		// get artist by id
		Artist art = artistDao.getArtistById(297);
		System.out.println(art);

		System.out.println(" ");

		// get artist by name
		ArrayList<Artist> artists1 = artistDao.getArtistsByName("CCR");
		for(Artist art1 : artists1) {
			System.out.println(art1);		
		}

//		// add artist
//		Artist myArtist = new Artist();
//		myArtist.setName("A Day to Remember");
//		myArtist = artistDao.addArtist(myArtist);
//		System.out.println(myArtist);

		
		// get artist albums
		
		Artist thisArtist = artistDao.getArtistById(1);
		for(Album artistAlbum : artistDao.getArtistAlbums(thisArtist)) {
			System.out.println(artistAlbum);
		}
		
	}

}
