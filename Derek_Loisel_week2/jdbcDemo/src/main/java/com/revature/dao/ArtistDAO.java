package com.revature.dao;

import java.util.ArrayList;

import com.revature.models.Album;
import com.revature.models.Artist;

public interface ArtistDAO {

	public ArrayList<Artist> getAllArtists();
	public ArrayList<Artist> getArtistByName(String name); //this is an arraylist because there's no unique constraint so if theres 2 with the same name it would be a problem
	public Artist getArtistById(int id);
	
	public Artist addArtist(Artist newArtist);
	public boolean updateArtist(Artist updatedArtist);
	
	public boolean removeArtistById(Artist artistForRemoval);
	public boolean removeArtistByName(String artistName );
	
	public ArrayList<Album> getArtistAlbums(Artist selectedArtist);
	
}
