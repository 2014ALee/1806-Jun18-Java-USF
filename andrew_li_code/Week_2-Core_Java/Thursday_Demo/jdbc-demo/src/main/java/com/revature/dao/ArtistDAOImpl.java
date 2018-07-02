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

public class ArtistDAOImpl implements ArtistDAO {

	@Override
	public ArrayList<Artist> getAllArtists() {
		ArrayList<Artist> artists = new ArrayList<Artist>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			String sql = "SELECT * FROM ARTIST";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
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
	public Artist getArtistById(int id) {
		// TODO Auto-generated method stub
		Artist artist = new Artist();
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String sql = "SELECT * FROM artist WHERE artistid = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				artist.setArtistId(id);
				artist.setName(rs.getString(2));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return artist;
	}

	@Override
	public Artist getArtistByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Artist addArtist(Artist newArtist) {
		Artist artist = new Artist();
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			conn.setAutoCommit(false);
			String sql = "INSERT INTO ARTIST (NAME) VALUES (?)";
			String[] keys = new String[1];
			keys[0] = "artistId";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newArtist.getName());
			int rowsUpdated = pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rowsUpdated != 0) {
				while (rs.next()) {
					artist.setArtistId(rs.getInt(1));
				}
				artist.setName(newArtist.getName());
				conn.commit();
			} else {
				conn.rollback();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return artist;
	}

	@Override
	public boolean updateArtist(Artist updatedArtist) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			conn.setAutoCommit(false);
			String sql = "UPDATE artist SET NAME = ? WHERE artistid = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, updatedArtist.getName());
			pstmt.setInt(2, updatedArtist.getArtistId());
			int rowsUpdated = pstmt.executeUpdate();
			
			if (rowsUpdated != 0) {
				conn.commit();
				return true;	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeArtistById(Artist artistForRemoval) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeArtistById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int removeArtistsByName(String artistName) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Album> getAlbums(Artist selectedArtist) {
		ArrayList<Album> albums = new ArrayList<Album>();
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "{CALL get_artist_albums(?,?)}";
			CallableStatement cstmt = conn.prepareCall(sql);
			
			cstmt.setInt(1,  selectedArtist.getArtistId());
			
			cstmt.registerOutParameter(2,  OracleTypes.CURSOR);
			
			cstmt.execute();
			
			ResultSet rs = (ResultSet) cstmt.getObject(2);
			
			while (rs.next()) {
				Album temp = new Album();
				temp.setAlbumID(rs.getInt("albumId"));
				temp.setTitle(rs.getString("title"));
				temp.setArtistID(rs.getInt("artistId"));
				albums.add(temp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return albums;
	}

}
