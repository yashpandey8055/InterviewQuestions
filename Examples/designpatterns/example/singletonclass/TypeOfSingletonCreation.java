package example.singletonclass;

public enum TypeOfSingletonCreation {
	EAGER("eager"),
	LAZY("lazy"),
	ENUM("enum"),
	HOLDER("holder");
	
	private String type;
	
	private TypeOfSingletonCreation(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
}
