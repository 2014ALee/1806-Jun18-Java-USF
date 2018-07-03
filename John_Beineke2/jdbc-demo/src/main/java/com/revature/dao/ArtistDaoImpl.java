package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.models.Album;
import com.revature.models.Artist;
import com.revature.util.ConnectionFactory;

import oracle.jdbc.OracleTypes;

public class ArtistDaoImpl implements ArtistDao {

	public ArrayList<Artist> getAllArtists() {
		
		ArrayList<Artist> artists = new ArrayList<>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "SELECT * FROM artist ORDER BY artistid";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Artist temp = new Artist();
				temp.setArtistid(rs.getInt(1));
				temp.setName(rs.getString("name"));
				artists.add(temp);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return artists;
	}

	public ArrayList<Artist> getArtistsByName(String name) {

		Artist artist = new Artist();
		ArrayList<Artist> artists = new ArrayList();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "SELECT * FROM artist WHERE name = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {
				artist.setArtistid(rs.getInt(1));
				artist.setName(name);
				artists.add(artist);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return artists;
	}

	public Artist getArtistById(int id) {
		
		Artist artist = new Artist();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "SELECT * FROM artist WHERE artistid = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				artist.setArtistid(id);
				artist.setName(rs.getString(2));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return artist;
	}

	public Artist addArtist(Artist newArtist) {

		Artist artist = new Artist();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			// set false so we can make sure it was successful before we commit
			conn.setAutoCommit(false);
			String sql = "INSERT INTO artist (name) VALUES(?)";
			// make a string array of keys 
			String[] keys = new String[1];
			// which column i want to get back
			keys[0] = "artistid";
			PreparedStatement pstmt = conn.prepareStatement(sql, keys);
			pstmt.setString(1, newArtist.getName());
			// use execute update because insert is not a query
			// returns  an int value of updated rows
			int rowsUpdated = pstmt.executeUpdate();
			// once executed we get back a list of generated keys from db (artistid)
			ResultSet rs = pstmt.getGeneratedKeys();
			if(rowsUpdated != 0) {
				while (rs.next()) {
					// get the artistid from the result set
					artist.setArtistid(rs.getInt(1));
				}
				
				artist.setName(newArtist.getName());
				conn.commit();	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return artist;
	}

	public boolean removeArtistById(Artist artistForRemoval) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean removeArtistsByName(String artistName) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateArtist(Artist updatedArtist) {

		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String sql = "UPDATE artist SET name = ? WHERE artistid = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  updatedArtist.getName());
			pstmt.setInt(1, updatedArtist.getArtistid());
			
			int rowsUpdated = pstmt.executeUpdate();
			
			if (rowsUpdated != 0) {
				conn.commit();
				return true;
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public ArrayList<Album> getArtistAlbums(Artist selectedArtist) {

		ArrayList<Album> artistAlbums = new ArrayList<>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			
			String sql = "{CALL get_artist_albums(?, ?)}";
			CallableStatement cstmt = conn.prepareCall(sql);
			
			// same as prepared statement
			cstmt.setInt(1, selectedArtist.getArtistid());
			
			// define the index of our second parameter, and its type
			cstmt.registerOutParameter(2, OracleTypes.CURSOR);
			
			// execute callable statement
			cstmt.execute();
			
			ResultSet rs = (ResultSet) cstmt.getObject(2);
			while(rs.next()) {
				
				// Use a temp album so we can do a different album each time through the loop
				Album temp = new Album();
				temp.setAlbumId(rs.getInt("albumId"));
				temp.setTitle(rs.getString("title"));
				temp.setArtistId(rs.getInt("artistId"));
				artistAlbums.add(temp);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return artistAlbums;
	}

	
	
}
