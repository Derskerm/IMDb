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
	}
	
	public int getID() {
		return id;
	}
	
	public String toString() {
		String result = "";
		result += "Id: " + id;
		result += "\nTitle: " + title;
		result+="\nGenre: ";
		for (String s : genre) {
			result+='\t'+s+'\n';
		}
		return result;
	}
}
