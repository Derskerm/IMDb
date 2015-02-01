
public class Main {

	public static void main(String[] args) {
		FileIO reader = new FileIO();
		String userData = reader.readFile("u.user");
		String movieData = reader.readFile("u.item");
		String ratingsData = reader.readFile("u.data");
		MovieLens100kTranslator translator = new MovieLens100kTranslator();
		String[] userDataArray = userData.split("\n");
		User[] userArray = new User[userDataArray.length];
		for (int i = 0; i < userArray.length; i++) {
			userArray[i] = translator.lineToUser(userDataArray[i]);
		}
		System.out.println(userArray[0]);
	}
	
}
