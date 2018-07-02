package com.revature;

import java.util.ArrayList;

import com.revature.dao.ArtistDAO;
import com.revature.dao.ArtistDAOImpl;
import com.revature.models.Album;
import com.revature.models.Artist;

public class ChinookDriver {
	
	public static void main(String[] args) {
		
		System.out.println("Spinning up the application...");
		
//		Connection conn = ConnectionFactory.getInstance().getConnection();
		
		ArtistDAO artistDAO = new ArtistDAOImpl();
		
//		ArrayList<Artist> artists = artistDAO.getAllArtists();
//		for(Artist art : artists) {
//			System.out.println(art);
//		}
//		
//		System.out.println("-------------------------------------------");
//		
//		Artist artist = artistDAO.getArtistById(274);
//		System.out.println(artist);
//		System.out.println("-------------------------------------------");
//		
//		artists = artistDAO.getArtistsByName("Santana");
//		for(Artist art : artists) {
//			System.out.println(art);
//		}
//		System.out.println("-------------------------------------------");
//		
//		Artist myArtist = new Artist();
//		myArtist.setName("Cradle of Filth");
//		myArtist = artistDAO.addArtist(myArtist);
//		System.out.println(myArtist);
		
		Artist thisArtist = artistDAO.getArtistById(1);
		for(Album artistAlbum : artistDAO.getArtistAlbums(thisArtist)) {
			System.out.println(artistAlbum);
		}
		
	}

}
