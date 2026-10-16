package basics.generalizations


/*
     In Scala, generalization means writing code that works with a broad range of types or situations instead of being restricted to one specific type or case.
     for example:
          instead of writing separate functions to find the first element of an Int, a String list, and a Double list , you can write one generic function that works with all of them.

          Note: Generalization is closely related to generics, polymorphism, abstraction, and reusable code.


          When should you use generalization in backend development?
              In your Scala and Play Framework learning, generalization can help you create:
              - Generic repositories: reusable database access patterns across entity types.
              - Common service interfaces: different services that follow the same contract.
              - Reusable validation functions: apply consistent validation to multiple data types.
              - Generic API responses: a common response structure that can carry different payload types.
              - Higher-order transformations: reuse filtering, mapping, and processing logic.


              Generalization is the design principle; generics, traits, polymorphism, and higher-order functions are some of the tools that help implement it.


 */
object generalization {
  def main(args: Array[String]): Unit = {
    //1. Why do we need generalization?
    //Suppose you want to create functions that return the first element of a list.

    //without generalization
    //All three functions perform the same operation. Only the data type changes.
    //This creates unnecessary duplication.
    def firstInt(list: List[Int]): Int = list.head

    def firstString(list: List[String]): String = list.head

    def firstDouble(list: List[Double]): Double = list.head

    //With generalization
    def first[A](list: List[A]): A = list.head
    //now you can use same function with different types
    println(first(List(10, 20, 30))) //10
    println(first(List("Scala", "Java"))) //Scala
    println(first(List(2.5, 3.5))) //2.5

    //2. Four important ways to generalization code in scala
    //a. Generic programming
    //Use type parameters such as [A] to work with different data types.
    def identity[A](value: A): A = value

    //b.Abstraction
    //Define a common interface so different implementations can be used through the same contract.
    trait Animal {
      def speak():String
    }
    //c. polymorphism
    //use a common interface while allowing different implementations to have differently.
    def makeSound(animal: Animal):Unit=
      println(animal.speak())

    //d. Higher-order Functions
    //Generalize an operation by accepting another function as an argument.
      def transform[A,B](value:A)(f:A=>B):B=f(value)

    //Generalization using type parameters
    //A generic function can accept a value of any type while preserving information about that type.
    def identity1[A](value: A): A = value
    /*
    Let's break this down:
                   - def identity: defines a function.
                   - [A]: declares a type parameter.
                   - (value: A): accepts a value of type A.
                   - : A: returns a value of the same type.
                   - value: returns the original argument.
     */
    println(identity(100))
    println(identity("Hello"))
    println(identity(true))


    def combine[A](first: A, second: A): (A, A) =
      (first, second)

    println(combine(10, 20))
    println(combine("Scala", "Java"))



    case class ApiResponse[A](
                             success: Boolean,
                             data:Option[A],
                             message:String
                             )
    val userResponse= ApiResponse(success = true, data = Some(355), message = "points fetch")
  }
}
