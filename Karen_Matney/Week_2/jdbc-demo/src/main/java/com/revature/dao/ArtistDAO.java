package com.revature.dao;

import java.util.ArrayList;

import com.revature.models.Album;
import com.revature.models.Artist;

public interface ArtistDAO {
	public ArrayList<Artist> getAllArtists();
	
	public ArrayList<Artist> getArtistByName(String name);
	
	public ArrayList<Album> getArtistAlbums(Artist selectedArtist);
	
	public Artist getArtistById(int id);
	
	public Artist addArtist(Artist newArtist);
	
	public boolean updateArtist(Artist updateArtist);
	
	public boolean removeArtistById(int artistId);
	
	public boolean removeArtistByName(Artist artistForRemoval);
}
