package collection

/*
    A Tuple is a collection that can store multiple values of different data types in a single object.

    Unlike a List, Set, or Array, the elements of a tuple:
    ✅ Can have different data types
    ✅ Have a fixed size
    ✅ Are immutable
    ✅ Are accessed by position, not by name
 */
object tuples {
  def main (args: Array[String]): Unit ={
     //creating tuples
    val person=("Rahul",22,55.5,true)
    println(person)

    //Accessing Tuple Elements
    //Tuple elements are accessed using ._1, ._2, ._3, etc.
    println(person._1)
    println(person._2)

    //tuple size
    println(person.productArity) //productArity: returns the number of elements

    //Iterating Over a Tuple
    val tuple = ("Scala", 100, true)
    tuple.productIterator.foreach(println)


    //pattern matching(Destructuring) :: This is much cleaner than using ._1 and ._2.
    val person1 = ("Rahul", 22)
    val (name, age) = person1
    println(name)
    println(age)


    //Swapping a tuple
    val pair = ("Scala", 100)
    println(pair.swap)

    //Nested tuples
    val employee =(101, ("Rahul", 25), 60000)
      println(employee._2._1)
      println(employee._2._2)


    //tuple in collection
    //list of tuples
    val students = List(
        ("Rahul", 90),
        ("Amit", 80),
        ("Priya", 95)
      )
    students.foreach {
      case (name, marks) =>
        println(s"$name -> $marks")
    }

    //tuple in map
    val map = Map(
        "A" -> 10,
        "B" -> 20
      )
    map.foreach {
      case (key, value) =>
        println(key + " : " + value)
    }



    //Zipping Creates Tuples
    val names =List("Rahul", "Amit", "Priya")
      val marks = List(90, 80, 95)
      println(names.zip(marks))
  }
}
