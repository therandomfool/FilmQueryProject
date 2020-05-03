package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {
	
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false";

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public Film findFilmById(int filmId) throws SQLException {
		
		Film film = null;
		String user = "student";
		String pass = "student";
		
		// connect to db
		Connection conn = DriverManager.getConnection(URL, user, pass);
		
//		System.out.println(filmId);
		String sql = "SELECT * FROM film WHERE id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, filmId);
		
		ResultSet filmResult = stmt.executeQuery();
		
		while (filmResult.next()) {
			film = new Film(); // Create the object
			// Here is our mapping of query columns to our object fields:
			film.setId(filmResult.getInt("id"));
			film.setTitle(filmResult.getString("title"));
//		    film.setLastName(filmResult.getString(3));
		}

		return film;
	}

//  public Actor findActorById(int actorId) {
//	  Actor actor = null;
//	  //...
//	  String sql = "SELECT id, first_name, last_name FROM actor WHERE id = ?";
//	  PreparedStatement stmt = conn.prepareStatement(sql);
//	  stmt.setInt(1,actorId);
//	  ResultSet actorResult = stmt.executeQuery();
//	  if (actorResult.next()) {
//	    actor = new Actor(); // Create the object
//	    // Here is our mapping of query columns to our object fields:
//	    actor.setId(actorResult.getInt(1));
//	    actor.setFirstName(actorResult.getString(2));
//	    actor.setLastName(actorResult.getString(3));
//	  }
//	  //...
//	  return actor;
//	}

}
