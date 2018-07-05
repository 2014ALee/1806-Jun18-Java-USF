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
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			String sql = "SELECT * FROM artist ORDER BY artistId";
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			
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
	public Artist getArtistById(int id) {
		Artist artist = new Artist();
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			String sql = "SELECT * FROM artist WHERE artistid = ?";
			//Prepared statement
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setInt(1, id);
			
			ResultSet rs = pstat.executeQuery();
			
			while(rs.next()) {
				artist.setArtistId(id);
				artist.setName(rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return artist;
	}

	@Override
	public ArrayList<Artist> getArtistsByName(String name) {
		ArrayList<Artist> artists = new ArrayList<>();
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			String sql = "SELECT * FROM artist WHERE name = ?";
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setString(1, name);
			
			ResultSet rs = pstat.executeQuery();
			
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
	public Artist createArtist(Artist newArtist) {
		Artist artist = new Artist();
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			conn.setAutoCommit(false);
			
			String sql = "INSERT INTO artist (name) VALUES (?)";
			
			PreparedStatement pstat = conn.prepareStatement(sql);

			pstat.setString(1, newArtist.getName());
			
			int success = pstat.executeUpdate();
			
			ResultSet rs = pstat.getGeneratedKeys();
			if (success != 0) {
				while(rs.next()) {
					artist.setArtistId(rs.getInt(1));
				}
				artist.setName(newArtist.getName());
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return artist;
	}

	@Override
	public boolean removeArtistsById(Artist artistForRemoval) {
		return false;
//		boolean removed = false;
//		
//		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
//			
//			String sqlplaylisttrack = "DELETE FROM playlisttrack WHERE trackid = ?";
//			PreparedStatement pstatplaylisttrack = conn.prepareStatement(sqlplaylisttrack);
//			pstatplaylisttrack.setInt(1, x);
//		}
	}

	@Override
	public boolean removeArtistsByName(String artistName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateArtist(Artist updatedArtist) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			conn.setAutoCommit(false);
			
			String sql = "UPDATE artist SET name = ? WHERE artistid = ?";
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setString(1, updatedArtist.getName());
			pstat.setInt(2, updatedArtist.getArtistId());
			
			int updated = pstat.executeUpdate();
			
			if (updated != 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ArrayList<Album> getArtistAlbums(Artist artist) {
		ArrayList<Album> albums = new ArrayList<>();
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			String sql = "{CALL get_artist_albums(?,?)}";
			CallableStatement cstat = conn.prepareCall(sql);
			
			cstat.setInt(1, artist.getArtistId());
			cstat.registerOutParameter(2, OracleTypes.CURSOR);
			
			cstat.execute();
			
			ResultSet rs = (ResultSet) cstat.getObject(2);
			
			while(rs.next()) {
				Album temp = new Album();
				temp.setAlbumId(rs.getInt(1));
				temp.setTitle(rs.getString("title"));
				temp.setArtistId(rs.getInt("artistId"));
				albums.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return albums;
	}

}
