package basics.ClassAndObjects

/*
    The syntax of the generic class is -
    class ClassName[T] {
         // class body using type T
   }
 */

class Container[T](value: T) {
  def getValue: T = value
}
/*
        Generic Methods
        - Generic method is a method that takes type parameters. These methods can be defined within generic and non-generic classes.

       Syntax
       The syntax of the generic method is -
                           def methodName[T](param: T): ReturnType = {
                           // method body using type T
                           }
 */


/*
      Multiple Type Parameters
         Both Generic classes and methods can have multiple type parameters.
         So there can be more complex and flexible type definitions.

    Syntax
        The syntax of multiple type parameter is -
                         class ClassName[T, U] {
                            // class body using types T and U
                         }
 */
class Pair[T, U](val first: T, val second: U) {
  def getFirst: T = first
  def getSecond: U = second
}


/*
       Bounded Type Parameters
       Bounded type parameters restrict the types that can be used as arguments for a type parameter.
       Upper bounds and lower bounds are used to enforce these restrictions.

       1. Upper Bounds (T <: Upper)
          This states that T must be a subclass of a specific type.
       2. Lower Bounds (T >: Lower)
           This states that T must be a superclass (or a parent) of a specific type.
           It is less common but highly crucial when writing methods that append items to collections.

       Syntax
       The syntax of bounded type parameter is -
                   def methodName[T <: UpperBound](param: T): ReturnType = {
                     // Method definition
                   }

                   def methodName[T >: LowerBound](param: T): ReturnType = {
                     // Method definition
                   }
 */
class Upper
class Sub extends Upper
class Container1[T <: Upper](value: T) {
  def getValue: T = value
}

/*
    Covariant and Contravariant Type Parameters
    Covariance and contravariance control how subtyping between complex types relates to subtyping between their component types.
    When a type parameter is covariant, you can replace the generic class with a subclass.
    When a type parameter is contravariant, you can replace the generic class with a superclass.

    Syntax
    The syntax of covariance and contravariance type parameters is
                  class Covariant[+T] {
                 // class body using type T
              }

              class Contravariant[-T] {
                 // class body using type T
              }
 */
class Animal1
class Dog1 extends Animal1

class Covariant[+T](val value: T)
class Contravariant[-T](value: T)



object generics {
  def printValue[T](value: T): Unit = {
    println(s"Value: $value")
  }
  def main(args: Array[String]): Unit = {
    val intContainer = new Container(42)
    val stringContainer = new Container("Hello, Scala!")

    println(intContainer.getValue)    // 42
    println(stringContainer.getValue) // Hello, Scala!


    printValue(42) // Output: Value: 123
    printValue("Hello, Scala!") // Output: Value: Hello, Scala!
    printValue(3.14) // Output: Value: 3.14


    val intStringPair = new Pair[Int, String](42, "Scala")
    val stringDoublePair = new Pair[String, Double]("Pi", 3.14)
    println(intStringPair.getFirst) // 42
    println(intStringPair.getSecond) // Scala
    println(stringDoublePair.getFirst) // Pi
    println(stringDoublePair.getSecond) // 3.14


    val upperContainer = new Container1[Upper](new Upper)
    val subContainer = new Container1[Sub](new Sub)

    println(upperContainer.getValue)
    println(subContainer.getValue)


    val covariant: Covariant[Animal1] = new Covariant[Dog1](new Dog1)
    val contravariant: Contravariant[Dog1] = new Contravariant[Animal1](new Animal1)

    println(covariant.value)

  }
}


