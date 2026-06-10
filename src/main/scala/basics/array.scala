package basics


//In Scala ,an Array stores multiple values of the same type in contiguous memory Location
/*
    Array is :
    -Fixed size
    -mutable
    -indexed
    -fast access
  Scala arrays internally use Java array
 */
object array {
  def main (args:Array[String]):Unit= {
    val num = Array(10, 20, 30, 40)
    println(num(0))
    println(num(1))
    println(num(2))
    println(num(3))

    //1 Arrays are mutable
    num(0)=100
    println(num.mkString(","))

    //2. Array With Explicit Type
    val nums:Array[Int]=Array(1,2,3,4)
    println(nums(0))

    //3 . Empty Array with Fixed Size
    val arr= new Array[Int](5)
    /*
         Default values:
         Int-> 0
         Double->0.0
         Boolean-> false
         String ->null
     */
     println("check the results " + arr.mkString(","))

     //String with Array Example
     val st=new Array[String](3)
     st(0)="Mridul"
     st(1)="Hirak"
     st(2)="Anup"
     println("the resultant array of String  :  " +st.mkString(","))

    //Array Traversal
    for(n <-0 until nums.length) {
      println(nums(n))
    }

    //Array Method
    //Length
    println( "length of nums ->" + nums.length)
    //mkString
    println(  "convert String of nums ->" + nums.mkString(", "))
    //Sum
    println("sum of numbers of nums ->" + nums.sum)
    //max
    println("maximum numbers of nums array ->" + nums.max)
    //min
    println("minimum numbers of nums array ->" + nums.min)
    //sorted
    println("sorted of numbers of nums array ->" + nums.sorted.mkString(","))
    //contains
    println("check number present in nums array ->" + nums.contains(2))
    //reverse
    println("reverse the number in nums array ->" + nums.reverse.mkString(","))


    //2D  ARRAY
    val matrix=Array.ofDim[Int](2,3)
    matrix(0)(0)=1
    matrix(0)(1)=2
    matrix(0)(2)=3

    matrix(1)(0)=4
    matrix(1)(1)=5
    matrix(1)(2)=6


    for(row <- matrix){
      for(col <- row){
        print(col + " ")
      }
      println()
    }

    val arr1 = Array.ofDim[Int](3, 1)

    arr1(0) = Array(1, 2)
    arr1(1) = Array(3, 4, 5)
    arr1(2) = Array(6)

    for (row <- arr1) {
      println(row.mkString(", "))
    }
  }
}
