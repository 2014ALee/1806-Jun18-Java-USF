package com.revature.dao;

import java.sql.Statement;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.models.Album;
import com.revature.models.Artist;
import com.revature.util.ConnectionFactory;

import oracle.jdbc.OracleTypes;

public class ArtistDAOImpl implements ArtistDAO {

	@Override
	public ArrayList<Artist> getAllArtists() {
		
		ArrayList<Artist> artists = new ArrayList<>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String sql = "Select *From artist order by Artistid";
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Artist temp = new Artist();
				temp.setArtistId(rs.getInt(1));
				temp.setName(rs.getString("name"));		
				artists.add(temp);
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return artists;
	}

	@Override
	public Artist getArtistById(int id) {
		
		Artist artist = new Artist();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			
			String sql = "Select *From artist Where artistid = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery()	;
			
			while(rs.next()) {
				artist.setArtistId(id);
				artist.setName(rs.getString(2));
			}	
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return artist;
		
	}

	@Override
	public Artist getArtistsByName(String name) {
		
		Artist artistName = new Artist();
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String sql = "Select *From artist where name = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			
			ResultSet rs = pstmt.executeQuery()	;
			
			while(rs.next()) {
				artistName.setName(name);
				artistName.setArtistId(rs.getInt(1));
			}	
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return artistName;
	}


	@Override
	public Artist addArtist(Artist newArtist) {
		
		Artist artistName = new Artist();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			
			conn.setAutoCommit(false);
			String sql = "INSERT INTO artist (name) values(?)";
			
			String[] keys = new String[1];
			keys[0] = "artistId";
			
			
			
			PreparedStatement pstmt = conn.prepareStatement(sql, keys);
			pstmt.setString(1, newArtist.getName());
			
			int rowUpdated = pstmt.executeUpdate();
			
			ResultSet rs = pstmt.getGeneratedKeys();
			
			if(rowUpdated != 0) {
				 while(rs.next()) {
					 artistName.setArtistId(rs.getInt(1));
				 }
				 artistName.setName(newArtist.getName());
				 conn.commit();
			}
			else {
				conn.rollback();  // rollback is not necessary in inserting. with update yes.
			}
						
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return artistName;

	}

	@Override
	public boolean updateArtist(Artist updatedArtist) {
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			
			conn.setAutoCommit(false);
			
			String sql = "Update artist set name = ? where artist = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, updatedArtist.getName());
			pstmt.setInt(2, updatedArtist.getArtistId());
			
			int rowsUpdated = pstmt.executeUpdate();
			
			if(rowsUpdated != 0) {
				conn.commit();
				return true;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	

	@Override
	public boolean removeArtisById(Artist artistForRemoval) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeArtisByName(String artistName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Album> getArtistAlbums(Artist selectedArtist) {
		
		ArrayList<Album> artistAlbums = new ArrayList<>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			
			conn.setAutoCommit(false);
			
			String sql = "{CALL get_artist_album(?,?)}";
			CallableStatement cstmt = conn.prepareCall(sql);
			
			cstmt.setInt(1, selectedArtist.getArtistId());
			
			cstmt.registerOutParameter(2, OracleTypes.CURSOR);
			
			cstmt.execute();
			
			ResultSet rs = (ResultSet) cstmt.getObject(2);
			
			while(rs.next()) {
				Album temp = new Album();
				temp.setAlbumid(rs.getInt("albumId"));
				temp.setTitle(rs.getString("title"));
				temp.setArtistid(rs.getInt("artistId"));
				artistAlbums.add(temp);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return artistAlbums;
	}

	
}
