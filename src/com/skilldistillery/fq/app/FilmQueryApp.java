package com.skilldistillery.fq.app;

import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {
	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) {
		FilmQueryApp app = new FilmQueryApp();
		app.test();
//		app.launch();

	}

	private void test() {
		Film film = db.findFilmById(1);
		System.out.println(film);
	}

//launch
	private void launch() {
		Scanner input = new Scanner(System.in);

		startUserInterface(input);

		input.close();
	}

//MENU AND CHOICE
	private void startUserInterface(Scanner input) {
		System.out.println("USER STORY ONE");

		boolean x = true;
		
		while (x == true) {
			System.out.println("* * * * USER CHOICE MENU * * * * \n");
			System.out.println("\t[ I ] FILM BY ID");
			System.out.println("\t[ K ] FILM BY KEYWORD");
			System.out.println("\t[ X ] EXIT");

			String choice = input.nextLine();

			switch (choice) {
			case "I | i":
				System.out.println("~ # ~ # FILM ID PLEASE: ");
//				retrieve film by ID
				break;
				
			case "K | k":
				System.out.println("~ # ~ # FILM KEYWORD PLEASE: ");
//				retrieve film by keyword
				break;
				
			case "X | x":
				System.out.println("~ # ~ # HAVE A FINE DAY # ~ # ~ ");
//				exit
				x = false;
				break;
				
				
			default: 
//				loop around for another pass
				System.out.println("YOU HAVE NOT CHOOSEN A PROPER INPUT");
				
			}
			
		}
	}
}
