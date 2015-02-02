import java.util.ArrayList;


public class Library {

	private static ArrayList<Film> films = new ArrayList<Film>();
	private static ArrayList<User> users = new ArrayList<User>();
	private static ArrayList<Rating> ratings = new ArrayList<Rating>();
	private static String[] genres;
	
	public static void addFilm(Film f) {
		films.add(f);
	}
	
	public static User getUser(int ID) {
		for (User u : users) {
			if (u.getID() == ID) {
				return u;
			}
		}
		return null;
	}
	
	public static void addUser(User u) {
		users.add(u);
	}
	
	public static Film getFilm(int ID) {
		for (Film u : films) {
			if (u.getID() == ID) {
				return u;
			}
		}
		return null;
	}
	
	public static void addGenres(String[] genre) {
		genres = genre;
	}
	
	public static String[] getGenres() {
		return genres;
	}
	
	public static void addRating(Rating r) {
		ratings.add(r);
		getUser(r.getUserID()).addRating(r);
		getFilm(r.getFilmID()).addRating(r);
	}
	
	public static Rating getRating(int userID, int filmID) {
		for (Rating r : ratings) {
			if (r.getUserID() == userID && r.getFilmID() == filmID) {
				return r;
			}
		}
		return null;
	}
}
