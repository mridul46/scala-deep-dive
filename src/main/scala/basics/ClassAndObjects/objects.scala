package basics.ClassAndObjects

//Singleton Object
/*
    Scala is more object-oriented than java because in scala ,it has static members.
    Scala has singleton objects. A singleton is a class that can have only one instance, i.e., Object.
    You create singleton using the keyword object instead of class keyword
 */
object DatabaseConnection {
  // Fields act like static constants/variables
  val url = "jdbc:mysql://localhost:3306/mydb"
  private var connectionCount = 0

  // Methods act like static methods
  def connect(): Unit = {
    connectionCount += 1
    println(s"Connected to $url. Active connections: $connectionCount")
  }
}

//apply method (factory pattern)

/*
   The most common use case for a companion object is providing a factory method using Scala's special apply method. When you call an object like a function Object(args),
   Scala automatically translates it to Object.apply(args).
   This is why you don't need the new keyword to create Lists, Vectors, or Case Classes in Scala
 */
class Student(val name: String, val grade: Char)

object Student {
  // Factory method
  def apply(name: String, score: Int): Student = {
    val grade = if (score >= 90) 'A' else 'B'
    new Student(name, grade) // Calls the actual class constructor
  }
}
object objects{
  def main(args:Array[String]):Unit ={
    DatabaseConnection.connect() // Output: Connected to jdbc:mysql://localhost:3306/mydb. Active connections: 1
    println(DatabaseConnection.url)


    // Usage:
    // No 'new' keyword! This calls Student.apply("Bob", 95) under the hood.
    val bob = Student("Bob", 95)
    println(bob.grade) // Output: A
  }
}
