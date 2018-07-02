package com.revature.dao;

import java.util.ArrayList;

import com.revature.models.Album;
import com.revature.models.Artist;

public interface ArtistDAO {

	public abstract ArrayList<Artist> getAllArtists();
	public abstract Artist getArtistById(int id);
	public abstract Artist getArtistByName(String name);
	
	public abstract Artist addArtist(Artist newArtist);
	
	public boolean updateArtist(Artist updatedArtist);
	
	public abstract boolean removeArtistById(Artist artistForRemoval);
	public abstract boolean removeArtistById(int id);
	public abstract int removeArtistsByName(String artistName);
	
	public abstract ArrayList<Album> getAlbums(Artist selectedArtist);
}
