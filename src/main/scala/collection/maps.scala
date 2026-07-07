package collection

object maps {
  def main (args:Array[String]): Unit = {
    // creating maps
    //Immutable Map (Default)
    val student = Map(
      "name" -> "Rahul",
      "age" -> "22",
      "city" -> "Delhi"
    )
    println(student)

    //Accessing Values - using key
    println(student("name"))
    //using get() : returns an option
    println(student.get("name"))  //Some(Rahul)
    //missing key
    println(student.get("salary")) //None
    //Using getOrElse() : This avoids exceptions when the key doesn't exist.
    println(student.getOrElse("salary", 0))




    //Adding elements : Since immutable Map cannot change, adding returns a new Map.
    val marks = Map(
      "Math" -> 90,
      "Science" -> 95
    )
    val newMarks = marks + ("English" -> 88)
    println(newMarks)

    //Updating a Value
    val updated = marks + ("Math" -> 100)
    println(updated) //The existing value for "Math" is replaced.


    //Removing Elements
    val result = marks - "Science"
    println(result)



    //Mutable map
    import scala.collection.mutable.Map

    val marks1 = Map(
      "Math" -> 90
    )

    marks1 += ("Science" -> 95)
    marks1 += ("English" -> 85)

    println(marks1)


    //Common Map Methods
    //keys
    val students = Map(
      "name" -> "Rahul",
      "age" -> 22
    )

    println(students.keys)

    //values
    println(students.values)




  }
}
