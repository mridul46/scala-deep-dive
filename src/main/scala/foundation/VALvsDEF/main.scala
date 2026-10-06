package foundation.VALvsDEF

/*
    In scala, Function can be stored in a variable, passed to another function,
    returned from a function , and used like a value.
 */

/*

    Functions in Scala
       │
       ├── Can be stored in variables
       │
       ├── Can be passed as arguments
       │
       ├── Can be returned from functions
       │
       └── Can be stored in collections
      In Traditional function values may not have more then 22 parameter. 0-22
 */

/*
       Single Abstract Method(SAM)
          - A SAM is a type—usually a trait—that has exactly one abstract method.

 */
object main {
  def main(args:Array[String]): Unit = {
    //1. Normal value with val.
    val x=10
    println(s"value x is : ${x}")
    //2. A function can also be assigned to val
    val add=(a:Int,b:Int)=>a+b  // add-> function. so add is a value that refers to a function object. because Scala treats function as first-class citizen.
    println("sum of two number is " + add(12,12))



    //3. you can pass a function to another function:
    val sub=(a:Int,b:Int)=>a-b
    def  calculate(c:Int,d:Int, operation:(Int,Int)=>Int):Int={
      operation(c,d)
    }
     println(calculate(10, 20, sub))


    //4. Functions Can Be Stored in Collections:
    //Because functions are values, you can put them inside collections.
    val operations=List(
      (a:Int,b:Int)=>a+b,
      (a:Int,b:Int)=>b-a,
      (a:Int,b:Int)=>a*b
    )
    println("sum of two numbers : " + operations(0)(10,5))
    println("subtraction of two numbers : " + operations(1)(10,5))
    println("multiplication  of two numbers : " + operations(2)(10,5))

    //5. Function with map: this is why scala are so powerful
    val numbers= List(1,2,3,4,5)
    val doubled= numbers.map(x=>x*2)
    println("double of numbers are : " + doubled)



    //6. Function vs Methods
    //Method
    def add1(a:Int,b:Int):Int={
        a+b
    }

    //Function values
    val add2=(a:Int,b:Int)=>a+b

    //you can convert a method into a function value.
    def add3(a: Int, b: Int): Int = a + b
    val operation = add3 _

    //7.
  }
}
