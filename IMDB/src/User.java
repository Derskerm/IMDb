import java.util.ArrayList;

public class User {
	private String profession;
	private String gender;
	private int age;
	private ArrayList<Rating> ratings;
	private int id;
	String zipcode;
	private double[] averageRatings;
	private double averageRating;
	private double favoriteGenre;
	private Rating[] ratingsArray;
	private Rating[][] ratingsArrayByValue;
	
	public User(int id, int age, String gender, String profession, String zipcode) {
		this.profession = profession;
		this.gender = gender;
		this.age = age;
		ratings = new ArrayList<Rating>();
		this.id = id;
		this.zipcode = zipcode;
	}
	
	public void calculate() {
		averageRatings = new double[Library.getGenres().length];
		for (int i = 0; i < averageRatings.length; i++) {
			averageRatings[i] = calcAverageRating(i);
		}
		averageRating = calcAverageRating();
		ratingsArray = new Rating[ratings.size()];
		ratingsArray = ratings.toArray(ratingsArray);
		ratingsArrayByValue = new Rating[5][];
		for (int i = 0; i < ratingsArrayByValue.length; i++) {
			ratingsArrayByValue[i] = this.calcRatings(i+1);
		}
	}
	
	public int getID() {
		return id;
	}
	
	public void addRating(Rating r) {
		ratings.add(r);
	}
	
	private double calcAverageRating() {
		double total = 0;
		for (Rating r : ratingsArray) {
			total += r.getStars();
		}
		return total/ratingsArray.length;
	}
	
	public double getAverageRating() {
		return averageRating;
	}
	
	private double calcAverageRating(int genre) {
		double total = 0;
		int count = 0;
		int[] genres;
		for (Rating r : ratingsArray) {
			genres = Library.getFilm(r.getFilmID()).getGenre();
			for (int i : genres) {
				if (genre == i) {
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
	
	public double getAverageRating(int genre) {
		return averageRatings[genre];
	}
	
	public Rating[] getRatings() {
		return ratingsArray;
	}
	
	private Rating[] calcRatings(int stars) {
		ArrayList<Rating> specificRatings = new ArrayList<Rating>();
		for (Rating r : ratingsArray) {
			if (r.getStars() == stars) {
				specificRatings.add(r);
			}
		}
		Rating[] ratingsArray = new Rating[specificRatings.size()];
		ratingsArray = specificRatings.toArray(ratingsArray);
		return ratingsArray;
	}
	
	public Rating[] getRatings(int stars) {
		return ratingsArrayByValue[stars];
	}
	
	public int getRatingsCount() {
		return ratings.size();
	}
	
	public int getRatingsCount(int genre) {
		int genreCount = 0;
		int[] myGenres;
		for (Rating r : ratingsArray) {
			myGenres = Library.getFilm(r.getFilmID()).getGenre();
			for (int s : myGenres) {
				if (s == genre) {
					genreCount++;
				}
			}
		}
		return genreCount;
	}
	
	public int getFavoriteGenreByCount() {
		double[] genreCounts = new double[19];
		double favGenreCount = 0;
		int favGenre = -1;
		for (int i = 0; i < genreCounts.length; i++) {
			genreCounts[i] = getRatingsCount(i);
			if (favGenreCount < genreCounts[i]) {
				favGenreCount = genreCounts[i];
				favGenre = i;
			}
		}
		return favGenre;
	}
	
	public int getFavoriteGenreByAvgRating() {
		double favGenreCount = 0;
		int favGenre = -1;
		for (int i = 0; i < averageRatings.length; i++) {
			if (averageRatings[i] > favGenreCount) {
				favGenreCount = averageRatings[i];
				favGenre = i;
			}
		}
		return favGenre;
	}
	
	public int getFavoriteGenreByTotal() {
		double[] genreRatings = new double[19];
		int[] myGenres;
		for (Rating r : ratingsArray) {
			myGenres = Library.getFilm(r.getFilmID()).getGenre();
			for (int s : myGenres) {
				genreRatings[s]+=r.getStars();
			}
		}
		int favGenre = -1;
		double favGenreCount = 0;
		for (int i = 0; i < genreRatings.length; i++) {
			if (genreRatings[i] > favGenreCount) {
				favGenreCount = genreRatings[i];
				favGenre = i;
			}
		}
		return favGenre;
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
