
public class Main {

	public static void main(String[] args) {
		FileIO reader = new FileIO();
		String userData = reader.readFile("u.user");
		String filmData = reader.readFile("u.item");
		String ratingsData = reader.readFile("u.data");
		MovieLens100kTranslator translator = new MovieLens100kTranslator();
		Library.addGenres(translator.genres);
		String[] userDataArray = userData.split("\n");
		User[] userArray = new User[userDataArray.length];
		for (int i = 0; i < userArray.length; i++) {
			userArray[i] = translator.lineToUser(userDataArray[i]);
		}
		for (User f : userArray) {
			Library.addUser(f);
		}
		String[] filmDataArray = filmData.split("\n");
		Film[] filmArray = new Film[filmDataArray.length];
		for (int i = 0; i < filmArray.length; i++) {
			filmArray[i] = translator.lineToFilm(filmDataArray[i]);
		}
		for (Film f : filmArray) {
			Library.addFilm(f);
		}
		String[] ratingsDataArray = ratingsData.split("\n");
		Rating[] ratingsArray = new Rating[ratingsDataArray.length];
		for (int i = 0; i < ratingsArray.length; i++) {
			ratingsArray[i] = translator.lineToRating(ratingsDataArray[i]);
		}
		for (Rating f : ratingsArray) {
			Library.addRating(f);
		}
		for (User u : userArray) {
			String[] myFavGenres = u.getFavoriteGenreByTotal();
			for (String s : myFavGenres) {
				System.out.println(s + ": " + u.getAverageRating(s));
			}
			System.out.println("");
		}
	}
	
}
