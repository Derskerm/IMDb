import java.util.ArrayList;


public class Library {

	private static ArrayList<Film> films;
	private static ArrayList<User> users;
	
	public static void addFilm(Film f) {
		films.add(f);
	}
	
	public static Film findFilm(int ID) {
		for (Film film : films) {
			if (ID == film.getID()) {
				return film;
			}
		}
	}
	
	public static void addUser(User u) {
		users.add(u);
	}
	
	public static User findUser(int ID) {
		for (User user : users) {
			if (user.getID() == ID) {
				return user;
			}
		}
	}
}
