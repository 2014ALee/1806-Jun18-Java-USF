package com.revature.models;

public class Album {
	
	private int albumID;
	private String title;
	private int artistId;
	
	public Album() {}

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

	public int getArtistId() {
		return artistId;
	}

	public void setArtistId(int artistId) {
		this.artistId = artistId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + albumID;
		result = prime * result + artistId;
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
		if (albumID != other.albumID)
			return false;
		if (artistId != other.artistId)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Album [albumID=" + albumID + ", title=" + title + ", artistId=" + artistId + "]";
	}

	public Album(int albumID, String title, int artistId) {
		super();
		this.albumID = albumID;
		this.title = title;
		this.artistId = artistId;
	}
	
	

}
