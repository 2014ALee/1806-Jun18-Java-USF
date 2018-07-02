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

public class ArtistDAOImpl implements ArtistDAO {

	@Override
	public ArrayList<Artist> getAllArtists() {
		ArrayList<Artist> artists = new ArrayList<>();
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			String sql = "SELECT * FROM artist ORDER BY artistid";
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Artist temp = new Artist();
				temp.setArtistId(rs.getInt(1));
				temp.setName(rs.getString("name"));
				artists.add(temp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return artists;
	}

	@Override
	public ArrayList<Artist> getArtistsByName(String name) {
		ArrayList<Artist> artists = new ArrayList<>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "SELECT * FROM artist WHERE name like ?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);

			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {
				Artist artist = new Artist();
				artist.setArtistId(rs.getInt(1));
				artist.setName(name);
				artists.add(artist);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return artists;
	}

	@Override
	public Artist getArtistById(int id) {
		Artist artist = new Artist();
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			String sql = "SELECT * FROM artist WHERE artistid = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				artist.setArtistId(id);
				artist.setName(rs.getString(2));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return artist;
	}

	@Override
	public Artist addArtist(Artist newArtist) {
		Artist artist= new Artist();
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			conn.setAutoCommit(false);
			
			String sql = "INSERT INTO artist (name) VALUES (?)";
			
			String[] keys = new String[1];
			keys[0] = "artistId";
			
			PreparedStatement pstmt = conn.prepareStatement(sql, keys);
			pstmt.setString(1, newArtist.getName());
			
			int rowsUpdated = pstmt.executeUpdate();
			
			ResultSet rs = pstmt.getGeneratedKeys();
			
			if(rowsUpdated != 0) {
				while(rs.next()) {
					artist.setArtistId(rs.getInt(1));
				}
				
				artist.setName(newArtist.getName());
				conn.commit();
			} else {
				conn.rollback();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return artist;
	}

	@Override
	public boolean updateArtist(Artist updatedArtist) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			conn.setAutoCommit(false);
			
			String sql = "UPDATE artist SET name = ? WHERE artistid = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, updatedArtist.getName());
			pstmt.setInt(2, updatedArtist.getArtistId());
			
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
		
		return false;
	}

	@Override
	public boolean removeArtistsByName(String artistName) {
		
		return false;
	}

	@Override
	public ArrayList<Album> getArtistAlbums(Artist selectedArtist) {
		ArrayList<Album> artistAlbums = new ArrayList<>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			String sql = "{CALL get_artist_albums(?,?)}";
			
			CallableStatement cstmt = conn.prepareCall(sql);
			cstmt.setInt(1, selectedArtist.getArtistId());
			
			cstmt.registerOutParameter(2, OracleTypes.CURSOR);
			
			cstmt.execute();
			
			ResultSet rs = (ResultSet) cstmt.getObject(2);
			
			while(rs.next()) {
				Album temp = new Album();
				temp.setAlbumId(rs.getInt("albumid"));
				temp.setTitle(rs.getString("title"));
				temp.setArtistId(rs.getInt("artistid"));
				artistAlbums.add(temp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return artistAlbums;
	}

}
