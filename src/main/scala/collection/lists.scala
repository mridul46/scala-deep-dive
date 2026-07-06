package collection


/*
   Time Complexity
Operation	                   Complexity	                     Notes
head	                              O(1)                 	Very fast
tail	                              O(1)                	Very fast
:: (prepend)                      	O(1)                	Recommended for adding elements
+: (prepend)	                      O(1)                 	Also efficient
last	                              O(n)                	Traverses the list
:+ (append)	                        O(n)	                Traverses the list
apply(index)                        O(n)	               Linked list traversal
length	                            O(n)	               Counts all elements
map                               	O(n)               	Visits each element once
filter	                            O(n)	              Visits each element once
find	                              O(n)	                Stops when a match is found
++                                	O(n)	                Copies the left-hand list
 */
object lists {
  def main (args:Array[String]):Unit ={
     //creating list
    val numbers= List(10,20,30,40)
    println(numbers)

    //empty List
    val emptyList=List()// Nil also represent an empty List
    println(emptyList)

    //first numbers
    println(numbers.head)
    //Remaining Elements
    println(numbers.tail)

    //Last Element
    println(numbers.last)
    //Element by Index
    println(numbers(2))


    //Length : Returns the number of elements.
    val nums = List(1, 2, 3, 4)
    println(nums.length)

    //isEmpty :Checks whether the list is empty.
    val list = List()
    println(list.isEmpty)

    //nonEmpty
    val nums1 = List(1, 2)
    println(nums1.nonEmpty)


    //adding Elements : Since List is immutable, adding an element creates a new list.
   //Add at the Beginning (::)
    val nums2 = List(2, 3, 4)
    val newNums = 1 :: nums2
    println(newNums)

    //Add Multiple Elements
    val nums3 = List(3, 4)
    val newList = 1 :: 2 :: nums3
    println(newList)


    //Add at the End (:+)
    val nums4 = List(1, 2, 3)
    val newNums1 = nums4 :+ 4
    println(newNums1)


    //Add to the Front (+:)
    val nums5 = List(2, 3)
    val newNums2 = 1 +: nums5
    println(newNums2)

    //Joining Lists    ++
    val a = List(1, 2)
    val b = List(3, 4)
    println(a ++ b)
  }
}
