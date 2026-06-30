package basics.datatype

/*
In Scala, Type Hierarchy means how all data types are organized in a parent-child structure.
                     Any
                   /   \
               AnyVal  AnyRef
                 |        |
      ----------------    |
      |  |  |  |  |       |
    Int Double Float ... Object Types
                           |
                        String,
                        List,
                        Array etc.

                 Null
                   |
                Nothing
 */
object TypeHierarchy {
  def main(args:Array[String]): Unit = {


    /*
       1.  Any (Top Parent Type)
       -Any is the root of all types in Scala
       -Everything in Scala inherits from Any.
     */
    val a:Any=10;
    val b:Any="Hello"
    val c:Any= true
    println(s"the result are ${a}, ${b}, ${c}")
    //Any contains common methods like: .equal(), .hashCode(),.toString()



   /*
    2. AnyVal (Value Types)
     -AnyVal stores primitive/value data.
     -These are fast and memory efficient.
     -Types under AnyVal:

     Int
     Double
     Float
     Long
     Short
     Byte
     Char
     Boolean
     Unit
    */

    val num:Int =100;
    val pi:Double=3.14
    val flag:Boolean=false
    println(s"result will be $num $pi $flag")

    /*
     3.AnyRef - Reference Types
      -all classes and objects come under AnyRef
      -Example: -String,
                -List
                -Array
                -User defined classes
     */

    val name:String="Mridul Hussain"
    println(name.length)
    println(name.toUpperCase)

    //User defined class
    class Student(val name:String, val age:Int)
    val s1=new Student("Mridul",11)
    println(s1.name)
    println(s1.age)



    //4. Null - it works only with reference types
     val s:String =null
     println(s)

    //Error because Int belongs to AnyVal
    //val x:Int=null
    /*
     Why scala avoids null
     scala prefers:
     Option
     Some
     None
     */
    //Safer approach
    val name1:Option[String]=None
    println(name1)

    /*
    5. Nothing ->Bottom Type
       Nothing is below every type
       Used for:
       -Exceptions
       -infinite loops
       -failed computations
     */

    def divide(a: Double, b: Double): Double = {
      if (b == 0) throw new ArithmeticException("Divide by Zero")
      else (a / b)
    }
    println(divide(3,1))

    /*
    6. Unit ->Equivalent to Java void.
     */
    def greet():Unit={
      println("Welcome")
    }
    greet()
  }
}
