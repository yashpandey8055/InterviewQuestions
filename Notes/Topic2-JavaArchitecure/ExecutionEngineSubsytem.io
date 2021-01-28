ExecutionEngine is the main component of JVM which actually executed the code. 
Execution engine executes the byte code which is assigned to the run time data areas in JVM via class loader. Java Class files are executed by the execution engine. 
Execution Engine consists of three main Components :

1) Interpreter -> It interprets the compiled ByteCode into machine code and executes them in sequential manner. This component runs the compiled Java class which is supplied in command line arguments. 

2) JIT compiler -> opposite to what interpreter does which is pretty much interpreting methods and bytecodes again even if they were interpreted before , JIT compiler does interpretation at runtime from bytecode to native code (machine code). For a compiled method, the JVM directly calls the compiled code, instead of interpreting it. 
The Execution Engine will be using the help of the interpreter in converting byte code, but when it finds repeated code it uses the JIT compiler, which compiles the entire bytecode and changes it to native code. This native code will be used directly for repeated method calls, which improve the performance of the system.
Profiler: This is a tool which is the part of JIT Compiler is responsible to monitor the java bytecode constructs and operations at the JVM level.


3) Garbage Collection -> It is a daemon thread which keeps on executing and manages memory for Java application.