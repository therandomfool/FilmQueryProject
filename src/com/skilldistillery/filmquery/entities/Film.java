package com.skilldistillery.filmquery.entities;

import java.util.List;

public class Film {

	private int id;
	private String title;
	private String description;
	private Integer releaseYear;
	private String language;
	private int languageId;
	private int rentalDuration;
	private double rentalRate;
	private int length;
	private double replacemnetCost;
	private String rating;
	private String specialFeatures;
	private List<Actor> filmActors;

	public Film() {
//		no args
	}

	public Film(int id, String title, String description, Integer releaseYear, String language, int languageId,
			int rentalDuration, double rentalRate, int length, double replacemnetCost, String rating,
			String specialFeatures) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear;
		this.language = language;
		this.languageId = languageId;
		this.rentalDuration = rentalDuration;
		this.rentalRate = rentalRate;
		this.length = length;
		this.replacemnetCost = replacemnetCost;
		this.rating = rating;
		this.specialFeatures = specialFeatures;
	}

	public void filmText() {
		System.out.println("\n#X*X#X* > > - ~ TITLE: ---->  " + title);
		delayOutPut();
		System.out.println("\n\t#X*X#X* > > - ~ YEAR: ---->  " + releaseYear);
		delayOutPut();
		System.out.println("\n\t\t#X*X#X* > > - ~ RATING: ---->  " + rating);
		delayOutPut();
		System.out.println("\n\t\t\t#X*X#X* > > - ~  DESCRIPTION: ---->  " + description);
		delayOutPut();
		System.out.println("\n\t\t\t\t#X*X#X* > > - ~  FILM LANGUAGE: " + language);
		delayOutPut();
		System.out.println("\n\t\t\t\t * # * # * # * ACTORS IN APPEARING IN THIS FILM ( IN ASCENDING ORDER BY LAST NAME ) * # * # * # * \n");
		System.out.println("\t\t\t\tVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV\n");
		for (Actor actor : filmActors) {
			System.out.println("\t\t\t---> * " + actor);
			delayOutPut();
		}

	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public List<Actor> getFilmActors() {
		return filmActors;
	}

	public void setFilmActors(List<Actor> filmActors) {
		this.filmActors = filmActors;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(Integer releaseYear) {
		this.releaseYear = releaseYear;
	}

	public int getLanguageId() {
		return languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}

	public int getRentalDuration() {
		return rentalDuration;
	}

	public void setRentalDuration(int rentalDuration) {
		this.rentalDuration = rentalDuration;
	}

	public double getRentalRate() {
		return rentalRate;
	}

	public void setRentalRate(double rentalRate) {
		this.rentalRate = rentalRate;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public double getReplacemnetCost() {
		return replacemnetCost;
	}

	public void setReplacemnetCost(double replacemnetCost) {
		this.replacemnetCost = replacemnetCost;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getSpecialFeatures() {
		return specialFeatures;
	}

	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((filmActors == null) ? 0 : filmActors.hashCode());
		result = prime * result + id;
		result = prime * result + ((language == null) ? 0 : language.hashCode());
		result = prime * result + languageId;
		result = prime * result + length;
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		result = prime * result + ((releaseYear == null) ? 0 : releaseYear.hashCode());
		result = prime * result + rentalDuration;
		long temp;
		temp = Double.doubleToLongBits(rentalRate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(replacemnetCost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((specialFeatures == null) ? 0 : specialFeatures.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (filmActors == null) {
			if (other.filmActors != null)
				return false;
		} else if (!filmActors.equals(other.filmActors))
			return false;
		if (id != other.id)
			return false;
		if (language == null) {
			if (other.language != null)
				return false;
		} else if (!language.equals(other.language))
			return false;
		if (languageId != other.languageId)
			return false;
		if (length != other.length)
			return false;
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
			return false;
		if (releaseYear == null) {
			if (other.releaseYear != null)
				return false;
		} else if (!releaseYear.equals(other.releaseYear))
			return false;
		if (rentalDuration != other.rentalDuration)
			return false;
		if (Double.doubleToLongBits(rentalRate) != Double.doubleToLongBits(other.rentalRate))
			return false;
		if (Double.doubleToLongBits(replacemnetCost) != Double.doubleToLongBits(other.replacemnetCost))
			return false;
		if (specialFeatures == null) {
			if (other.specialFeatures != null)
				return false;
		} else if (!specialFeatures.equals(other.specialFeatures))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Film [id=" + id + ", title=" + title + ", description=" + description + ", releaseYear=" + releaseYear
				+ ", language=" + language + ", languageId=" + languageId + ", rentalDuration=" + rentalDuration
				+ ", rentalRate=" + rentalRate + ", length=" + length + ", replacemnetCost=" + replacemnetCost
				+ ", rating=" + rating + ", specialFeatures=" + specialFeatures + ", filmActors=" + filmActors + "]";
	}
	
	private void delayOutPut() {
		try {
            Thread.sleep(1550); // 1000 is 1 sec
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
	}

}
