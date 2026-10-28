package basics.IO
import scala.io.Source
import scala.io.StdIn
//import cats.effect.{IO, IOApp}

/*
     1. What does IO mean?
       IO stands for input/output - interactions between your program and outside world.

       examples include: -reding a file
                         -Printing to the console
                         -making an HTTP request
                         -querying a database
                         -writing to a file
                         -reading user input

 */
object io {
  def main(args:Array[String]):Unit={

    //Ordinary scala
    //val result= readFile("data.txt")
    //functional effect ,using Cats Effect
    //val r1=IO(readFile("data.txt"))
    
    //standard Scala
    println("Program started")
    val source= Source.fromFile("data.txt")
    try {
      println(source.getLines().mkString("\n"))
    } finally {
      source.close()
    }
  }
}
