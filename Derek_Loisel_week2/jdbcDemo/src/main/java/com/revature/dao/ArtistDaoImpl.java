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

public class ArtistDaoImpl implements ArtistDAO{

	@Override
	public ArrayList<Artist> getAllArtists() {

		//create an array list to hold our results
		ArrayList<Artist> artists = new ArrayList<>();

		//create a connection
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){

			//create an object for the type of statement you want to make
			Statement stmt = conn.createStatement();

			//create a string that holds the query you want to run
			String sql = "SELECT * FROM artist ORDER BY artistid";

			//execute the query into a result set object
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()) { //while the results has a next value, we want to loop

				//create an artist object to represent each row
				Artist temp = new Artist();
				//add the row contents to the artist object
				temp.setArtistid(rs.getInt(1));
				temp.setName(rs.getString("name")); //can identify the column by int or do it by string 
				//add the artist object (row) to your array
				artists.add(temp);			
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		//now you return an array of artist objects that represent each row from the table
		return artists;
	}

	@Override
	public Artist getArtistById(int id) {

		Artist artist = new Artist();

		try(Connection conn = ConnectionFactory.getInstance().getConnection();){

			String sql = "SELECT * FROM artist WHERE artistid = ?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,  id);

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

	@Override
	public ArrayList<Artist> getArtistByName(String name) {
		
		//add them to array list in case there was multiples of same name
		ArrayList<Artist> artistList = new ArrayList<>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			
			String sql = "SELECT * FROM artist WHERE name = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name); //1 referes to which question mark we're replacing
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				Artist artist = new Artist();
				artist.setArtistid(rs.getInt(1));
				artist.setName(name);
				artistList.add(artist);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return artistList;
	}

	@Override
	public Artist addArtist(Artist newArtist) {

		//could just use the artist passed in dont need to create new one
		Artist artist = new Artist();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			
			conn.setAutoCommit(false);
			
			String sql = "INSERT INTO artist (name) VALUES (?)";
					
			//an array of string objects that will take IN the primary keys that's generated WHEN you put the artist in
			String[] keys = new String[1];// the 1 IS how many columns we're keeping track of keys for, here its only 1 for the name
			keys[0] = "artistid";  //you could then set keys[1] = "column" if there was another column you were keeping track of
			
			PreparedStatement pstmt = conn.prepareStatement(sql, keys); //pass in the sql statement as well as the keys you want to get back because you want to keep track of the key for the artist
			pstmt.setString(1, newArtist.getName());
			
			int rowsUpdated = pstmt.executeUpdate(); //this isnt a query, its an update.  it also returns a value that tells you how many rows were updated
			
			ResultSet rs = pstmt.getGeneratedKeys(); //this is only going to have the keys in the result set
			
			if(rowsUpdated != 0) {
				// if any rows were updated, you get the key for it in the result set
				while(rs.next()) {
					artist.setArtistid(rs.getInt(1));
				}
				
				//just set the name 
				artist.setName(newArtist.getName());
				
				//commit
				conn.commit();
				
			}//else {
//				//if it didnt update anything then roll it back
//				conn.rollback();
//			}
			
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
			pstmt.setString(1,  updatedArtist.getName());
			pstmt.setInt(2,  updatedArtist.getArtistid());
			
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
	public boolean removeArtistByName(String artistName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Album> getArtistAlbums(Artist selectedArtist) {
		
		ArrayList<Album> artistAlbums = new ArrayList<>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			
			String sql = "{CALL get_artist_albums(?,?)}";
			CallableStatement cstmt = conn.prepareCall(sql);
			
			//setting params is same as prepared statement
			cstmt.setInt(1, selectedArtist.getArtistid());
			
			//define the index of our second param and its type which is curosr
			cstmt.registerOutParameter(2, OracleTypes.CURSOR);
			
			cstmt.execute()	; //returns boolean could catch this boolean if we wanted to 
			
			ResultSet rs = (ResultSet) cstmt.getObject(2); //which one are we expecting to get back? the cursor which is 2 the second param we passed
		
			while(rs.next()) {
				Album temp = new Album();
				temp.setAlbumId(rs.getInt("albumId")); //doing it diff ways for exxample but wanna stay consistent with these in reality either get int or get string
				temp.setTitle(rs.getString("title"));
				temp.setArtistId(rs.getInt("artistId"));
				artistAlbums.add(temp);
				
			}
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return artistAlbums;
	}


}
