package com.revature.dao;

import java.util.ArrayList;

import com.revature.models.Album;
import com.revature.models.Artist;

public interface ArtistDAO {
	
	public ArrayList<Artist> getAllArtists();
	public Artist getArtistsById(int id);
	public ArrayList<Artist> getArtistByName(String name);
	
	public Artist addArtist(Artist newArtist);
	public boolean updateArtist(Artist updatedArtist);
	public boolean removeArtistById(Artist artistForRemoval);
	public boolean removeArtistsByName(String artistName);
	
	public ArrayList<Album> getArtistAlbum(Artist selectedArtist);
}
