package AdvancedTypes


/*
    A Union Type allows a variable to hold one of multiple possible types.
     It is written using the | (pipe) operator.
      A | B

    This means:The value can be either type A or type B.
 */


/*
     Why Use Union Types?
     Suppose a function can return either:
                                          an Int or a String

     Without union types, you might use:
     def getValue(flag: Boolean): Any =
       if (flag) 100 else "Scala"

     The return type is Any, which loses type safety.

     With union types:

     def getValue(flag: Boolean): Int | String =
       if (flag) 100 else "Scala"

     Now the compiler knows the result is either Int or String, not any arbitrary type.
 */


/*
      Advantages
      ✅ More type-safe than Any
      ✅ Eliminates unnecessary wrapper classes
      ✅ Expresses intent clearly
      ✅ Works well with pattern matching
      ✅ Reduces boilerplate
 */
object unions {
  def main(args:Array[String]):Unit={
    val data: Int | String =100
    println(data)


    //Function Returning a Union Type
    def getUser(id: Int): String | Int =
      if (id == 1)
        "Rahul"
      else
        404

    println(getUser(1)) //Rahul
    println(getUser(2)) //404


    //Pattern Matching with Union Types:
    def printValue(value: Int | String): Unit =
      value match {
        case n: Int => println(s"Integer: $n")
        case s: String => println(s"String: $s")
      }
    printValue(100) //Integer: 100
    printValue("Scala")  //String: Scala


    //Multiple Types: A union can include more than two
    type Result=Int| String | Boolean
    val x: Result = true
    val y: Result = 100
    val z: Result = "Scala"
    println(s"Boolean : $x ; Int : $y ; String : $z ")


    //type alias :
    type Id = Int | String
    val id1: Id = 101
    val id2: Id = "EMP101"
    println(id1)
    println(id2)


    //Backend example
    //Suppose an API accepts either:
    //Numeric employee ID
    //Employee email
    type EmployeeIdentifier = Int | String

    def findEmployee(id: EmployeeIdentifier): Unit =
      id match {
        case empId: Int =>
          println(s"Searching by ID: $empId")

        case email: String =>
          println(s"Searching by Email: $email")
      }

    findEmployee(101) //Searching by ID: 101
    findEmployee("rahul@example.com") //Searching by Email: rahul@example.com


    //Union Types with Case Classes
    case class Admin(name: String)
    case class User(name: String)

    type Person = Admin | User

    def greet(person: Person): Unit =
      person match {
        case Admin(name) =>
          println(s"Welcome Admin $name")

        case User(name) =>
          println(s"Welcome User $name")
      }

    greet(Admin("Rahul"))  // Welcome Admin Rahul
    greet(User("Amit"))   //Welcome User Amit

    //Union Types vs Traits

    //Without union types:
//    trait Shape
//
//    case class Circle(radius: Double) extends Shape
//    case class Square(side: Double) extends Shape
//
//    def area(shape: Shape): Double = ???

    //with union types
    case class Circle(radius: Double)
    case class Square(side: Double)

    def area(shape: Circle | Square): Double =
      shape match {
        case Circle(r) => Math.PI * r * r
        case Square(s) => s * s
      }
    println(area(Circle(12)))
    println(area(Square(12)))


    //union types in collection
    val collection: List[Int | String] = List(1, "two", 3, "four")

    collection.foreach {
      case i: Int => println(s"Integer: $i")
      case s: String => println(s"String: $s")
    }
  }
}
