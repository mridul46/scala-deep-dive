package basics.MethodsAndFunctions



/*
    Method is a function defined within a class, trait and object.
    Methods can take parameters. Method can perform actions and return values.
    So, you can organize code into logical units. So code can be modular and maintainable.

    Method can be defined using the def keyword.
    Then it is followed by the method name, parameter list, return type, and method body.

    Syntax
    The syntax of the method in Scala -

    def methodName(param1: Type1, param2: Type2): ReturnType = {
      // Method body
      // return some value of ReturnType
    }

 */

object methods {
  def add(a: Int, b: Int): Int = {
    a + b
  }
  
  def main (args:Array[String]):Unit={
    val sum = add(5, 3)
    println(s"The sum is: $sum")
  }
}
