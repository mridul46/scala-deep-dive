package basics.MethodsAndFunctions

/*

     JSON: A data format.
     Enumeration: A Scala construct that defines a fixed set of cases.
     Recursive enumeration: An enum whose cases can contain values of the same enum type.
     Recursive function: A function that calls itself.
 */
//1. why is JSON recursive?
//JSON supports value that can contain other JSON values.
//Notice:
//  - An object contains other values.
//  - An array contains other values.
//  - An object can contain another object.
//  - Arrays and objects can be nested repeatedly.

def printMany(n:Int,message:String):Unit={
  if(n<=0) () //do nothing
  else {
    println(message)
    printMany(n - 1, message)
  }
}

//JSON is a recursive enumeration
enum Json {
  //Leaves
  case JsonNumber(number: Double)
  case JsonString(text:String)
  //Branch
  case JsonObject(obj:Map[String,Json])
}

val json :Json =Json.JsonNumber(25)
import Json._
val number:Json =JsonNumber(25)
val text:Json=JsonString("Mridul")
val obj:Json=JsonObject(Map())



object recursiveFunction {
  def main(args:Array[String]):Unit={
    printMany(3,"Hello Assam")
  }
}
