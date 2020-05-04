package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {
//		passwords
	String user = "student";
	String pass = "student";

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

//		passwords
		String user = "student";
		String pass = "student";

		// connect to db
		Connection conn = DriverManager.getConnection(URL, user, pass);

//		System.out.println(filmId);
		String sql = "SELECT * FROM film WHERE film.id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, filmId);

		ResultSet filmResult = stmt.executeQuery();

		while (filmResult.next()) {

			// Create the object
			film = new Film();

			// Here is our mapping of query columns to our object fields:
			film.setId(filmResult.getInt("id"));
			film.setTitle(filmResult.getString("title"));
			film.setDescription(filmResult.getString("description"));
			film.setRating(filmResult.getString("rating"));
			film.setReleaseYear(filmResult.getInt("release_year"));
			film.setLanguageId(filmResult.getInt("language_id"));
			film.setRentalDuration(filmResult.getInt("rental_duration"));
			film.setRentalRate(filmResult.getDouble("rental_rate"));
			film.setLength(filmResult.getInt("length"));
			film.setReplacemnetCost(filmResult.getDouble("replacement_cost"));
			film.setRating(filmResult.getString("rating"));
			film.setSpecialFeatures(filmResult.getString("special_features"));
			film.setLanguage(language(filmId));
			film.setFilmActors(findAByFID(filmResult.getInt("id")));
		}

		filmResult.close();
		stmt.close();
		conn.close();

		return film;
	}

	public List<Film> findFBySearch(String fKW) throws SQLException {
		Film film = null;
		List<Film> filmKW = new ArrayList<>();

////		passwords
//		String user = "student";
//		String pass = "student";

		// connect to db
		Connection conn = DriverManager.getConnection(URL, user, pass);

//		Select statement /Prepared statement

		String sql = "select film.*, language.name from film join language on film.language_id = language.id where title like ? or description like ?";

		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, "%" + fKW + "%");
		stmt.setString(2, "%" + fKW + "%");

		ResultSet filmResult = stmt.executeQuery();

		while (filmResult.next()) {

			// Create the object
			film = new Film();

			// Here is our mapping of query columns to our object fields:
			film.setId(filmResult.getInt("id"));
			film.setTitle(filmResult.getString("title"));
			film.setDescription(filmResult.getString("description"));
			film.setRating(filmResult.getString("rating"));
			film.setReleaseYear(filmResult.getInt("release_year"));
			film.setLanguageId(filmResult.getInt("language_id"));
			film.setRentalDuration(filmResult.getInt("rental_duration"));
			film.setRentalRate(filmResult.getDouble("rental_rate"));
			film.setLength(filmResult.getInt("length"));
			film.setReplacemnetCost(filmResult.getDouble("replacement_cost"));
			film.setRating(filmResult.getString("rating"));
			film.setLanguage(language(film.getId()));
			film.setSpecialFeatures(filmResult.getString("special_features"));
			film.setFilmActors(findAByFID(filmResult.getInt("id")));
			
			
			filmKW.add(film);
		}

		filmResult.close();
		stmt.close();
		conn.close();

		return filmKW;

	}

	public List<Actor> findAByFID(int filmID) throws SQLException {
		List<Actor> fABFI = new ArrayList<>();
		Actor actor = null;


		// connect to db
		Connection conn = DriverManager.getConnection(URL, user, pass);

//		Select statement /Prepared statement
		String sql = "SELECT actor.first_name, actor.last_name, actor.id, film_actor.film_id FROM actor JOIN film_actor ON film_actor.actor_id = actor.id JOIN film ON film.id = film_actor.film_id WHERE film_id = ? ORDER BY actor.last_name ASC";

		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, filmID);
		
		ResultSet aFResult = stmt.executeQuery();

		while (aFResult.next()) {

			// Create the object
			actor = new Actor();

			// Here is our mapping of query columns to our object fields:
			actor.setId(aFResult.getInt("id"));
			actor.setFirstName(aFResult.getString("first_name"));
			actor.setLastName(aFResult.getString("last_name"));
			fABFI.add(actor);
			
//			actor.setTitle(filmResult.getString("title"));
		
		}

		aFResult.close();
		stmt.close();
		conn.close();

		return fABFI;

	}
	
	
	public Actor findABID(int actorId) throws SQLException {
		
// not used?
		return null;
	}
	
	@Override
	public String language(int filmId) throws SQLException {
		String filmLanguage = null;
		Connection conn = DriverManager.getConnection(URL, user, pass);
		String sql = "SELECT language.name FROM language JOIN film on language.id = film.language_id WHERE film.id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, filmId);
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			filmLanguage = rs.getString("name");
		}
		
		rs.close();
		stmt.close();
		conn.close();
		return filmLanguage;
	}
	

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