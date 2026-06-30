package basics.datatype

//Scala provides built-in methods via scala.io.StdIn for reading inputs and standard printing functions for outputs.
import scala.io.StdIn.*
//Writing Output
/*
  1. print(): Prints the value to the console without a newline.
  2.println(): Prints the value and adds a newline character.
  3.printf(): Allows formatted printing (similar to C or Java).
 */

/*
  READING INPUT
  To read input : import scala.io.StdIn._
  This package provides explicit methods like readLine(), readInt(), readDouble(), etc.
 */






//Scala 2
//Approach 1: Using the main method (Recommended)
object InputOutput {
  def main(args: Array[String]): Unit = {
    // Output
    printf("Enter your name:")

    // Input
    val name = readLine()

    printf("Enter your age:")
    val age = readInt() // Throws NumberFormatException if input is not an integer

    // Formatted Output (Using String Interpolation)
    println(s"Hello $name, next year you will be ${age + 1} years old.")


    println("Enter temperature in Celsius:")
    val celsius = readLine().toDouble
    val fahrenheit = celsius * 9 / 5 + 32
    println("Temperature in Fahrenheit: " + fahrenheit)
  }
}


//SCALA3
//import scala.io.StdIn._
//
//@main def InputOutput(): Unit = {
//  // Output
//  println("Enter your name:")
//
//  // Input
//  val name = readLine()
//
//  println("Enter your age:")
//  val age = readInt() // Safely reads an integer
//
//  // Formatted Output (Using String Interpolation)
//  println(s"Hello $name, next year you will be ${age + 1} years old.")
//}

