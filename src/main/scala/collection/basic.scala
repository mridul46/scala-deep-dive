package collection



object basic {
  def main(args:Array[String]):Unit ={
    /*
        List (immutable)
         stores ordered elements
     */
    val nums=List(1,2,3,4)
    println(nums.head) // 1
    println(nums.tail) // List(2,3,4)
    println(nums.last) // 4
    println(nums.length) // 4
    println(nums(0))
    println(nums(1))
    println(nums(2))
    println(nums(3))
    println(nums)

    //adding
    val list = List(2, 3)
    val newList = 1 :: list
    println(newList) // List(1,2,3)


    //Appending
    val list1 = List(1, 2)
    val list2 = List(3, 4)
    println(list1 ++ list2) // List(1,2,3,4)  //++ (Concatenation): Takes an Iterable collection.
    // It iterates through the second collection to append its elements to the first one, returning a brand-new collection.
    //+ (Single Element): Is generally used for appending/prepending a single item
    /*
        For immutable lists, Scala prefers operators that show where the element is going::: (Cons):
        Prepends a single element to the front (very fast, $O(1)$).:+: Appends a single element to the end ($O(n)$).
        ++: Appends another collection ($O(n)$).
     */


    /*
        Array (Mutable Size Fixed)
     */
    val arr = Array(10, 20, 30)
    arr(0) = 100
    println(arr.mkString(", "))
    println(arr(0))

    /*
       vector: Fast random access
     */
    val vec = Vector(1, 2, 3)
    println(vec(1))

    //ArrayBuffer (Mutable)
    import scala.collection.mutable.ArrayBuffer
    val buffer=ArrayBuffer(1,2,3)
    buffer+=4 //add number
    buffer+=5
    println(buffer)
    buffer-=2  //remove number
    println(buffer)

    /*
       Set: stores unique values (immutable)
     */
    val set = Set(1, 2, 3, 3, 2)
    println(set) //gives unique value
    //mutable set
    import scala.collection.mutable.Set
    val set1= Set(1,2,3)
    set1+=3
    set1-=1
    println(set1)


    //Map: collection of key-value pair
    //immutable
    val student=Map(
      "name"->"Mridul",
      "age" ->26
    )
    println("student name is : " + student("name"))
    //mutable
    import scala.collection.mutable.Map
    val map = Map(
      "name"->"Mridul",
      "age" ->26
    )
    map += ("Scala" -> 100)
    println(map)


    //tuple
    val person = ("John", 22, true)
    println(person._1)
    println(person._2)
    println(person._3)


    //common collection method
    //map: transforms every element
    val nums1 = List(1, 2, 3)
    val result = nums1.map(_ * 2)
    println(result)

    //filter : return matching elements
    val nums2 = List(1, 2, 3, 4, 5, 6)
    println(nums2.filter(_ % 2 == 0))

    //forEach
    List(1,2,3).foreach(println)

    //find : returns first matching element.
    val nums3 = List(10, 20, 30)
    println(nums3.find(_ > 20))

    //exists
    println(List(1,2,3).exists(_ == 2))

    //forall
    println(List(2,4,6).forall(_ % 2 == 0))

    //count
    println(List(1,2,3,4).count(_ % 2 == 0))

    //reduce: combines elements into one value
    val  sum= List(1,2,3,4).reduce( _ * _ )
    println(sum)

    //fold: Like reduce , but starts with an initial value.
    val sum1 = List(1, 2, 3).fold(10)(_ + _)
    println(sum1)

    //flatmap:
    val words = List("Hello World", "Scala")
    println(words.flatMap(_.split(" ")))

    //groupBy
    val nums4 = List(1, 2, 3, 4, 5)
    println(nums4.groupBy(_ % 2))

    //sortBy
    val nums5 = List(5, 2, 8, 1)
    println(nums5.sortBy(x => x))
    // descending
    println(nums5.sortBy(-_))

    //distinct
    println(List(1,2,2,3,3).distinct)

    //take/drop

    val num = List(1, 2, 3, 4, 5)
    println(num.take(3))   // List(1,2,3)
    println(num.drop(3))    // List(4,5)

    //zip
    val names = List("A", "B", "C")
    val marks = List(90, 80, 95)
    println(names.zip(marks))
  }

}
