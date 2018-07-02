package com.revature.dao;

import java.util.ArrayList;

import com.revature.models.Album;
import com.revature.models.Artist;

public interface ArtistDAO {
	
	public ArrayList<Artist> getAllArtists();
	
	public Artist getArtistById(int id);
	
	public ArrayList<Artist> getArtistsByName(String name);
	
	public Artist createArtist(Artist newArtist);
	
	public boolean removeArtistsById(Artist artistForRemoval);
	
	public boolean removeArtistsByName(String artistName);
	
	public boolean updateArtist(Artist updatedArtist);
	
	public ArrayList<Album> getArtistAlbums(Artist artist);

}
