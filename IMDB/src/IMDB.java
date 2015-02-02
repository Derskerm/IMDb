import java.util.ArrayList;


public class IMDB {

	private static final String usersFile = "u.user";
	private static final String moviesFile = "u.item";
	private static final String genresFile = "u.genre";
	private User[] userArray;
	private Film[] filmArray;
	private String[] ratingArray;
	// Add fields to represent your database.


	
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
		String[] userDataArray = userData.split("\n");
		userArray = new User[userDataArray.length];
		for (int i = 0; i < userArray.length; i++) {
			userArray[i] = translator.lineToUser(userDataArray[i]);
		}
		String[] filmDataArray = filmData.split("\n");
		filmArray = new Film[filmDataArray.length];
		for (int i = 0; i < filmArray.length; i++) {
			filmArray[i] = translator.lineToFilm(filmDataArray[i]);
		}
	}
	

	/**
	 * Returns an array of objects representing movie data.
	 * 
	 * @return An array of objects representing individual movies.
	 */
	public Object[] getMovieData() {
		return filmArray;
	}
	

	/**
	 * Returns an array of objects representing user data.
	 * 
	 * @return An array of objects representing individual users.
	 */
	public Object[] getUserData() {
		return userArray;
	}

	
	/**
	 * If userNumber has rated movieNumber, return the rating. Otherwise, return -1.
	 * 
	 * @param userNumber The ID of the user.
	 * @param movieNumber The ID of the movie.
	 * @return The rating that userNumber gave movieNumber, or -1 if the user does not exist in the database, the movie does not exist, or the movie has not been rated by this user.
	 */
	public double getRating(long userID, long movieID) {
		return 0;
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

		return 0;
	}
	
}
