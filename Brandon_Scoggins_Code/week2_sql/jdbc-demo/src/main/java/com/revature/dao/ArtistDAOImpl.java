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

import oracle.jdbc.internal.OracleTypes;

public class ArtistDAOImpl implements ArtistDAO{

	@Override
	public ArrayList<Artist> getAllArtists() {
		
		ArrayList<Artist> artists = new ArrayList<>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String sql ="SELECT * FROM artist ORDER BY artistid";
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Artist temp = new Artist();
				temp.setArtist_id(rs.getInt(1));
				temp.setArtist_name(rs.getString("name"));
				
				artists.add(temp);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return artists;
	}

	@Override
	public Artist getArtistById(int id) {
		Artist artist = new Artist();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			
			String sql = "SELECT * FROM artist WHERE artistid = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);		// 1 tells us which question mark (variable) to look at
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				artist.setArtist_id(id);
				artist.setArtist_name(rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return artist;
	}

	@Override
	public ArrayList<Artist> getArtistsByName(String name) {
		ArrayList<Artist> artists = new ArrayList<>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String sql = "SELECT * FROM artist WHERE name = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				artists.add(new Artist(rs.getInt(1), name));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return artists;
	}

	@Override
	public Artist addArtist(Artist newArtist) {
		
		Artist artist = new Artist();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			
			conn.setAutoCommit(false);
			
			String sql = "INSERT INTO artist (name) VALUES (?)";
			
			String[] keys = new String[1];
			keys[0] = "artistid";
			
			PreparedStatement pstmt = conn.prepareStatement(sql, keys);
			pstmt.setString(1, newArtist.getArtist_name());
			
			int rowsUpdated = pstmt.executeUpdate();
			
			ResultSet rs = pstmt.getGeneratedKeys();
			
			if (rowsUpdated != 0) {
				while(rs.next()) {
					artist.setArtist_id(rs.getInt(1));
				}
				artist.setArtist_name(newArtist.getArtist_name());
				conn.commit();
			}else {
				conn.rollback();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return artist;
	}

	@Override
	public boolean updateArtist(Artist updatedArtist) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			conn.setAutoCommit(false);
			
			String sql = "UPDATE artist SET name = ? WHERE artistid = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, updatedArtist.getArtist_name());
			pstmt.setInt(2, updatedArtist.getArtist_id());
			
			int rowsUpdated = pstmt.executeUpdate();
			
			if(rowsUpdated != 0) {
				conn.commit();
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
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
	public ArrayList<Album> getArtistAlbums(Artist selectedArtist) {
		
		ArrayList<Album> artistAlbums = new ArrayList<>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			
			String sql = "{CALL get_artist_albums(?, ?)}";
			
			CallableStatement cstmt = conn.prepareCall(sql);
			
			// Setting parameters is the same as we would if we were working with a preparedStatement
			cstmt.setInt(1, selectedArtist.getArtist_id());
			
			// define the index of our second parameter
			cstmt.registerOutParameter(2, OracleTypes.CURSOR);
			
			// execute our callable stmt
			cstmt.execute();
			
			ResultSet rs = (ResultSet) cstmt.getObject(2);
			
			while(rs.next()) {
				artistAlbums.add(new Album(rs.getInt("albumid"), rs.getString("title"), rs.getInt("artistid")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return artistAlbums;
	}

}