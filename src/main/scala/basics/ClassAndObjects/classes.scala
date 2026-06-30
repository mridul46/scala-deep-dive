package basics.ClassAndObjects


/*
   A class is a blueprint for object .
   it uses the "new" keyword
 */
class User {
  // Fields (Variables)
  var name: String = "Guest"
  val id: Int = 101

  // Method (Behavior)
  def greet(): Unit = {
    println(s"Hello, my name is $name and my ID is $id.")
  }
}

//Primary Constructors
/*
    In Scala, the entire body of the class is the constructor.
    You pass constructor parameters directly next to the class name.
 */
class Person(val name: String, var age: Int) {
  // This code runs automatically when an object is created
  println(s"Creating a Person instance for $name")

  def introduce(): Unit = println(s"Hi, I'm $name and I am $age years old.")
}


//Auxiliary Constructors (Overloading Constructors)
/*
   If you need multiple ways to initialize a class, you can define secondary constructors using the def this(...) syntax.
    Rule: Every auxiliary constructor must call a previously defined constructor (ultimately calling the primary constructor) on its very first line.
 */
class Pizza(val size: String, val crust: String) {

  // Auxiliary Constructor for when only size is provided
  def this(size: String) = {
    this(size, "Regular Crust") // Calls the primary constructor
  }
}

/*
  Companion Objects
     The companion object can access private fields and methods of the class, and vice versa.
     It is widely used to create factory methods using the apply method.
 */
class Car(val model: String, val year: Int)

object Car {
  // Factory method allowing us to drop the 'new' keyword
  def apply(model: String, year: Int): Car = new Car(model, year)

  def totalWheels: Int = 4 // Behaves like a static method
}
/*
    Case Classes (The Functional Paradigm)
    When you just want a class to hold immutable data, Scala provides a special construct called a case class.

    When you add the word case before a class, Scala automatically writes a mountain of boilerplate code for you under the hood:
    1. All parameters are automatically val (immutable fields) by default.
    2. An apply method is generated (you never need the new keyword to create an instance).
    3. Sensible default methods like toString, equals, and hashCode are automatically implemented.
    4. It sets up the class to work seamlessly with Pattern Matching.
 */
case class Book(title: String, author: String)


//Abstract class
/*
  An Abstract Class in Scala is a class that cannot be instantiated on its own and is designed to be extended by subclasses.
  It serves as a base blueprint that can contain both abstract members (fields and methods without any implementation) and concrete members (fields and methods with implementation).
 */

abstract class Animal {
  // Abstract field (no initial value)
  val species: String

  // Abstract method (no body)
  def makeSound(): Unit

  // Concrete method (has implementation)
  def sleep(): Unit = {
    println("Zzz...")
  }
}

class Dog extends Animal {
  // Implementing the abstract field
  val species: String = "Canine"

  // Implementing the abstract method
  def makeSound(): Unit = {
    println("Bark! Bark!")
  }
}
object classes {
   def main (args:Array[String]): Unit = {
     val user1 = new User()
     user1.greet() // Output: Hello, my name is Guest and my ID is 101.

     user1.name = "Alice" // Changing a 'var' field
     // user1.id = 202   // Error: 'val' fields are immutable (read-only)

    //Primary Constructors
     val person1= new Person("Mridul",26)
     person1.introduce()


     //Auxiliary constructors
     val customPizza= new Pizza("Large","Thin crust")
     val  defaultPizza= new Pizza("Medium")
     println(customPizza.size )
     println(defaultPizza.crust)


     // Usage:
     val myCar = Car("Tesla Model 3", 2026) // Notice: No 'new' keyword required!
     println(Car.totalWheels) // Accessing static-like member


     val book1 = Book("Programming in Scala", "Martin Odersky")
     val book2 = Book("Programming in Scala", "Martin Odersky")

     println(book1) // Beautiful output: Book(Programming in Scala, Martin Odersky)
     println(book1 == book2) // Returns true (compares values, not memory addresses)


     val myDog = new Dog()
     myDog.makeSound() // Output: Bark! Bark!
     myDog.sleep()     // Output: Zzz...
   }
}
