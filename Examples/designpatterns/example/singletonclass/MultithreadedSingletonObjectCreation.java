package example.singletonclass;

public class MultithreadedSingletonObjectCreation {
	
	
	private String name;
	public String getName() {
		return name;
	}

	public Integer getMarks() {
		return marks;
	}

	private Integer marks;
	
	private MultithreadedSingletonObjectCreation(String name , Integer marks) {
		this.name = name;
		this.marks = marks;
	}
	
	public MultithreadedSingletonObjectCreation getInstance(String name, Integer marks, TypeOfSingletonCreation type) {
		switch(type) {
			case EAGER : return EagerSingleton.getInstance();
			case LAZY : return LazySingleton.getInstance();
			case HOLDER : return Holder.getInstance();
			default: return null;
		}
	
	}
	/**
	 * There are four ways of creating Singleton Object. 
	 */
	
	/**
	 * 1. Eager Initialization
	 */
	public static class EagerSingleton{
		private static String name;
		private static Integer marks;
		
		static {
			name = "Yash";
			marks = 190;
		}
		private static final MultithreadedSingletonObjectCreation INSTANCE = new MultithreadedSingletonObjectCreation(name,marks);

		public static MultithreadedSingletonObjectCreation getInstance() {
			return INSTANCE ;
		}
		
	}
	
	/**
	 * 2. Lazy Initialization (thread Safe)
	 */
	public static class LazySingleton{
		private static String name;
		private static Integer marks;
		static {
			name = "Yash";
			marks = 190;
		}
		private static volatile MultithreadedSingletonObjectCreation INSTANCE = null;
		
		public static MultithreadedSingletonObjectCreation getInstance() {
			if(INSTANCE == null) {
				return new MultithreadedSingletonObjectCreation(name, marks);
			}
			return INSTANCE;
		}
	}
	
	/**
	 * 3. Holder Pattern (The best one)
	 */
	public static  class Holder {
		
		private static class HoldSynchronizedObject{
			private static String name;
			private static Integer marks;
			static {
				name = "Yash";
				marks = 190;
			}
			private static final MultithreadedSingletonObjectCreation INSTANCE = new MultithreadedSingletonObjectCreation(name,marks);
		}
		
		public static MultithreadedSingletonObjectCreation getInstance() {
			return HoldSynchronizedObject.INSTANCE;
		}
		
	}
	/**
	 * Enum Pattern -> Here instead of Singleton class ,we create an enum at compile time , 
	 * and instance is created and used throughout the application.
	 * @author Yash
	 *
	 */
	 public enum EnumSynchronizedSingletonObject{
		 INSTANCE("Yash",100);
		 
		 Integer marks;
		 String name;
		 private EnumSynchronizedSingletonObject(String name , Integer marks) {
			 this.name = name;
			 this.marks = marks;
		 }
	 }
}
