package collection

//import TreeMap
import scala.collection.immutable.TreeMap
object TreeMaps {
  def main( args: Array[String]): Unit = {


    //Creating a TreeMap
    val students = TreeMap(
      103 -> "Rahul",
      101 -> "Amit",
      102 -> "Priya"
    )

    println(students) //keys are automatically sorted

    //Accessing Values
    println(students(101))
    //Using get():
    println(students.get(102)) //Some(Priya)
    //Missing key
    println(students.get(105)) //None


    //Adding Elements
    val student = TreeMap(
      101 -> "Amit",
      102 -> "Rahul"
    )

    val updated = student + (103 -> "Priya")
    println(updated)


    //Iterating Through a TreeMap
    val marks = TreeMap(
      "Math" -> 90,
      "English" -> 80,
      "Science" -> 95
    )

    marks.foreach {
      case (subject, mark) =>
        println(s"$subject -> $mark")
    }
  }
}
