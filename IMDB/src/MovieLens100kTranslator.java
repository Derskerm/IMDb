import java.util.ArrayList;


public class MovieLens100kTranslator {

	
	public final String[] genres = new String[19];
	
	public MovieLens100kTranslator() {
		FileIO fileio = new FileIO();
		String data = fileio.readFile("u.genre");
		String[] splitData = data.split("\n");
		int count = 0;
		for (String s : splitData) {
			genres[count] = s.substring(0, s.indexOf("|"));
			count++;
		}
	}

	public User lineToUser(String s) {
		String[] data = s.split("\\|");
		User user;
		try {
			user = new User(Integer.parseInt(data[0]),Integer.parseInt(data[1]),data[2],data[3],data[4]);
		} catch (java.lang.NumberFormatException e) {
			user = null;
		}
		return user;
	}
	
	public Film lineToFilm(String s) {
		String[] data = s.split("\\|");
		Film film = null;
		ArrayList<Integer> filmGenres = new ArrayList<Integer>();
		for (int i = 5; i < data.length; i++) {
			if (data[i].equals("1")) {
				filmGenres.add(i - 5);
			}
		}
		int[] genreInts = new int[filmGenres.size()];
		for (int i = 0; i < genreInts.length; i++) {
			genreInts[i] = filmGenres.get(i);
		}
		film = new Film(Integer.parseInt(data[0]), data[1], data[2], data[4], genreInts);
		return film;
	}
	
	public Rating lineToRating(String s) {
		String[] data = s.split("\t");
		Rating rating;
		try {
			rating = new Rating(Integer.parseInt(data[0]),Integer.parseInt(data[1]),Integer.parseInt(data[2]),Integer.parseInt(data[3]));
		} catch (java.lang.NumberFormatException e) {
			rating = null;
		}
		return rating;
	}
}
