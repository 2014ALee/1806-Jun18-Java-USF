package com.revature.dao;

import java.util.ArrayList;

import com.revature.models.Album;
import com.revature.models.Artist;

public interface ArtistDAO {

	public ArrayList<Artist> getAllArtists();
	
	public Artist getArtistById(int id);
	
	public ArrayList<Artist> getArtistsByName(String name);	// Use an array list in case multiple artist with the same name are returned
	
	public Artist addArtist(Artist newArtist);
	
	public boolean updateArtist(Artist updatedArtist);
	
	public boolean removeArtistById(Artist artistForRemoval);
	
	public boolean removeArtistsByName(String artistName);
	
	public ArrayList<Album> getArtistAlbums(Artist selectedArtist);
}
