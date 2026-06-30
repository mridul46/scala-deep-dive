package basics.datatype

/*
      Any is the  root (top-most) type in scala type hierarchy.It has both value and reference types.
      AnyVal → Value types (primitive-like types)- Int ,Double, Boolean, etc
      AnyRef → Reference types (objects/classes) - String, List, Object
      Nothing → Bottom type (subtype of all types)
// */
//object Any {
//  def main (args:Array[String]) : Unit = {
//    var value : Any =10
//    println(value)
//
//    value = "Scala"
//    println(value)
//
//    value = true
//    println(value)
//
//    value = 10.5
//    println(value)
//  }
//}

object Demo {

  //Method Accepting Any Type
  def printValue(value:Any):Unit={
    println(value)
  }
  //Pattern Matching with Any
  def identify(value: Any): Unit = {

    value match {

      case i: Int =>
        println(s"Integer: $i")

      case s: String =>
        println(s"String: $s")

      case b: Boolean =>
        println(s"Boolean: $b")

      case _ =>
        println("Unknown Type")
    }
  }

  def main(args:Array[String]):Unit={
    printValue(100)
    printValue("Hello")
    printValue(true)


    identify(10)
    identify("Scala")
    identify(false)



    //List[Any]
    val items: List[Any] = List(1, "Scala", true, 10.5)

    items.foreach(println)
  }
}
/*
     Every Scala inherits methods from Any
 */