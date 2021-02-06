package example.singletonclass;

/**
 * Other simple Implementations See class {@link MultithreadedSingletonObjectCreation}@ 
 * 
 * Holder is said to be best with no args constructors. 
 * With thread safety and lazy initialization
 * @author Yash
 *
 */
public class SynchronizedSingletonObject {
	
	private static SynchronizedSingletonObject INSTANCE;
	private static volatile SynchronizedSingletonObject VOLATILE_INSTANCE;
	
	/**
	 * A simple implementation of Singleton class
	 * @return
	 */
	public static SynchronizedSingletonObject getInstanceSimple() {
		if(INSTANCE == null) {
			INSTANCE = new SynchronizedSingletonObject();
		}
		return INSTANCE;
	}
	
	/**
	 * Synchronized getInstance methods for Multithreading. 
	 * It makes sure the threads are synchronized and will put a intrinsic lock if 
	 * any  thread is accessing and it makes sure the only one instance is created. 
	 * Does the Job but takes a performance hit since even the read calls are synchronized 
	 * . We dont want that. We need Read calls to go through without any lock. 
	 * Since reads will make up the bulk of our calls (remember, instantiation only happens on the first call), 
	 * we will incur an unnecessary performance hit by synchronizing the entire method.
	 * @return
	 */
	public static synchronized SynchronizedSingletonObject getInstanceMethodSynchronized() {
		if(INSTANCE == null) {
			INSTANCE = new SynchronizedSingletonObject();
		}
		return INSTANCE;
	}
	
	/**
	 * Good! It does the job, Now read calls wont be synchronized but here is the thing , 
	 * All threads who race through critical condition and arruve at condition INSTANCE == NULL 
	 * and then first thread (or second thread, whosoever arrives first) will acquire the lock. 
	 * Now when this completes , the other thread(who was waiting) will create its own instance. 
	 * So we are back to square one. 
	 * @return
	 */
	public static SynchronizedSingletonObject getInstancedSynchronizedBlock() {
		
		if(INSTANCE == null) {
			synchronized(SynchronizedSingletonObject.class) {
				INSTANCE = new SynchronizedSingletonObject(); 
			}
		}
		return INSTANCE;
	}

	/**
	 * Here we issue another check from inside the block
	 * . If the INSTANCE member has already been set, we’ll skip initialization. This is called double-checked locking.
	 * This solves our problem of multiple instantiation. 
	 * But once again, our solution has presented another challenge. 
	 * Other threads might not “see” that the INSTANCE member has been updated
	 * . This is because of how Java optimizes memory operations.
	 * Thread copy variables from main memory to CPU cache and do read write operations of CPU cache only. 
	 * Changes are written and read from CPU cache only. 
	 * Two threads both running on different cores have different CPU caches. The changes from one thread will 
	 * not be reflected into another cache which might create problem for us. 
	 * 
	 * So we will use volatile to tell compiler to use main memory directly. 
	 * @return
	 */
	public static SynchronizedSingletonObject getInstancedSynchronizedBlockDoubleChecked() {
		
		if(INSTANCE == null) {
			synchronized(SynchronizedSingletonObject.class) {
				if(INSTANCE == null) {
					INSTANCE = new SynchronizedSingletonObject(); 
				}
			}
		}
		return INSTANCE;
	}
	
	/**
	 * This will tell compiler to directly take from main memory. 
	 * Now this all takes a performance hit , since we are going to main memory all the time. 
	 * Because we are bypassing the CPU cache, we will take a performance hit each time we operate on the 
	 * volatile INSTANCE member — which we do four times. We double-check existence (1 and 2), set the value (3), 
	 * and then return the value (4).One could argue that this path is the fringe case as we only create the
	 *  instance during the first call of the method. Perhaps a performance hit on creation is tolerable.
	 *   But even our main use-case, reads, 
	 * will operate on the volatile member twice. Once to check existence, and again to return its value.
	 * @return
	 */
	public static SynchronizedSingletonObject getInstancedSynchronizedBlockDoubleCheckedVolatile() {
		
		if(VOLATILE_INSTANCE == null) {
			synchronized(SynchronizedSingletonObject.class) {
				if(VOLATILE_INSTANCE == null) {
					VOLATILE_INSTANCE = new SynchronizedSingletonObject(); 
				}
			}
		}
		return VOLATILE_INSTANCE;
	}
	
	/**
	 * Since the performance hit is due to operating directly on the volatile member, 
	 * let’s set a local variable to the value of the volatile and operate on the local variable instead. 
	 * This will decrease the number of times we operate on the volatile, thereby reclaiming some of our lost performance.
	 *  Note that we have to set our local variable again when we enter the synchronized block.
	 *  This ensures it is up to date with any changes that occurred while we were waiting for the lock.
	 * @return
	 */
	public static SynchronizedSingletonObject getInstaceSynchronizedBlockDoubleCheckedVolatilewithLocalVarible() {
		SynchronizedSingletonObject instance = VOLATILE_INSTANCE;
		if(instance == null) {
			synchronized(SynchronizedSingletonObject.class) {
				instance = VOLATILE_INSTANCE;
				if(instance == null) {
					VOLATILE_INSTANCE = instance = new SynchronizedSingletonObject();
				}
			}
		}
		return instance;
	}

}
