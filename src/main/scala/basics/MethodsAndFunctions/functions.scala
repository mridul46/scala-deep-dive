package basics.MethodsAndFunctions




object functions {
  def main (args:Array[String]):Unit ={

    //Anonymous Function (Lambda)
    //Function without a name
    val add = (a: Int, b: Int) => a + b
    val sum = add(5, 3)
    println(s"The sum is: $sum mridul")


    //normal function: most commonly used and it have name, parameter and return type
    def greet(name: String): String =
      "hello " + name
    println(greet("Mridul"))


    //Pure Function
    //A function always give same output for same input
    //has no side effect
    def square(x:Int):Int = x*x
    println("sqaure of 2 is : " + square(2))


    //Curried Functions
    //Function with multiple parameter list
    def add1(a:Int)(b:Int):Int=a+b
    println("sum of two number is : "+ add1(5)(3))


  }
}


