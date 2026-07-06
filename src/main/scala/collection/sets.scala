package collection

object sets {
  def main (args:Array[String]):Unit ={
    //Creating a Set
    // Immutable Set (Default)
    val fruits = Set("Apple", "Banana", "Orange")
    println(fruits)

    //Duplicate Values
    val numbers = Set(1, 2, 3, 2, 1, 4)
    println(numbers)

    //Mutable set
    import scala.collection.mutable.Set
    val fruit = Set("Apple", "Banana")
    fruit += "Orange"
    fruit += "Mango"
    println(fruit)

    //empty set
    val empty = Set[Int]()
    println(empty)



    //Common Set Operations
    //contains() : Checks if an element exists.
    val fruits1 = Set("Apple", "Banana", "Orange")
    println(fruits1.contains("Apple"))
    println(fruits1.contains("Mango"))


    //Adding Elements (Immutable)
    //Since immutable Set cannot be changed, a new Set is returned.
    val numbers1 = Set(1, 2, 3)
    val newNumbers = numbers1 + 4
    println(numbers1)
    println(newNumbers)

    //removing elements
    val numbers2 = Set(1, 2, 3, 4)
    val newSet = numbers2 - 2
    println(newSet)


    //Adding Multiple Elements
    val nums = Set(1, 2)
    val result = nums ++ Set(3, 4, 5)
    println(result)

    //Removing Multiple Elements
    val nums1 = Set(1, 2, 3, 4, 5)
    println(nums1 -- Set(2, 4))



    //Iterating Through a Set
    val fruits2 = Set("Apple", "Banana", "Orange")
    fruits2.foreach(println)



    //Set Methods
    val nums2 = Set(1, 2, 3)
    println(nums2.size)


    //Set Operations
    //Union (++) : Combines two sets.
    val a = Set(1, 2, 3)
    val b = Set(3, 4, 5)

    println(a ++ b)


    //Intersection (intersect or &)
    //Common elements.
    println(a.intersect(b))


    //Difference (diff or --)
    //Elements in the first set but not in the second
    val a1 = Set(1, 2, 3, 4)
    val b1 = Set(2, 4)

    println(a1.diff(b1))

    //Symmetric Difference
    //Elements present in either set, but not both.
    val a2 = Set(1, 2, 3)
    val b2 = Set(3, 4, 5)

    val result1 = (a2 diff b2) ++ (b2 diff a2)

    println(result1)





    //converting collections
    //List->Set
    val list = List(1, 2, 2, 3, 3)
    println(list.toSet)


    //Set → List
    val set = Set(1, 2, 3)

    println(set.toList)


    val roles = List(
      "ADMIN",
      "USER",
      "ADMIN",
      "HR",
      "USER"
    )
    //remove duplicates
    val uniqueRoles = roles.toSet

    println(uniqueRoles)

    val userRoles = Set("USER", "HR")

    if (userRoles.contains("ADMIN"))
      println("Access Granted")
    else
      println("Access Denied")
  }
}
