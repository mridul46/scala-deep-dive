package basics.MethodsAndFunctions

object functions {
  def main (args:Array[String]):Unit ={
    val add = (a: Int, b: Int) => a + b
    val sum = add(5, 3)
    println(s"The sum is: $sum mridul")
  }
}


