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
	
	
/**
 * NOTES
*/
	
/**
1 :: 
	public class Calculator{
		  private ImmutablePerson currentValue = null;

		  public ImmutablePerson getValue(){
		    return currentValue;
		  }

		  public void setValue(ImmutablePerson newValue){
		    this.currentValue = newValue;
		  }

		  public void add(int newValue){
		    this.currentValue = new ImmutablePerson(null, null, null, null);
		  }
		}

 		The Client class holds a reference to an ImmutableValue instance. 
	    Notice how it is possible to change that reference through both the setValue() and 
	  add() methods. Therefore, even if the Calculator class uses an immutable object internally,
	   it is not itself immutable, and therefore not thread safe. In other words:
	    The ImmutableValue class is thread safe, but the use of it is not.
	    This is something to keep in mind when trying to achieve thread safety through immutability.
	**/
/**
 * 2. 
 */
	
	
}
