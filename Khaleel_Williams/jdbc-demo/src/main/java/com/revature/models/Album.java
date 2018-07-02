package com.revature.models;

public class Album {
	
	private int albumid;
	private String title;
	private int artistId;
	
	public Album() {}

	public Album(int albumid, String title, int artistId) {
		super();
		this.albumid = albumid;
		this.title = title;
		this.artistId = artistId;
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
		result = prime * result + albumid;
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
		if (albumid != other.albumid)
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
		return "Album [albumid=" + albumid + ", title=" + title + ", artistId=" + artistId + "]";
	}
	

}
