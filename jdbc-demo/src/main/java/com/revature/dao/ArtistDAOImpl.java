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

import come.revature.util.connectionFactory;
import oracle.jdbc.internal.OracleTypes;

public class ArtistDAOImpl implements ArtistDAO {

	@Override
	public ArrayList<Artist> getAllArtists() {

		ArrayList<Artist> artists = new ArrayList<>();	

		try(Connection con = connectionFactory.getInstance().getConnection();){

			String sql = "SELECT * FROM ARTIST";

			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Artist getArtistById(int id) {

		Artist artist = new Artist();

		try(Connection con = connectionFactory.getInstance().getConnection()){
			String sql = "SELECT * FROM artist WHERE ARTISTID = ?";

			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setInt(1, id);

			ResultSet rs = psmt.executeQuery();

			while(rs.next()) {
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
	public Artist addArtist(Artist newArtist) {

		Artist artist = new Artist();
		try(Connection con = connectionFactory.getInstance().getConnection();){

			con.setAutoCommit(false);

			String sql = "INSERT INTO ARTIST(NAME) VALUES (?)";

			String[] keys = new String[1];
			keys[0] = "artistId";

			PreparedStatement ps = con.prepareStatement(sql, keys);
			ps.setString(1, newArtist.getName());
			int rowsUpdated  = ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();

			if(rowsUpdated != 0) {

				while(rs.next()) {
					artist.setArtistId(rs.getInt(1));	
				}

				artist.setName(newArtist.getName());
				con.commit();
			} else {

				con.rollback();
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return artist;
	}

	@Override
	public boolean updateArtist(Artist updatedArtist) {

		try(Connection con = connectionFactory.getInstance().getConnection()){

			con.setAutoCommit(false);
			String sql = "UPDATE artist SET name = ? WHERE artistid = ?";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, updatedArtist.getName());
			ps.setInt(2, updatedArtist.getArtistId());

			int rowsUpdated = ps.executeUpdate();

			if(rowsUpdated!=0) {
				con.commit();
				return true;
			} else {
				return false;
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



	//this is a callable statement!
	@Override
	public ArrayList<Album> getArtistAlbums(Artist artist) {

		ArrayList<Album> artistAlbums = new ArrayList<>();

		try(Connection con = connectionFactory.getInstance().getConnection()){

			String sql = "{CALL get_artist_albums(?,?)}";
			CallableStatement cs = con.prepareCall(sql);

			cs.setInt(1, artist.getArtistId());

			cs.registerOutParameter(2, OracleTypes.CURSOR);

			//execute out callable statement
			cs.execute();

			ResultSet rs = (ResultSet) cs.getObject(2);

			while(rs.next()) {
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
