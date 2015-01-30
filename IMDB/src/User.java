import java.util.ArrayList;

public class User {
	private String profession;
	private String gender;
	private int age;
	private ArrayList<Rating> ratings;
	
	public User(String profession, String gender, int age) {
		this.profession = profession;
		this.gender = gender;
		this.age = age;
		ratings = new ArrayList<Rating>();
	}
	
	public void rate(Film movie, int stars) {
		ratings.add(new Rating(stars, this, movie));
	}
	
	public String toString() {
		String info = "";
		info += "Profession: " + profession;
		info += "Gender: " + gender;
		info += "Age: " + age;
		return info;
	}
}
