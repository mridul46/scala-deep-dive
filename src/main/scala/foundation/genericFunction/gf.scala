package foundation.genericFunction

import basics.ClassAndObjects.User


//Generic Function in Scala:
//A generic function is a function that can work with different types without rewriting the function for each type
//List is a generic data structure
// List[Int], List[String], List[User]

/*

    Generics allow you to write code that works with different data types without rewriting the same code multiple times.
    [A] --> it means A is a type parameter.
    List[A] --> it means the list can contain values of type A .
    note: A is not a specific data type.
          it is a placeholder for a type.
   def identity[A](value: A): A = {
     value
   }

   1. Generic functions accept ALL types
       def map[From,To](list:List[From])(update: From=>To):List[To]

       map[String,Int](List(...))(....)
       map[User,Address](List(...))(...)

   2. All types must be treated IN THE SAME WAY
      def map[From,To](list:List[From])(update:From =>To):List[To]=
        list match{
            case ints:List[Int] =>...
            case strings:List[String]=>...
            case users:List[User]=>...
            case _               => ...
       }

     def format[A](value:A):String=
         value match{
          case x:String => x.toLowerCase
          case x:Double => truncate(2,x)
          case _        =>"N/A"
      }
     call should be like format("Blue")

      In generic function, all types must be treated in the same way


     Ad hoc polymorphism
       ad hoc polymorphism means the same function name or operator can behave differently depending on the types of the arguments.

    what is identity function?
    An identity function is a function that returns the same value it receives as input , withouit changeing it .
    its simply: input=output
     def identity(x: Int): Int = {
       x
     }

     object Main {
       def main(args: Array[String]): Unit = {
        println(identity(10))    // 10
         println(identity(100))   // 100
      }
     }

 */
class gf {
  def map[A](list: List[A], update: A => A): List[A]={
    list.map(update)
  }


}
def truncate(value: Double, decimals: Int): String = {
  val factor = math.pow(10, decimals)
  (math.floor(value * factor) / factor).toString
}
def format[A](value: A): String =
  value match {
    case x: String => x.toLowerCase
    case x: Double => truncate(x, 2)
    case _ => "N/A"
  }

object gf {
   def main(args:Array[String]):Unit={
     val gf=new gf
     
     println(gf.map(List(1, 2, 3, 4), (x: Int) => x + 1))
     println(gf.map(List("Hello","World"),(x:String)=>x.reverse))

    // val users=List(User("Jhon",23),User("Eda",37),User("Bob",18))
     //gf.map[User](users,(user:User)=>user.name) //type mismatch
     println(format("BLUE"))
  }
}
