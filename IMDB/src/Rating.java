
public class Rating {

	private int stars;
	private User user;
	private Film movie;
	private int id;
	
	public Rating(User user, Film movie, int stars, int id) {
		this.stars = stars;
		this.user = user;
		this.movie = movie;
		this.id = id;
	}
	
	public int getID() {
		return id;
	}
	
	public User getUser() {
		return user;
	}
	
	public Film getFilm() {
		return movie;
	}
	
	public int getStars() {
		return stars;
	}
	
	public String toString() {
		return "User: " + user.getID() + "\nFilm: " + movie.getID() + "\nStars: " + stars + "\nID: " + id;
	}
}
