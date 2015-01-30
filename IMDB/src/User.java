import java.util.ArrayList;

public class User {
	private String profession;
	private String gender;
	private int age;
	private ArrayList<Rating> ratings;
	private int id;
	
	public User(int age, String gender, String profession, int id) {
		this.profession = profession;
		this.gender = gender;
		this.age = age;
		ratings = new ArrayList<Rating>();
		this.id = id;
	}
	
	public int getID() {
		return id;
	}
	
	public String toString() {
		String info = "";
		info += "Age: " + age;
		info += "\nGender: " + gender;
		info += "\nProfession: " + profession;
		info += "\nID: " + id;
		return info;
	}
}
