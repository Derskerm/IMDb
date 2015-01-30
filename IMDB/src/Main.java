
public class Main {

	public static void main(String[] args) {
		FileIO reader = new FileIO();
		String userData = reader.readFile("u.user");
		String movieData = reader.readFile("u.item");
		String ratingsData = reader.readFile("u.data");
		
		System.out.println(ratingsData);
	}
	
}
