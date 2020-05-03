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
		String sql = "SELECT * FROM film WHERE id = ?";
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
		}

		filmResult.close();
		stmt.close();
		conn.close();

		return film;
	}

	public List<Film> findFBySearch(String fKW) throws SQLException {
		Film film = null;
		List<Film> filmKW = new ArrayList<>();

//		passwords
		String user = "student";
		String pass = "student";

		// connect to db
		Connection conn = DriverManager.getConnection(URL, user, pass);

//		Select statement /Prepared statement
		String sql = "SELECT * FROM film WHERE film.title LIKE ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, "%" + fKW + "%");

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

//		passwords
		String user = "student";
		String pass = "student";

		// connect to db
		Connection conn = DriverManager.getConnection(URL, user, pass);

//		Select statement /Prepared statement
		String sql = "SELECT actor.first_name, actor.last_name, actor.id, film_actor.film_id\n" + "FROM actor\n"
				+ "JOIN film_actor\n" + "ON film_actor.actor_id = actor.id\n" + "JOIN film\n"
				+ "ON film.id = film_actor.film_id\n" + "WHERE film_id = ?";

		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, filmID);

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