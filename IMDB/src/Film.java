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
	
	public Film(int id, String title, String date, String url, int[] genre) {
		this.id = id;
		this.title = title;
		this.date = date;
		this.url = url;
		this.genre = genre;
		ratings = new ArrayList<Rating>();
	}
	
	public void calculate() {
		averageRatings = new double[Library.getGenres().length];
		for (int i = 0; i < averageRatings.length; i++) {
			averageRatings[i] = calcAverageRating(i);
		}
		averageRating = calcAverageRating();
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
		for (Rating r : ratings) {
			total += r.getStars();
		}
		if (ratings.size() == 0) {
			return 3;
		}
		return total/ratings.size();
	}
	
	public double getAverageRating() {
		return averageRating;
	}
	
	private double calcAverageRating(int genre) {
		double total = 0;
		int count = 0;
		for (Rating r : ratings) {
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
