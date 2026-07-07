package collection
//import
import scala.collection.immutable.SortedMap

object SortedMaps {
  def main (args :Array[String]): Unit = {


     //Creating sorted Map
     val students = SortedMap(
       103 -> "Rahul",
       101 -> "Amit",
       102 -> "Priya"
     )

    println(students)  //TreeMap(101 -> Amit, 102 -> Priya, 103 -> Rahul)
    //String keys
    val fruits = SortedMap(
      "Orange" -> 30,
      "Apple" -> 50,
      "Banana" -> 20
    )

    println(fruits)

    //Accessing Values
    println(students(101)) //Amit

    //using get()
    println(students.get(102)) //Some(Priya)

    //Missing keys
    println(students.get(105)) //None


    //Adding Elements
    val updated = students + (104 -> "Mridul")
    println(updated)

    //Updating a Value
    val updated1 = students + (102 -> "Rohan")
    println(updated1)

    //Removing Elements
    println(students - 102)


    //common methods
    //keys
    println(students.keys)  //TreeSet(101, 102, 103)
    //values
    println(students.values) //Iterable(Amit, Priya, Rahul)

    //contains
    println(students.contains(101))

    //size
    println(students.size)


    //Iterating
    students.foreach {
      case (id, name) =>
        println(id + " -> " + name)
    }

    //filtering
    val marks = SortedMap(
      "Math" -> 90,
      "Science" -> 95,
      "English" -> 80
    )

    println(
      marks.filter(_._2 >= 90)
    )

    //mapping
    val marks1 = SortedMap(
      "Math" -> 90,
      "Science" -> 95
    )

    val updated2 =
      SortedMap.from(
        marks1.map {
          case (subject, mark) =>
            subject -> (mark + 5)
        }
      )

    println(updated2)



    //Range operations : One major advantage of SortedMap is efficient range queries.
    val map = SortedMap(
      1 -> "One",
      2 -> "Two",
      3 -> "Three",
      4 -> "Four"
    )

    println(map.rangeFrom(3))

    //rangeUntil
    println(map.rangeUntil(3))

    //range
    println(map.range(2, 4))

    
  }
}
