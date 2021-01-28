package example.immutableclass;

public class Client {
	
	public static void main(String[] args) {
		System.out.println("######################### IMMMUTABLE OBJECT #####################");
		ShowImmutableExample showImmutableExample = new ShowImmutableExample();
		showImmutableExample.show();
		System.out.println("######################### MUTABLE OBJECT #####################");
		ShowMutableData showMutable = new ShowMutableData();
		showMutable.show();
	}
	
}
