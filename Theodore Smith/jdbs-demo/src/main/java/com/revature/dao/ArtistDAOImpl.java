package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.models.Artist;
import com.revature.util.ConnectionFactory;

public class ArtistDAOImpl implements ArtistDAO{

	@Override
	public ArrayList<Artist> getAllArtists() {

			ArrayList<Artist> artists = new ArrayList<>();
			
			try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
				
				String sql = "SELECT * FROM artist";
				
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				
				while (rs.next()) {
					Artist temp = new Artist();
					temp.setArtistid(rs.getInt(1));
					temp.setName(rs.getString("name"));
					
					artists.add(temp);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return artists;
	}

	@Override
	public ArrayList<Artist> getArtistsByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Artist getArtistById(int id) {
		// addd get artist by ID here once on github
		return ;
	}

	@Override
	public Artist addArtist(Artist newArtist) {

		Artist artist = new Artist();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();)
		{
			
			conn.setAutoCommit(false);
			
			String sql = "INSERT INTO artist (name) VALUES (?)";
			
			String[] keys = new String[1];
			keys[0] ="artistId";
			
			PreparedStatement pstmt = conn.prepareStatement(sql, keys);
			pstmt.setString(1, newArtist.getName());
			
			int rowsUpdated =  pstmt.executeUpdate();
			
			ResultSet rs = pstmt.getGeneratedKeys();
			
			if(rowsUpdated != 0) {
				
				while(rs.next()) {
					artist.setArtistid(rs.getInt(1));
				}
				
				artist.setName(newArtist.getName());
				conn.commit();
			} else {
				conn.rollback();}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return artist;
	}

	@Override
	public boolean updateArtist(String updatedArtist) {

		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			conn.setAutoCommit(false);
			
			String sql = "UPDATE artist SET name = ? WHERE artistid = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, updatedArtist.getName());
			pstmt.setInt(2, updatedArtist.getArtistId());
			
			int rowsUpdated = pstmt.executeUpdate();
			
			if (rowsUpdated !=0) {
				conn.commit
			}
			
		}
		
		return ;
	}

	@Override
	public boolean removeArtistById(Artist artistForRemoval) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeArtistsByName(String artistName) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public ArrayList<Album> getAristAlbums(Artist selectedArtist){
		// TODO Auto-generated method stub
		return false;
	}

}
