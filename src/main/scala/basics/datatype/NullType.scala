package basics.datatype

//In scala In Scala, null represents the absence of a value for reference types. Unlike primitive types like Int and Double, which cannot be assigned null. These reference types such as String and Object can have null as a valid value.

/*
     Differences Between null, Null, and Option
     null − The literal used to denote the absence of a reference.
     Null − The type that null belongs to, which is a subtype of all reference types.
     Option − A container that can hold either a value (Some) or no value (None). It provides a safer alternative to null.
 */
object NullType {
  def main(args:Array[String]):Unit= {
     val nullableString:String=null
     val nullableObject:String=null

    println(s"nullableString: $nullableString")
    println(s"nullableObject: $nullableObject")

    //handling Null values with Option Type
    //You can use Option type in Scala instead of using null. Option type represents an optional value that can either be Some(value) or None. It avoids null-related errors alternatively for handling absent values.

    val maybeValue : Option[String]= Some("hello")
    val absentValue: Option[String]= None


    // Safely extract value using pattern matching
    maybeValue match
      case Some(value)=> println(value)
      case _=>  println("value is absent") //you may be used _ instead of none


    absentValue match
      case Some(value) => println(value)
      case None => println("value is absent")

    /*
        Pattern Matching for Option
      You can also use pattern matching for null values.
      With the pattern matching against Some and None,
       you can extract values from Option instances without the risk of NullPointerExceptions.
     */
    val maybe: Option[String] = Some("Hello")

    maybe match {
      case Some(value) => println(value)
      case None => println("Value is absent")
    }

  }
}
