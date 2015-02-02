
public class Rating {

	private int stars;
	private int userID;
	private int filmID;
	private int timestamp;
	
	public Rating(int userID, int filmID, int stars, int timestamp) {
		this.stars = stars;
		this.userID = userID;
		this.filmID = filmID;
		this.timestamp = timestamp;
	}
	
	public int getUserID() {
		return userID;
	}
	
	public int getFilmID() {
		return filmID;
	}
	
	public int getStars() {
		return stars;
	}
	
	public String toString() {
		return "User: " + userID + "\nFilm: " + filmID + "\nStars: " + stars + "\nTimestamp: " + timestamp;
	}
}
