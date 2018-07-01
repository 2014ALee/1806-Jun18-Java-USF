package com.revature.dao;

import java.util.ArrayList;

import com.revature.models.Album;
import com.revature.models.Artist;

//DAO, Data Access Object. Make a DAO for every Object.
public interface ArtistDAO {
	
	public ArrayList<Artist> getAllArtists();
	public ArrayList<Artist> getArtistByName(String name);
	public Artist getArtistById(int id);
	
	public Artist addArtist(Artist newArtist);
	public boolean updateArtist(Artist updatedArtist);
	public boolean removeArtistById(Artist artistForRemoval);
	public boolean removeArtistByName(String artistName);
	
	public ArrayList<Album> getArtistAlbums(Artist selectedArtist);

}
