
Object oriented is a programming paradigm based on the concepts of Objects which contains data as fields and executing code as procedures(methods.)
In object oriented programming, the code is made of objects which interact with each other. 
In my opinion , all programming is about changing state of data. Object oriented programming allows this changing of data through the concretely defined behaviours in a restrictive way(which is indeed Encapsulation).  

The features of Object oriented programming includes -> 

1) Objects and Classes -> 
i) Objects are nothing but entities which have a state , behaviour and Identity. 
	a) State represents the value of data fields in a particular objects. 
	b) Behaviour defines the different functions/methods/procedures of Object which act on the given data and change the state of Object. 
	c) Identity defines the unique identifier which separates the object from all other objects. Identity sometimes acts as blackbox for object and properties of the object are identified based on identity. Evven if two objects have same state and behaviour , identity is something which separates them apart. 

Objects are accessed somewhat like variables with their complex internal structure hidden.In many languages are effectively pointers, serving as actual references to a single instance of said object in memory within a heap or stack Objects are nothing but actual instances of a particular class defined.

ii) Classes are the representation of Objects which defines their state , and behaviour. It is a blueprint of an object which contains the infomration on data fields and procedures of the object.  

Each object is said to be an instance of a partocular class. Procedures in Object oriented are known as Methods and variables are knows as fields, members , attributes or properties. This leads to the following terms:
Class variables – belong to the class as a whole; there is only one copy of each one
Instance variables or attributes – data that belongs to individual objects; every object has its own copy of each one
Member variables – refers to both the class and instance variables that are defined by a particular class
Class methods – belong to the class as a whole and have access only to class variables and inputs from the procedure call
Instance methods – belong to individual objects, and have access to instance variables for the specific object they are called on, inputs, and class variables. 

In Java Different Ways to Create an Object -> 
1) Using new Keyword 
2) Using newInstance of reflection API 
3) By using Clone method 
4) By Deserialization 
5) Using newInstance on the Constructor. Ex-> 
		Constructor<ReflectionExample> constructor 
                = ReflectionExample.class.getDeclaredConstructor(); 
            ReflectionExample r = constructor.newInstance();
			
			
2) Encapsulation ->  Encapsulation refers to  bundling of data with procedure (or methods in OOP) which operated on them. The essence of Encapsulation is Data hiding from other object and restricting their access through defined procedures only. This restricts the unauthorized access which might change the state of object in unexpected ways. In Java , the encapsulation be achieved with restricting the access with private modifiers on field and defining getter and setters or any other method to access them. Direct access is restricted.

With encapsulation a data field can be defined as Read OR  Read/Write. 

Encapsulation reduces the system complexity and thus increase robustness in a way that encapsulated fields cannot be changed which leads to component not able to depend on the data (which is direct state of object) but on the methods encapsulating those data fields. There can be number of encapsulating methods on  one data field which allows to limit the interdependency between software components which indeed increases the robusteness. 

Encapsulation Rule 1 : Place operations (methods) and data on which these method acts upon in same class. this adheres to the principle of abstract data types. 
An abstract data type (ADT) is a mathematical model for data types. An abstract data type is defined by its behavior (semantics) from the point of view of a user, of the data, specifically in terms of possible values, possible operations on data of this type, and the behavior of these operations.

Encapsulation Rule 2 : Use responsibility driven design to determine grouping of Data and Operations into classes. Responsibility Driven Design is a design technique which defines and improves encapsulation by using Client Server model.It focuses on the contract by considering the actions that the object is responsible for and the information that the object shares. Both client and server in this design adheres to contract which indeed defines the behaviour of the object. The design should avoid dealing with details. The benefit is increases Encapsulation. 

Information Hiding Rule 1: Dont expose data items . Make all data item private and use getter-setters 

Information Hiding Rule 2: Dont expose differemce between stored data and derived data. Client only need to know that an object has attribute like speed which it needs to access. Use getSpeed() or speed() instead of calculateSpeed() since calculateSpeed tells that somehow speed is calculate from a data field. 

Information Hiding Rule 3 -> Client should remain isolated from Design decisions driving the selection of internal structure of class. Like Client shouldnt know that whether a primitive array is used in field or ArraysList is used or a LinkedList is used 

Information Hiding Rule 4 -> Dont expose implementation details of class. 

Important Note -> HIDING DATA IS NOT THE ONLY INTENT OF ENCAPSULATION. HIDING CRITICAL DESIGN DECISION AND DATA FOR IMPROVING SYSTEM MODULARITY ALSO COVERS ENCAPSULATION. THE CLIENT SHOULD BE ISOLATED FROM REQUIRING TO KNOW THE DESIGN TO USE THE MODULE. SINCE, MORE THE CLIENT KNOW ABOUT DESIGN DECISION , MORE IT WILL BE COUPLED WITH THE MODULE. 

3) Abstraction -> Abstraction is the process of hiding the internal implementation details and showing only functionality to client. Abstraction means using simple things to represent complexity. 

4) Inheritance -> Inheritance is the property by virtue of which an class acquires properties from a different class (which is defined as parent class). Of course inheritance is used for Code resuablity. The idea is to build classes on top of existing classes and reuse the functionalities of those classes. 
inheritance is defined as "IS-A" relationship which is known as Parent-child relation. 
Types of Inheritance -> 
a) Single Inheritance :: When a class inherits another class, it is known as a single inheritance. 
b) MultiLevel Inheritance :: When a class inherits a class which inherits another class. There is chain of inheritance. 
c) Hierarchical Inhertance :: When Two or more classes inheritance the same class. 
d) Mutiple Inheritance :: When one class inherits two or more classes is multiple inheritance. This is not supported through java through classes but is defined only through default methods of Interface. If a class extends two or more classes and all those parents classe shave some common methods then it is an ambiguity that which method will be called. Will it be first class's method or Second class's method. This is knows as Diamond Problem. 

With default methods(Which are defined in interfaces), we can have mutiple inheritance.  

e) hybrid inheritance :: when we have more  two or more types of Inheritance . 

5) Polymorphism -> It is the concept by which a single action is perfomed in different ways. It is a provision of using a single interfaces to represent entities of different types. Type of Polymorphism :: 
a) Ad hoc polymorphism: When we have same method signatures but the differentiation between them is the type of arguments passed. (Compile Time Polymorphism)

b) Parametric polymorphism: Concept is defined with use type parameters (OR generics) to write implementations generically without depending on the type of their data . A common example will be defining a List<T> of type T ,T can be integer , Double or String or any type. 

c) Subtyping (also called subtype polymorphism or inclusion polymorphism): when a name denotes instances of many different classes related by some common superclass.(Runtime Polymorphism)
