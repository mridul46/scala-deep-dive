package basics.datatype

/*
   Nothing is the bottom type in Scala's type hierarchy.
   A type that never successfully returns a value.

   Why do we need Nothing?
      It is useful for methods that:
      Always throw an exception.
      Never terminate (infinite loop).
      Represent an empty value in generic collections.


  Differences Between Nothing and Other Types
      Nothing − It represents a non-existent value and is a subtype of all other types.
      Null − It represents a null reference and is a subtype of all reference types (but not of value types).
      Unit − It represents a lack of meaningful value. It is similar to void in other languages.
 */
object Noting {
  // This method never returns normally
  def divideByZero(): Nothing = {
    throw new ArithmeticException("Division by zero")
  }

  def main(args: Array[String]): Unit = {
    divideByZero()
  }
}
