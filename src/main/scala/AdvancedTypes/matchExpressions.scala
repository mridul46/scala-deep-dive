package AdvancedTypes

/*
     What is a Match Expression?
          A Match Expression is Scala's version of a switch statement, but it is far more powerful.

          It can match:
          Values
          Types
          Case classes
          Lists
          Tuples
          Options
          Guards (conditions)

          Syntax:

          value match {
              case pattern1 => result1
              case pattern2 => result2
              case _        => default
          }
 */
object matchExpressions {
  def main (args:Array[String]):Unit={
  //basic Example
  val day = 2

    val result = day match {
      case 1 => "Monday"
      case 2 => "Tuesday"
      case 3 => "Wednesday"
      case _ => "Invalid"
    }

    println(result)

    //Match is an Expression
    //Unlike Java's switch, Scala's match returns a value.
    val age = 20

    val status = age match {
      case n if n >= 18 => "Adult"
      case _ => "Minor"
    }

    println(status)



    //Matching Strings
    val language = "Scala"

    language match {
      case "Java" => println("Java Developer")
      case "Scala" => println("Scala Developer")
      case "Python" => println("Python Developer")
      case _ => println("Unknown")
    }




    //Multiple Cases
    val grade = 'A'
    grade match {
      case 'A' | 'B' => println("Excellent")
      case 'C' => println("Good")
      case _ => println("Fail")
    }



    //Match with Guards: Guards add Extra conditions
    val age1 = 25
    age1 match {
      case x if x >= 18 => println("Adult")
      case _ => println("Minor")
    }



    //Matching Data Types
    def check(value: Any): Unit = value match {
        case i: Int => println(s"Integer: $i")
        case s: String => println(s"String: $s")
        case b: Boolean => println(s"Boolean: $b")
        case _ => println("Unknown")
      }
    check(100)
    check("Scala")
    check(true)





    //Match with Option
    val name: Option[String] = Some("Rahul")
    name match {
      case Some(value) => println(value)
      case None => println("No Name")
    }


    //match with List
    val list = List(1, 2, 3)
    list match {
      case Nil => println("Empty")
      case head :: tail => println(s"Head = $head")
                           println(s"Tail = $tail")
    }

    //Match with Tuples
    val employee = ("Rahul", 25)
    employee match {
      case (name, age) =>
        println(name)
        println(age)
    }


    //Match with Case Classes
    case class Student(name: String, age: Int)
    val student = Student("Rahul", 22)
    student match {
      case Student(name, age) =>
        println(name)
        println(age)
    }


    //Nested Pattern Matching
    val data = Some(List(1, 2, 3))
    data match {
      case Some(head :: tail) =>
        println(head)

      case _ =>
        println("No Data")
    }


    //Wildcard Pattern
    val x = 5
    x match {
      case 1 => println("One")
      case _ => println("Anything")
    }


    //Variable Binding
    val x1 = 100
    x1 match {
      case value => println(value)
    }
  }
}
