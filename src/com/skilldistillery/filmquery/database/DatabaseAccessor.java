package com.skilldistillery.filmquery.database;

import java.sql.SQLException;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public interface DatabaseAccessor {
  public Film findFilmById(int filmId) throws SQLException;
  public List<Film> findFBySearch(String fKW) throws SQLException;
  
//   ? needed ?
  public Actor findABID(int actorId) throws SQLException;
  public List<Actor> findAByFID(int filmId) throws SQLException;
//  public Actor findActorById(int actorId);
String language(int filmId) throws SQLException;
  
//  public List<Actor> findActorsByFilmId(int filmId);
}
