package example.immutableclass;

import java.util.Date;
import java.util.Map;

/**
 * A simple Non immutable class whose 
 * Data can be changed 
 * @author Yash
 *
 */
public class MutablePerson {

	private String name;

	private String rollNumber;
	
	private Date dateOfBirth;
	
	private Map<String,Integer> marks;
	
	public MutablePerson(String name, String rollNumber, Date dateOfBirth,
			Map<String,Integer> marks) {
		this.name = name;
		this.rollNumber = rollNumber;
		this.dateOfBirth = dateOfBirth;
		this.marks = marks;
	}

	public String getName() {
		return name;
	}

	public String getRollNumber() {
		return rollNumber;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public Map<String, Integer> getMarks() {
		return marks;
	}
}
