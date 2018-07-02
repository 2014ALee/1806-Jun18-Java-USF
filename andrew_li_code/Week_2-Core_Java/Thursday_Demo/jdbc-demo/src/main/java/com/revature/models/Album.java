package com.revature.models;

public class Album {
	private int albumID;
	private String title;
	private int artistID;
	
	public Album() {}

	public Album(int albumID, String title, int artistID) {
		super();
		this.albumID = albumID;
		this.title = title;
		this.artistID = artistID;
	}

	public int getAlbumID() {
		return albumID;
	}

	public void setAlbumID(int albumID) {
		this.albumID = albumID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getArtistID() {
		return artistID;
	}

	public void setArtistID(int artistID) {
		this.artistID = artistID;
	}

	@Override
	public String toString() {
		return "Album [albumID=" + albumID + ", title=" + title + ", artistID=" + artistID + "]";
	}
	
	
}
