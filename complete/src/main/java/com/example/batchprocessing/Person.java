package complete.src.main.java.com.example.batchprocessing;

public class Person {

	private String lastName;
	private String firstName;
	private String date;

	public Person() {
	}

	public Person(String firstName, String lastName, String date) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.date = date;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getDate() {
		return date;
	}



	@Override
	public String toString() {
		return "firstName: " + firstName + ", lastName: " + lastName+ ", date: " + date;
	}

}
