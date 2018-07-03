package com.revature.dao;

import java.util.ArrayList;

import com.revature.models.Album;
import com.revature.models.Artist;

public interface ArtistDAO {

	public ArrayList<Artist> getAllArtists();
	public ArrayList<Artist> getArtistsByName(String name);
	public Artist getArtistById(int id);

	public Artist addArtist(Artist newArtist);

	public boolean updateArtist(String updatedArtist);

	public boolean removeArtistById(Artist artistForRemoval);
	public boolean removeArtistsByName(String artistName);
	
	public ArrayList<Album> getArtistsAlbums(Artist thisArtist);
	ArrayList<com.revature.dao.Album> getAristAlbums(Artist selectedArtist);
	
	


}
