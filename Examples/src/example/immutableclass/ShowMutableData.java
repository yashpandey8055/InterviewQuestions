package example.immutableclass;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ShowMutableData {

	/**
	 * In this Method we take a mutable object and try to change its data 
	 * We will change the mutable fields inside the object and see that it changes the data in object itself
	 */
	public void show() {

		//Create Instance of Date Of birth
		//which is 9th july 1992
		Calendar cal = Calendar.getInstance();
		cal.set(1992, 0, 9);
		Date dob = cal.getTime();
		
		//Create Map of Marks
		Map<String,Integer> marks = new HashMap<>();
		marks.put("Physics", 90);
		marks.put("Chemistry",100);
		
		//Mutable class Object 
		MutablePerson imPerson = new MutablePerson("Yash", "EC16",dob, marks);
		
		/**
		 * Now try to access Marks and Date of Birth from Immutable person and try to change it 
		 */
		Map<String, Integer>  copyofMarks = imPerson.getMarks();
		copyofMarks.put("Maths", 102);
		Date copyofdob = imPerson.getDateOfBirth();
		cal.set(2000, 8, 19);
		copyofdob.setTime(cal.getTimeInMillis());
		
		/**
		 * The Update Copy of Marks and Dob of Birth
		 * 
		 * 	ACCESSED FROM OBJECT
			{Maths=102, Chemistry=100, Physics=90}
			Tue Sep 19 20:39:52 IST 2000
		 */
		System.out.println("ACCESSED FROM OBJECT");
		System.out.println(copyofMarks);
		//Output -> Tue Jan 12 20:35:08 IST 1993
		System.out.println(copyofdob);
		
		System.out.println("================================================");
		System.out.println("ORIGINAL");
		
		/**The original Object whose data has been changed and is same as the changes we made 
			ORIGINAL
			{Maths=102, Chemistry=100, Physics=90}
			Tue Sep 19 20:48:43 IST 2000
		**/
		System.out.println(imPerson.getMarks());
		System.out.println(imPerson.getDateOfBirth());
	}

}
