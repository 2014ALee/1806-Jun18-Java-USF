package com.revature.models;

public class Album {
 
	private int albumId;
	private String title;
	private int artistID;
	
	public Album(int albumId, String title, int artistID) {
		super();
		this.albumId = albumId;
		this.title = title;
		this.artistID = artistID;
	}
	
	
	
	@Override
	public String toString() {
		return "Album [albumId=" + albumId + ", title=" + title + ", artistID=" + artistID + "]";
	}



	public int getAlbumId() {
		return albumId;
	}
	public void setAlbumId(int albumId) {
		this.albumId = albumId;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + albumId;
		result = prime * result + artistID;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Album other = (Album) obj;
		if (albumId != other.albumId)
			return false;
		if (artistID != other.artistID)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
	
}
