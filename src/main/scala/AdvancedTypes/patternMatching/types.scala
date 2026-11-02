package AdvancedTypes.patternMatching
import java.time.LocalTime

/*
     1. what is a Typed pattern?
     A typed pattern matches a value based on its type
     case variable: Type=>result

 */
object types {
  def main(args:Array[String]):Unit={
    def whatTimeIsIt(any: Any): String = any match {
      case time: LocalTime => s"It is ${time.getHour}:${time.getMinute}"
      case _ => s"$any is no time!"
    }

    println(whatTimeIsIt(LocalTime.of(10, 30)))
    println(whatTimeIsIt("Hello"))
    println(whatTimeIsIt(100))


    def check(x:Any):String=x match
      case s :String=> s"String: $s"
      case i:Int=> s"Integer : $i"
      case _ => "Unknown"

     println(check(10))
    println(check("hello India"))
    println(check(20.1))


    val list: List[Any] = List(1, "Scala", 3.14, true)

    list.foreach {
      case s: String => println(s"String: $s")
      case i: Int => println(s"Integer: $i")
      case d: Double => println(s"Double: $d")
      case b: Boolean => println(s"Boolean: $b")
      case _ => println("Unknown type")
    }
  }
}
