package example.singletonclass;

public class SimpleClient {
	
	public static void main(String[] args) {
		SimpleSingletonObject obj1 = SimpleSingletonObject.getInstance("Yash",99);
		SimpleSingletonObject obj2 = SimpleSingletonObject.getInstance("Sakshi",100);
		
		System.out.println("######################### Object1 Values  #####################");
		System.out.println("Value of name and Marks for Obj1 "+obj1.getName()+" "+obj1.getMarks());
		
		System.out.println("######################### Object2 Values  #####################");
		System.out.println("Value of name and Marks for Obj2 "+obj2.getName()+" "+obj2.getMarks());
	}

}
