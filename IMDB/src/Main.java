
public class Main {

	public static void main(String[] args) {
		FileIO reader = new FileIO();
		String userData = reader.readFile("u.user");
		String movieData = reader.readFile("u.item");
		String ratingsData = reader.readFile("u.data");
		MovieLens100kTranslator translator = new MovieLens100kTranslator();
		String[] userDataArray = userData.split("\n");
		User[] userArray = new User[userDataArray.length];
		int dif = 0;
		for (int i = 0; i < userArray.length - dif; i++) {
			userArray[i] = translator.lineToUser(userDataArray[i + dif]);
			if (userArray[i] == null) {
				dif++;
				i--;
			}
		}
		System.out.println(userArray[0]);
	}
	
}
