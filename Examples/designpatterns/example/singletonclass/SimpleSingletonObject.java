package example.singletonclass;

public class SimpleSingletonObject {
	
	private static SimpleSingletonObject object = null;
	
	private String name;
	private Integer marks;

	private SimpleSingletonObject(String name, Integer marks) {
		this.name = name;
		this.marks = marks;
	}

	public static SimpleSingletonObject getInstance(String name, Integer marks) {
		if(object == null) {
			object = new SimpleSingletonObject(name,marks);
		}
		return object;
	}

	public String getName() {
		return name;
	}

	public Integer getMarks() {
		return marks;
	}
}
