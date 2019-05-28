package com.stackroute.crudRepositoryService;

/*
 * This class contains the code for data storage interactions and methods 
 * of this class will be used by other parts of the applications such
 * as Controllers and Test Cases
 * */
import com.stackroute.domain.Track;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CrudRepository {
	private Connection con;
	public List<Track> displayData() {
		List<Track> trackList = new ArrayList<>();
		try {
			//Resister Driver with driver manager service
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded");//create connection
			//here db1 is database name, root is username and root123 is password
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/moviedb", "root", "Root@123");
			//create statement object
			System.out.println("got connected");

			Statement stmt = con.createStatement();


			//execute query
			ResultSet rs = stmt.executeQuery("select * from track");
			//process result
			while (rs.next()) {
				Track track =new Track();
				track.setTrackId(rs.getInt(1));
				track.setComments(rs.getString(2));
				track.setTrackName(rs.getString(3));
				trackList.add(track);
				//System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  " + rs.getString(4));
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return trackList;
	}

	public List<Track> displayTrackByName(String track_name, Track track) {
		List<Track> trackList = new ArrayList<>();
		try{

			//Resister Driver with driver manager service
			//Class.forName("com.mysql.cj.jdbc.Driver");
			//System.out.println("Driver loaded");//create connection
			//here db1 is database name, root is username and root123 is password
			con= DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/moviedb","root","Root@123");
			//create statement object
			System.out.println("got connected");

			PreparedStatement stmt=con.prepareStatement("Select * from track where track_name = ?");
			stmt.setString(1,track_name);
			ResultSet rs = stmt.executeQuery();
			//execute query
			//  ResultSet rs=stmt.executeQuery("select * from customers");
			//process result
			rs.first();
				track.setTrackId(rs.getInt(1));
				track.setComments(rs.getString(2));
				track.setTrackName(rs.getString(3));
				//System.out.println("ID "+rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4));
			con.close();
		}catch(Exception e){ System.out.println(e);}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println(track.toString());
		trackList.add(track);
		return trackList;
	}

	public void saveTrack(Track track) {
		try {
			//Resister Driver with driver manager service
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded");//create connection
			//here db1 is database name, root is username and root123 is password
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/moviedb", "root", "Root@123");
			//create statement object
			System.out.println("got connected");

			PreparedStatement stmt = con.prepareStatement("insert into track (track_id, comments, track_name) values (?,?,?)");
			stmt.setInt(1, track.getTrackId());
			stmt.setString(3, track.getTrackName());
			stmt.setString(2, track.getComments());
			stmt.executeUpdate();
		}catch(Exception e){ System.out.println(e);}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public void deleteTrack(int deleteTrackId) {
		try {
			//Resister Driver with driver manager service
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded");//create connection
			//here db1 is database name, root is username and root123 is password
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/moviedb", "root", "Root@123");
			//create statement object
			System.out.println("got connected");

			PreparedStatement stmt = con.prepareStatement("delete from track where track_id=?");
			stmt.setInt(1,deleteTrackId);
			stmt.executeUpdate();
		}catch(Exception e){ System.out.println(e);}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
