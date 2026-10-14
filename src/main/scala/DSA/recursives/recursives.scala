package DSA.recursives


//Normal recursion: The function performs additional work after the recursive call returns.
//Tail recursion: the recursive call is the last operation; no work remains after it.


//normal recursion
def factorial(n:Int):Int={
  if( n==0 ) 1
  else n*factorial(n-1)
}

//tail recursion
import scala.annotation.tailrec
def fact(n:Int):Int={
  @tailrec
  def loop(n:Int,acc:Int):Int={
    if(n<1) acc
    else loop(n-1,acc*n)
  }
  require(n>=0, "n must be non negative")
  loop(n,1)
}
object recursives {
  def main(args:Array[String]):Unit={
     println("normal recursion "+ factorial(5))   //120
     println("tail recusion : " +  fact(5))
  }
}
