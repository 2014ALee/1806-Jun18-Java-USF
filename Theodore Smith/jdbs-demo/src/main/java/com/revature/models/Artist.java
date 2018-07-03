package com.revature.models;

public class Artist {
	
	private int artistid;
	private String name;
	
	public Artist() {
		
	}

	public Artist(int artistid, String name) {
		super();
		this.artistid = artistid;
		this.name = name;
	}

	public int getArtistid() {
		return artistid;
	}

	public void setArtistid(int artistid) {
		this.artistid = artistid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	@Override
	public String toString() {
		return "Artist [artistid=" + artistid + ", name=" + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + artistid;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		if (artistid != other.artistid)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	

}
