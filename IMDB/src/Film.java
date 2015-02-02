import java.util.ArrayList;


public class Film {
	private int id;
	private String title;
	private String date;
	private String url;
	private String[] genre;
	private ArrayList<Rating> ratings;
	
	public Film(int id, String title, String date, String url, String[] genre) {
		this.id = id;
		this.title = title;
		this.date = date;
		this.url = url;
		this.genre = genre;
		ratings = new ArrayList<Rating>();
	}
	
	public int getID() {
		return id;
	}
	
	public void addRating(Rating r) {
		ratings.add(r);
	}
	
	public String[] getGenre() {
		return genre;
	}
	
	public double getAverageRating() {
		double total = 0;
		for (Rating r : ratings) {
			total += r.getStars();
		}
		if (ratings.size() == 0) {
			return 3;
		}
		return total/ratings.size();
	}
	
	public double getAverageRating(String genre) {
		double total = 0;
		int count = 0;
		for (Rating r : ratings) {
			if (Library.getUser(r.getUserID()).getFavoriteGenreByTotal().equals(genre)) {
				total+=r.getStars();
				count++;
			}
		}
		if (count != 0) {
			return total / count;
		} else {
			return getAverageRating();
		}
	}
	
	public String toString() {
		String result = "";
		result += "ID: " + id;
		result += "\nTitle: " + title;
		result += "\nDate: " + date;
		result += "\nURL: " + url;
		
		if (genre.length == 1)
			result+="\nGenre: " + genre[0];
		else {
			result += "\nGenres: ";
			for (int i = 0; i < genre.length; i++) {
				if (i == genre.length - 1)
					result += genre[i];
				else
					result+=genre[i]+", ";
			}
		}
		return result;
	}
}
