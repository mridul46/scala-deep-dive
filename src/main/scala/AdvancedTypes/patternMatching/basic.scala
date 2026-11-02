package AdvancedTypes.patternMatching
/*
       basic syntax
          expr match {
                 case pattern1=>result1
                 case pattern2=>result2
          }
 */
object basic {
  def main(args:Array[String]):Unit={
    //basic example
    val num=2
    val result= num match
      case 1 => "one"
      case 2 => "two"
      case _ => "others"

    println(result)

    //pattern types
    //constant matching
    //x match
    //  case 10 =>"Ten"

    //variable pattern
//    x match
//      case y=> s"Value is $y"

    //Type matching
    val x: Any="Hello"
    x match {
      case s:String=>"String"
      case i: Int =>"Integer"
    }

    //case class matching
    case class Person(name:String, age:Int)
    val p=Person("Mridul",22)
    p match
      case Person(n,a) =>s"$n is $a years old"

    //Guard Conditions
      val s=10
      val q = s match{
        case n if n>5 =>"Greater then 5"
        case _ => "Small"
      }
      println("result "+ q)

  }

}
