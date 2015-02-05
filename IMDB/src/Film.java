import java.util.ArrayList;


public class Film {
	private int id;
	private String title;
	private String date;
	private String url;
	private int[] genre;
	private ArrayList<Rating> ratings;
	private static FileIO fileIO = new FileIO();
	private double[] averageRatings;
	private double averageRating;
	private Rating[] ratingsArray;
	private Rating[][] ratingsArrayByValue;
	
	public Film(int id, String title, String date, String url, int[] genre) {
		this.id = id;
		this.title = title;
		this.date = date;
		this.url = url;
		this.genre = genre;
		ratings = new ArrayList<Rating>();
	}
	
	public void calculate() {
		ratingsArray = new Rating[ratings.size()];
		ratingsArray = ratings.toArray(ratingsArray);
		ratingsArrayByValue = new Rating[5][];
		for (int i = 0; i < ratingsArrayByValue.length; i++) {
			ratingsArrayByValue[i] = this.calcRatings(i+1);
		}
		averageRatings = new double[Library.getGenres().length];
		for (int i = 0; i < averageRatings.length; i++) {
			averageRatings[i] = calcAverageRating(i);
		}
		averageRating = calcAverageRating();
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
		return ratingsArrayByValue[stars - 1];
	}
	
	public int getID() {
		return id;
	}
	
	public void addRating(Rating r) {
		ratings.add(r);
	}
	
	public int[] getGenre() {
		return genre;
	}
	
	private double calcAverageRating() {
		double total = 0;
		for (Rating r : ratingsArray) {
			total += r.getStars();
		}
		if (ratingsArray.length == 0) {
			return 3;
		}
		return total/ratingsArray.length;
	}
	
	public double getAverageRating() {
		return averageRating;
	}
	
	private double calcAverageRating(int genre) {
		double total = 0;
		int count = 0;
		for (Rating r : ratingsArray) {
			if (Library.getUser(r.getUserID()).getFavoriteGenreByTotal()==genre) {
				total+=r.getStars();
				count++;
			}
		}
		if (count != 0) {
			return total / count;
		} else {
			return -1;
		}
	}
	
	public double getAverageRating(int genre) {
		return averageRatings[genre];
	}
	
	public String toString() {
		String result = "";
		result += "ID: " + id;
		result += "\nTitle: " + title;
		result += "\nDate: " + date;
		result += "\nURL: " + url;
		
		if (genre.length == 1)
			result+="\nGenre: " + Library.getGenres()[genre[0]];
		else {
			result += "\nGenres: ";
			for (int i = 0; i < genre.length; i++) {
				if (i == genre.length - 1)
					result += Library.getGenres()[genre[i]];
				else
					result+=Library.getGenres()[genre[i]]+", ";
			}
		}
		return result;
	}
}
