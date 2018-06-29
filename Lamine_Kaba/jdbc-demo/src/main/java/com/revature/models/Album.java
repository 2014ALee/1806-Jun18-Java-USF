package com.revature.models;

public class Album {
	
	private int albumid;
	private String title;
	private int artistid;
	
	public Album() { }
	
	
	public Album(int albumid, String title, int artistid) {
		super();
		this.albumid = albumid;
		this.title = title;
		this.artistid = artistid;
	}
	
	
	public int getAlbumid() {
		return albumid;
	}


	public void setAlbumid(int albumid) {
		this.albumid = albumid;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public int getArtistid() {
		return artistid;
	}


	public void setArtistid(int artistid) {
		this.artistid = artistid;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + albumid;
		result = prime * result + artistid;
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
		if (albumid != other.albumid)
			return false;
		if (artistid != other.artistid)
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
		return "Album [albumid=" + albumid + ", title=" + title + ", artistid=" + artistid + "]";
	}
	
	

}
