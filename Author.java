/*
 * Abhinandan Roul
 * Regd- 1941012359
 */
public class Author {
	 String name;
	 String email;
	 char gender;

	Author(String name, String email, char gender) {
		this.name = name;
		this.email = email;
		this.gender = gender;

	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public char getGender() {
		return gender;
	}
	public String toString() {
		return "Author name: " + name + "\t Email: " + email + "\t Gender: "
				+ gender ;
	}
}

	