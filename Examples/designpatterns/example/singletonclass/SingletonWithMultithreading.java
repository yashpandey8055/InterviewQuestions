package example.singletonclass;

public class SingletonWithMultithreading {

	public void problemWithSimpleSingleton() {
		SimpleSingletonThread sing1 = new SimpleSingletonThread("Yash", 100);
		SimpleSingletonThread sing2 = new SimpleSingletonThread("Sakshi", 300);
		Thread t1 = new Thread(sing1);
		Thread t2 = new Thread(sing2);
		t1.start();
		t2.start();
	}
	
	public static void  main(String[] args) {
		SingletonWithMultithreading test = new SingletonWithMultithreading();
		test.problemWithSimpleSingleton();
	}
	
	
/**
 * Notes -> 
 * 	/**
 	The problem with Simple thread in singleton is , We dont know which Instance is created . 
	  Its a race condition. 
	    A race condition is a concurrency problem that may occur inside a critical section.
	    A critical section is a section of code that is executed by multiple threads
	    and where the sequence of execution for the threads makes a difference in the result of 
	    the concurrent execution of the critical section.
		When the result of multiple threads executing a critical section may differ depending on the 
		sequence in which the threads execute, the critical section is said to contain a race condition. 
		The term race condition stems from the metaphor that the threads are racing through the critical section, 
		and that the result of that race impacts the result of executing the critical section.
	  
	  Single both threads counts till 100 and then create instance, 
	  we dont know who wins the Race condition throght critical section and creates instance. 
	  We can have two Instances of Sakshi and Yash (If both thread ends at same time) 
	  OR One instance only of Yash (When thread one wins)  OR One instance only of Sakshi (When thread two wins)
	  
	  To solve this race condition in Singleton Class we needs proper synchronization 

 
 */
	
/**
	 * There is a lot of nuance around implementing a singleton. The holder pattern can not be used in many situations. 
	 * And IMO when using a volatile - you should also use a local variable. 
	 * Let's start at the beginning and iterate on the problem. You'll see what I mean.

The first attempt might look something like this:

public class MySingleton {

     private static MySingleton INSTANCE;

     public static MySingleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MySingleton();
        }
        return INSTANCE;
    }
    ...
}
Here we have the MySingleton class which has a private static member called INSTANCE, 
and a public static method called getInstance(). The first time getInstance() is called, 
the INSTANCE member is null. The flow will then fall into the creation condition and create a new instance of 
the MySingleton class. Subsequent calls to getInstance() will find that the INSTANCE variable is already set, and
 therefore not create another MySingleton instance. This ensures there is only one instance of 
 MySingleton which is shared among all callers of getInstance().


But this implementation has a problem. Multi-threaded applications will have a race condition on the creation of the
 single instance. If multiple threads of execution hit the getInstance() method at (or around) the same time, 
 they will each see the INSTANCE member as null. This will result in each thread creating a new MySingleton instance
  and subsequently setting the INSTANCE member.

private static MySingleton INSTANCE;

public static synchronized MySingleton getInstance() {
    if (INSTANCE == null) {
        INSTANCE = new MySingleton();
    }
    return INSTANCE;
}
Here we’ve used the synchronized keyword in the method signature to synchronize the getInstance() method. 
This will certainly fix our race condition. Threads will now block and enter the method one at a time. But it 
also creates a performance problem. Not only does this implementation synchronize the creation of the single instance;
 it synchronizes all calls to getInstance(), including reads. Reads do not need to be synchronized as they simply return 
 the value of INSTANCE. Since reads will make up the bulk of our calls (remember, instantiation only happens on the first call),
  we will incur an unnecessary performance hit by synchronizing the entire method.

private static MySingleton INSTANCE;

public static MySingleton getInstance() {
    if (INSTANCE == null) {
        synchronize(MySingleton.class) {
            INSTANCE = new MySingleton();
        }
    }
    return INSTANCE;
}
Here we’ve moved synchronization from the method signature, to a synchronized block that wraps the 
creation of the MySingleton instance. But does this solve our problem? Well, we are no longer blocking
 on reads, but we’ve also taken a step backward. Multiple threads will hit the getInstance() method at
  or around the same time and they will all see the INSTANCE member as null.

They will then hit the synchronized block where one will obtain the lock and create the instance. 
When that thread exits the block, the other threads will contend for the lock, and one by one each
 thread will fall through the block and create a new instance of our class. So we are right back where we started.

private static MySingleton INSTANCE;

public static MySingleton getInstance() {
    if (INSTANCE == null) {
        synchronized(MySingleton.class) {
            if (INSTANCE == null) {
                INSTANCE = createInstance();
            }
        }
    }
    return INSTANCE;
}
Here we issue another check from inside the block. If the INSTANCE member has already been set,
 we’ll skip initialization. This is called double-checked locking.

This solves our problem of multiple instantiation. But once again, our solution has presented another 
challenge. Other threads might not “see” that the INSTANCE member has been updated. This is because of
 how Java optimizes memory operations.

Threads copy the original values of variables from main memory into the CPU’s cache. Changes to
 values are then written to, and read from, that cache. This is a feature of Java designed to 
 optimize performance. But this creates a problem for our singleton implementation. A second
  thread — being processed by a different CPU or core, using a different cache — will not see the
   changes made by the first. This will cause the second thread to see the INSTANCE member as null
    forcing a new instance of our singleton to be created.

private static volatile MySingleton INSTANCE;

public static MySingleton getInstance() {
    if (INSTANCE == null) {
        synchronized(MySingleton.class) {
            if (INSTANCE == null) {
                INSTANCE = createInstance();
            }
        }
    }
    return INSTANCE;
}
We solve this by using the volatile keyword on the declaration of the INSTANCE member. 
This will tell the compiler to always read from, and write to, main memory, and not the CPU cache.

But this simple change comes at a cost. Because we are bypassing the CPU cache, we will
 take a performance hit each time we operate on the volatile INSTANCE member — which we do
  four times. We double-check existence (1 and 2), set the value (3), and then return the
   value (4). One could argue that this path is the fringe case as we only create the instance 
   during the first call of the method. Perhaps a performance hit on creation is tolerable. But 
   even our main use-case, reads, will operate on the volatile member twice. Once to check existence,
    and again to return its value.

private static volatile MySingleton INSTANCE;

public static MySingleton getInstance() {
    MySingleton result = INSTANCE;
    if (result == null) {
        synchronized(MySingleton.class) {
            result = INSTANCE;
            if (result == null) {
                INSTANCE = result = createInstance();
            }
        }
    }
    return result;
}
Since the performance hit is due to operating directly on the volatile member, let’s set a 
local variable to the value of the volatile and operate on the local variable instead. This will
 decrease the number of times we operate on the volatile, thereby reclaiming some of our lost performance. 
 Note that we have to set our local variable again when we enter the synchronized block. This ensures 
 it is up to date with any changes that occurred while we were waiting for the lock.
	 */
}
