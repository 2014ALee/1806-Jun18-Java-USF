package com.revature;

import java.util.ArrayList;

import com.revature.dao.ArtistDAO;
import com.revature.dao.ArtistDAOImpl;
import com.revature.models.Album;
import com.revature.models.Artist;


public class ChinookDriver {
	
	public static void main(String[] args) {
		
		System.out.println("Spining out the application");
		
		System.out.println("========================================== Get Artist by id =============================================");
		
		ArtistDAO artistDAO = new ArtistDAOImpl();
		
		ArrayList<Artist> artists = artistDAO.getAllArtists();
		
		for(Artist art : artists) {
			System.out.println(art);
		}
		
		System.out.println("==========================================Get =============================================");
		
		Artist artId = artistDAO.getArtistById(274); 
		System.out.println(artId);
		
		System.out.println("========================================== Get Artist by Name ==================================================");
		
		Artist artName = artistDAO.getArtistsByName("megadeh"); 
		System.out.println(artName);
		
		System.out.println("========================================== Add Artist =================================================");
		
		Artist newArtist = new Artist(); 
		newArtist.setName("A Day to Remember");
		newArtist = artistDAO.addArtist(newArtist);
		System.out.println(newArtist);
		
		System.out.println("========================================== Get artist album =================================================");
		
		Artist thisArtist = artistDAO.getArtistById(1);
		
		for(Album artistAlbum: artistDAO.getArtistAlbums(thisArtist)) {
			System.out.println(artistAlbum);
		}
		
	}

}
