import java.util.ArrayList;


public class Library {

	private static ArrayList<Film> films = new ArrayList<Film>();
	private static ArrayList<User> users = new ArrayList<User>();
	private static ArrayList<Rating> ratings = new ArrayList<Rating>();
	private static Film[] filmArray;
	private static User[] userArray;
	private static Rating[] ratingsArray;
	private static String[] genres;
	
	public static void addFilm(Film f) {
		films.add(f);
	}
	
	public static User getUser(int ID) {
		if (ID >= 0 && ID < userArray.length)
			return userArray[ID];
		return null;
	}
	
	private static User findUser(int ID) {
		if (ID >= 0 && ID < users.size())
			return users.get(ID);
		return null;
	}
	
	public static void addUser(User u) {
		users.add(u);
	}
	
	public static Film getFilm(int ID) {
		if (ID >= 0 && ID < filmArray.length)
			return filmArray[ID];
		return null;
	}
	
	private static Film findFilm(int ID) {
		if (ID >= 0 && ID < films.size())
			return films.get(ID);
		return null;
	}
	
	public static void calculate() {
		filmArray = new Film[films.size()];
		filmArray = films.toArray(filmArray);
		userArray = new User[users.size()];
		userArray = users.toArray(userArray);
		ratingsArray = new Rating[ratings.size()];
		ratingsArray = ratings.toArray(ratingsArray);
	}
	
	public static User[] getUsers() {
		return userArray;
	}
	
	public static Film[] getFilms() {
		return filmArray;
	}
	
	public static void addGenres(String[] genre) {
		genres = genre;
	}
	
	public static String[] getGenres() {
		return genres;
	}
	
	public static void addRating(Rating r) {
		ratings.add(r);
		User u = findUser(r.getUserID());
		Film f = findFilm(r.getFilmID());
		if (u != null && f != null) {
			u.addRating(r);
			f.addRating(r);
		}
	}
	
	public static Rating getRating(int userID, int filmID) {
		for (Rating r : ratingsArray) {
			if (r.getUserID() == userID && r.getFilmID() == filmID) {
				return r;
			}
		}
		return null;
	}
}
