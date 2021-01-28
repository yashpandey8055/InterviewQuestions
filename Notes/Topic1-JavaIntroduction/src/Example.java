package io.example.topic1.simple;

/**
 * A starter Example of Java application. 
 * Which runs prints a hello world on Output Console. 
 * @author Yash
 *
 */
public class Example {
	
	/**
	 * All Java programs requires a main function which is entry point to the 
	 * application. 
	 * The Main function here is same as one we define in c or c++. 
	 * 
	 * 1) public -> It is an access modifier which tells that this function can be accessed
	 *  publically. 
	 * There are more access modifiers named -> public, private , protected and no access modifier. 
	 * 
	 * Note -> The main function should always define access modifier as public.If its private/protected/None Defined, 
	 * the function wont run as Java application and it will throw an error stating -> 
	 * "Error: Main method not found in class io.example.simple.Example, please define the main method as:
     * public static void main(String[] args)"
     * Thus main function should always be defined as public. 
     * 
     * 2) static -> Static is the keyword in java and to access a static method, you dont need to create an object of the class. 
     * So here in the Example class, there is no need to create Object of Example class and main method can be accessed with only 
     * Example.main(). This is done because lets say if the javaw.exe (or java.exe) happens to call the main method without static , 
     * It then need to instantiate Example class with a constructor. What argument java will pass to a parameterized constructor 
     * is an ambiguity. Plus its quite convenient to use it as static instead of using any other way for application entry point.  
     * 
     * 3) void -> It should not return anything. The main reason is , even if main method completes doesn't generally mean 
     * a program is completed. Because may be some thread is running. So its convenient to use 
     * System.exit(int status) - Equivalent to Runtime.getRuntime().exit(status) if a return value is expected to be returned to 
     * calling function. 
     * If main spawns new threads , then a return value doesnt make sense because these threads keep running ,
     *  even after main method is fully executed.
     *  
     * 4) main -> Its just a convention to use "main" as the name since the days of C and C++
     * 
     *  5) args -> These are runtime arguments passed to the java application. 
     *  Ex -> $java Example 10 20 32 45
     *  
     *  args[0] -> 10
     *  args[1] -> 20
     *  args[2] -> 32
     *  args[3] -> 45
     *  
     * 
     * FOOTNOTE -> From the Java Language Specification on "Execution - Virtual Machine Start-Up" (§12.1.4):
	 *	"The method main must be declared public, static, and void. It must accept a single argument that is an array of strings."
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Hello Java world!!");
	}

}
