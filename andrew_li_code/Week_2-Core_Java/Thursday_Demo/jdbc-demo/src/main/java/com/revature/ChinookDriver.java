package com.revature;
import java.util.ArrayList;

import com.revature.dao.ArtistDAO;
import com.revature.dao.ArtistDAOImpl;
import com.revature.models.Album;
import com.revature.models.Artist;

public class ChinookDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(System.getProperty("user.dir"));
		ArtistDAO artistDAO = new ArtistDAOImpl();
		/*
		ArrayList<Artist> artists = artistDAO.getAllArtists();
		for (Artist artist : artists) {
			System.out.println(artist);
		}
		System.out.println(artistDAO.getArtistById(200));
		*/
		Artist myArtist = artistDAO.getArtistById(1);
		System.out.println(myArtist);
		for (Album album : artistDAO.getAlbums(myArtist)) {
			System.out.println(album);
		}
	}

}
