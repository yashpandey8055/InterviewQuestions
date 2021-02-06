package example.singletonclass;

public class SimpleSingletonThread implements Runnable{
			private String name;
			private Integer marks;
			
			SimpleSingletonThread(String name,Integer marks){
				this.name = name;
				this.marks = marks;
			}
			@Override
			public void run() {
				for(int i=0;i<100;i++) {
					/**
					 * Just let threads count till 100 and then create Simple Object
					 */
				}
				SimpleSingletonObject object = SimpleSingletonObject.getInstance(name, marks);
				System.out.println(object.getName()+" "+object.getMarks());
			}
			
		}
