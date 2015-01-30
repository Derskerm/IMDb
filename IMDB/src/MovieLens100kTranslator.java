import java.util.ArrayList;


public class MovieLens100kTranslator {

	
	private String[] genres = new String[19];;
	
	public MovieLens100kTranslator() {
		FileIO fileio = new FileIO();
		String data = fileio.readFile("u.genre");
		String[] splitData = data.split("\n");
		int count = 0;
		for (String s : splitData) {
			genres[count] = s.substring(0, s.indexOf("\\|"));
			count++;
		}
	}

	public User lineToUser(String s) {
		String[] data = s.split("\\|");
		User user;
		try {
			user = new User(Integer.parseInt(data[1]),data[2],data[3],Integer.parseInt(data[4]));
		} catch (java.lang.NumberFormatException e) {
			user = null;
		}
		return user;
	}
	
	public Film lineToFilm(String s) {
		String[] data = s.split("\t");
		Film film = null;
		ArrayList<String> filmGenres = null;
		for (int i = 5; i < data.length; i++) {
			if (data[i].equals('1')) {
				filmGenres.add(genres[i - 5]);
			}
		}
		try {
			film = new Film(Integer.parseInt(data[0]), data[1], data[2], data[4], (String[])filmGenres.toArray());
		} catch (java.lang.NumberFormatException e) {
			film = new Film(-1, data[1], data[2], data[4], (String[])filmGenres.toArray());
		}
		return film;
	}
	
}
