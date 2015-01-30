import java.util.ArrayList;


public class Film {
	private String[] genre;
	private String title;
	private int id;
	private ArrayList<Rating> ratings;
	
	public Film(String title, String[] genre, int id) {
		this.genre = genre;
		this.title = title;
		this.id = id;
	}
	
	public int getID() {
		return id;
	}
	
	public String toString() {
		return "Genre: " + genre + "\nTitle: " + title + "\nId: " + id;
	}
}
