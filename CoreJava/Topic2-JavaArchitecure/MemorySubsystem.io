
Java memory susbsytem is divided into 5 type of Memory spaces :

1) Heap 
2) Stack 
3) Program Counter (PC) Register
4) Method Area 
5) Native Method stack 



HEAP -> Heap is the space in JVM which is used for creating new Object of referenced classes at runtime. New Object created always resides in Heap Space and 
their references are stored in stack. Heap spaces is divided into two parts along with with Reserved spaces : 
a) Young generation : It is the spaces where newly created object resides. Young generation is further divided into 3 parts :: 
   i) Eden Spaces -> This is the spaces where newly created objects actually resides. 
   ii) Survivor Spaces 1 and Survivor Space 2 -> This is the place where objects are moved from Eden spaces after a Minor GC is executed. When Eden spaces fills up , a minor GC moves all objects from Eden to one of the Survivor Space. 
   
  The size of Young generation is defined by -XX:maxNewSize (Along with Reserved space) and -XX:NewSize (Only for Eden and two survivor Space)
  
b) Old generation : It is the spaces where objects which survived many rounds of GC (Minor) resides. The objects from this space are collected after a Major GC. 
	A threshold is set for young generation object and when that age is met, the object gets moved to the old generation. Eventually the old generation needs to be collected. This event is called a major garbage collection
  
  Major GC vs Minor GC :: 
  Minor GC runs when there is not enough space in Eden Space and this minor GC moves the Object from Eden space to Survivor Spaces. 
  Major GC runs when Older generation starts to fill up. 
  
  Runtime arguments -> 
  a) -XMx -> Total Heap memory with Young generation, Old generation and Two Reserved Spaces 
  b) -Xms -> Total Heap memory with Young generation and Old generation Only. 
  
  
Stack -> Stack is the memory space where all methods and their local variables are initiated and used when a method is called. For each thread, there is a different stack memory . When a method is called, the block is loaded as frame into the stack memory of thread and local variables are initialized and refernces are created which points to objects in heap space. If another method is called from this block os method , a new frame is created and execution engine executes the block of code. Once the values is returned from method OR block is finished executing , this frame is deleted and the Program Counter register then points to line from which the execution went to other method. 

a)The size of the stack will vary as methods and functions create and delete local variables as needed.
b) Memory is allocated and then subsequently freed without you needing to manage the memory allocation.
c) Stack has size limits, which can vary according to the operating system you use.
d) Variables that are stored on the stack exist for as long as the function that created them are running. 


c) PC register -> It is also associated by its thread. It basically is a address of current instruction is being executed. Since each thread some sets of method which is going to be executed depends upon PC Register. It has some value for each instruction and undefined for native methods. It is usually for keep tracking of instructions.

d) Method Area -> Its is the memory space which is shared amongst all threads. Method area is created at JVM startup and it containes all class details and details of their fields and static variable details. It also maintains Runtime contants pools which contains constant table of each class file which is used at the time of linking of class files in classloading subsystem. . It contains all literals defined at compiled time and references which is going to be solved at runtime.


  