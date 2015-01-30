
public class MovieLens100kTranslator {

	public MovieLens100kTranslator() {
		
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
	
//	public Film lineToFilm(String s) {
//		
//	}
	
}
