package com.revature.dao;

import java.util.ArrayList;

import com.revature.models.Album;
import com.revature.models.Artist;

public interface ArtistDao {
	
	public ArrayList<Artist> getAllArtists();
	public ArrayList<Artist> getArtistsByName(String name);
	public Artist getArtistById(int id);
	
	public Artist addArtist(Artist newArtist);
	public boolean removeArtistById(Artist artistForRemoval);
	
	public boolean removeArtistsByName(String artistName);
	public boolean updateArtist(Artist updatedArtist);
	
	public ArrayList<Album> getArtistAlbums(Artist selectedArtist );
}
