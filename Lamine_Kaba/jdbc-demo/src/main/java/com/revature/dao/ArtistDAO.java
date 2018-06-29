package com.revature.dao;

import java.util.ArrayList;

import com.revature.models.Album;
import com.revature.models.Artist;

public interface ArtistDAO {
	
	public ArrayList<Artist> getAllArtists();
	public Artist getArtistById(int ind);
	public Artist getArtistsByName(String name);
	
	public Artist addArtist(Artist newArtist);
	public boolean updateArtist(Artist updatedArtist);
	public boolean removeArtisById(Artist artistForRemoval);
	public boolean removeArtisByName(String artistName);
	
	
	public ArrayList<Album> getArtistAlbums(Artist selectedArtist);


}


