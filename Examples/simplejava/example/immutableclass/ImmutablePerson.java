package example.immutableclass;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public final class ImmutablePerson {
	
	private String name;

	private String rollNumber;
	
	private Date dateOfBirth;
	
	private Map<String,Integer> marks;
	
	public ImmutablePerson(String name, String rollNumber, Date dateOfBirth,
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
		return new Date(dateOfBirth.getTime());
	}

	public Map<String, Integer> getMarks() {
		if(marks !=null) {
			return new HashMap<>(marks);
		}else {
			return null;
		}
	}
	
}
