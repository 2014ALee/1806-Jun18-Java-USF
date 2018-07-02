package com.revature.models;

public class Artist {

	private int artist_id;
	private String artist_name;
	
	public Artist() {
		
	}

	public Artist(int artist_id, String artist_name) {
		super();
		this.artist_id = artist_id;
		this.artist_name = artist_name;
	}

	public int getArtist_id() {
		return artist_id;
	}

	public void setArtist_id(int artist_id) {
		this.artist_id = artist_id;
	}

	public String getArtist_name() {
		return artist_name;
	}

	public void setArtist_name(String artist_name) {
		this.artist_name = artist_name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + artist_id;
		result = prime * result + ((artist_name == null) ? 0 : artist_name.hashCode());
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
		Artist other = (Artist) obj;
		if (artist_id != other.artist_id)
			return false;
		if (artist_name == null) {
			if (other.artist_name != null)
				return false;
		} else if (!artist_name.equals(other.artist_name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Artist [artist_id=" + artist_id + ", artist_name=" + artist_name + "]";
	}
	
}
