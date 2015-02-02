import java.util.ArrayList;

public class User {
	private String profession;
	private String gender;
	private int age;
	private ArrayList<Rating> ratings;
	private int id;
	String zipcode;
	
	public User(int id, int age, String gender, String profession, String zipcode) {
		this.profession = profession;
		this.gender = gender;
		this.age = age;
		ratings = new ArrayList<Rating>();
		this.id = id;
		this.zipcode = zipcode;
	}
	
	public int getID() {
		return id;
	}
	
	public void addRating(Rating r) {
		ratings.add(r);
	}
	
	public double getAverageRating() {
		double total = 0;
		for (Rating r : ratings) {
			total += r.getStars();
		}
		return total/ratings.size();
	}
	
	public double getAverageRating(String genre) {
		double total = 0;
		int count = 0;
		Film f;
		String[] genres;
		for (Rating r : ratings) {
			genres = Library.getFilm(r.getFilmID()).getGenre();
			for (String s : genres) {
				if (genre.equals(s)) {
					total += r.getStars();
					count++;
				}
			}
		}
		if (count == 0) {
			return -1;
		}
		return total/count;
	}
	
	public Rating[] getRatings() {
		Rating[] ratingsArray = new Rating[ratings.size()];
		ratingsArray = ratings.toArray(ratingsArray);
		return ratingsArray;
	}
	
	public Rating[] getRatings(int stars) {
		ArrayList<Rating> specificRatings = new ArrayList<Rating>();
		for (Rating r : ratings) {
			if (r.getStars() == stars) {
				specificRatings.add(r);
			}
		}
		Rating[] ratingsArray = new Rating[specificRatings.size()];
		ratingsArray = specificRatings.toArray(ratingsArray);
		return ratingsArray;
	}
	
	public String[] getFavoriteGenreByCount() {
		int[] genreCount = new int[19];
		String[] myGenres;
		String[] GENRES = Library.getGenres();
		for (Rating r : ratings) {
			myGenres = Library.getFilm(r.getFilmID()).getGenre();
			for (String s : myGenres) {
				for (int i = 0; i < GENRES.length; i++) {
					if (s.equals(GENRES[i])) {
						genreCount[i]++;
					}
				}
			}
		}
		ArrayList<String> results = new ArrayList<String>();
		int favGenreCount = 0;
		for (int i : genreCount) {
			if (i > favGenreCount) {
				favGenreCount = i;
			}
		}
		for (int i = 0; i < genreCount.length; i++) {
			if (genreCount[i] == favGenreCount) {
				results.add(GENRES[i]);
			}
		}
		String[] answers = new String[results.size()];
		answers = results.toArray(answers);
		return answers;
	}
	
	public String[] getFavoriteGenreByAvgRating() {
		double[] genreRatings = new double[19];
		String[] GENRES = Library.getGenres();
		double favGenreCount = 0;
		for (int i = 0; i < genreRatings.length; i++) {
			genreRatings[i] = getAverageRating(GENRES[i]);
			if (favGenreCount < genreRatings[i]) {
				favGenreCount = genreRatings[i];
			}
		}
		ArrayList<String> results = new ArrayList<String>();
		for (int i = 0; i < genreRatings.length; i++) {
			if (genreRatings[i] == favGenreCount) {
				results.add(GENRES[i]);
			}
		}
		String[] answers = new String[results.size()];
		answers = results.toArray(answers);
		return answers;
	}
	
	public String[] getFavoriteGenreByTotal() {
		double[] genreRatings = new double[19];
		String[] myGenres;
		String[] GENRES = Library.getGenres();
		for (Rating r : ratings) {
			myGenres = Library.getFilm(r.getFilmID()).getGenre();
			for (String s : myGenres) {
				for (int i = 0; i < GENRES.length; i++) {
					if (s.equals(GENRES[i])) {
						genreRatings[i]+=r.getStars();
					}
				}
			}
		}
		ArrayList<String> results = new ArrayList<String>();
		double favGenreCount = 0;
		for (double i : genreRatings) {
			if (i > favGenreCount) {
				favGenreCount = i;
			}
		}
		for (int i = 0; i < genreRatings.length; i++) {
			if (genreRatings[i] == favGenreCount) {
				results.add(GENRES[i]);
			}
		}
		String[] answers = new String[results.size()];
		answers = results.toArray(answers);
		return answers;
	}
	
	public String toString() {
		String info = "";
		info += "ID: " + id;
		info += "\nAge: " + age;
		info += "\nGender: " + gender;
		info += "\nProfession: " + profession;
		info += "\nZipcode: " + zipcode;
		return info;
	}
}
