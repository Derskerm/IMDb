import java.util.ArrayList;


public class Library {

	private static ArrayList<Film> films;
	private static ArrayList<User> users;
	
	public static void addFilm(Film f) {
		boolean repeat;
		int ID = f.getID();
		for (Film film : films) {
			if (film.getID() == ID) {
				repeat = true;
			}
		}
		films.add(f);
	}
	
	private boolean isRepeat() {
		return false;
	}
}
