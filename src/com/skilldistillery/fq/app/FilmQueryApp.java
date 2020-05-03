package com.skilldistillery.fq.app;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {
	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) throws SQLException {
		FilmQueryApp app = new FilmQueryApp();
//		app.test();
		app.launch();

	}

	private void test() throws SQLException {
		Film film = db.findFilmById(1);
		System.out.println(film);
	}

//launch
	private void launch() throws SQLException {
		Scanner input = new Scanner(System.in);

		startUserInterface(input);

		input.close();
	}

//MENU AND CHOICE
	private void startUserInterface(Scanner input) throws SQLException {
		System.out.println("USER STORY ONE");

		boolean x = true;

		while (x == true) {
			System.out.println("* * * * > USER CHOICE MENU  < * * * * \n");
			System.out.println("\t[ I ] > > > * FILM BY ID");
			System.out.println("\t[ K ] > > > * FILM BY KEYWORD");
			System.out.println("\t[ X ] > > > * EXIT");

			String choice = input.nextLine();

			switch (choice) {
			case "I":
			case "i":
				System.out.println("~ # ~ # FILM ID PLEASE: ");
				int fID = input.nextInt();
				
//				retrieve film by ID
				Film filmFind = (db.findFilmById(fID));
				if (filmFind != null) {
					filmFind.filmText();
				}

				break;

			case "K":
			case "k":
				System.out.println("~ # ~ # FILM KEYWORD PLEASE: ");
				String fKW = input.nextLine();
//				retrieve film by keyword
				
				List<Film> kwResult = db.findFBySearch(fKW);
				if(kwResult.size() == 0) {
					System.out.println("- + - + - + NO MATCHES + - + - + - ");
					
					break;
				} else {
					for (Film film : kwResult) {
						film.filmText();
						System.out.println("* - + * - + * - + * - + * - + * - +");
					}
				}

			case "X":
			case "x":
				System.out.println("\t~ # ~ # HAVE A FINE DAY # ~ # ~ ");
				System.out.println("\t\t~ # ~ # HAVE A FINE DAY # ~ # ~ ");
				System.out.println("\t\t\t~ # ~ # HAVE A FINE DAY # ~ # ~ ");
				System.out.println("\t\t\t\t~ # ~ # HAVE A FINE DAY # ~ # ~ ");
//				exit
				x = false;
				break;

			default:
//				loop around for another pass
				System.out.println("*----> YOU HAVE NOT CHOOSEN A PROPER INPUT");
				System.out.println("\t\t*----> YOU HAVE NOT CHOOSEN A PROPER INPUT");
				System.out.println("\t\t\t\t*----> YOU HAVE NOT CHOOSEN A PROPER INPUT\n\n");

			}

		}
	}
}
