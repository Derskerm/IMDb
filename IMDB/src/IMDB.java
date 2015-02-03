import java.util.ArrayList;


public class IMDB {

	private static final String usersFile = "u.user";
	private static final String moviesFile = "u.item";
	private static final String genresFile = "u.genre";
	private static User[] users;
	private static Film[] films;


	
	/**
	 * Use ratingsFile to read all data into some local structures.
	 * 
	 * @param ratingsFile The filename of the ratings database.
	 */
	public IMDB(String ratingsFile) {
		FileIO reader = new FileIO();
		String userData = reader.readFile(usersFile);
		String filmData = reader.readFile(moviesFile);
		String ratingsData = reader.readFile(ratingsFile);
		MovieLens100kTranslator translator = new MovieLens100kTranslator();
		Library.addGenres(translator.genres);
		String[] userDataArray = userData.split("\n");
		for (int i = 0; i < userDataArray.length; i++) {
			Library.addUser(translator.lineToUser(userDataArray[i]));
		}
		String[] filmDataArray = filmData.split("\n");
		for (int i = 0; i < filmDataArray.length; i++) {
			Library.addFilm(translator.lineToFilm(filmDataArray[i]));
		}
		String[] ratingsDataArray = ratingsData.split("\n");
		for (int i = 0; i < ratingsDataArray.length; i++) {
			Library.addRating(translator.lineToRating(ratingsDataArray[i]));
		}
		Library.calculate();
		users = Library.getUsers();
		films = Library.getFilms();
		for (User u : users) {
			u.calculate();
		}
		for (Film f : films) {
			f.calculate();
		}
	}
	

	/**
	 * Returns an array of objects representing movie data.
	 * 
	 * @return An array of objects representing individual movies.
	 */
	public Object[] getMovieData() {
		return new Object[0];
	}
	

	/**
	 * Returns an array of objects representing user data.
	 * 
	 * @return An array of objects representing individual users.
	 */
	public Object[] getUserData() {
		return new Object[0];
	}

	
	/**
	 * If userNumber has rated movieNumber, return the rating. Otherwise, return -1.
	 * 
	 * @param userNumber The ID of the user.
	 * @param movieNumber The ID of the movie.
	 * @return The rating that userNumber gave movieNumber, or -1 if the user does not exist in the database, the movie does not exist, or the movie has not been rated by this user.
	 */
	public double getRating(long userID, long movieID) {
		try {
			return Library.getRating((int)userID,(int)movieID).getStars();
		} catch (java.lang.NullPointerException e) {
			return -1;
		}
	}
	
	/**
	 * If userNumber has rated movieNumber, return the rating. Otherwise, use other available data to guess what this user would rate the movie.
	 * 
	 * @param userNumber The ID of the user.
	 * @param movieNumber The ID of the movie.
	 * @return The rating that userNumber gave movieNumber, or the best guess if the movie has not been rated by this user.
	 * @pre A user with id userID and a movie with id movieID exist in the database.
	 */
	public double guessRating(long userID, long movieID) {
		try {
			return Library.getRating((int)userID,(int)movieID).getStars();
		} catch (java.lang.NullPointerException e) {
			Film f = Library.getFilm((int)movieID);
			User u = Library.getUser((int)userID);
//			int genre = u.getFavoriteGenreByTotal();
//			return f.getAverageRating(genre) + u.getAverageRating(f.getGenre()[0]) - f.getAverageRating();
//			int[] genres = f.getGenre();
//			double[] differences = new double[genres.length];
//			for (int i = 0; i < differences.length; i++) {
//				differences[i] = (u.getAverageRating(genres[i]) - 3)*u.getRatingsCount(genres[i]);
//			}
//			double total = 0;
//			for (double d : differences) {
//				total += d;
//			}
//			total/=u.getRatingsCount();
//			double avg = f.getAverageRating();
//			if (avg == 0.0) {
//				avg = 3;
//			}
//			if (avg + total < 1) {
//				return 1;
//			} else if (avg + total > 5) {
//				return 5;
//			} else {
//				return avg + total;
//			}
			return f.getAverageRating(u.getFavoriteGenreByAvgRating());
		}
	}
	
}
