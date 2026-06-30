package basics.loop

object forLoop {
  def main(args:Array[String]): Unit = {
    //1 . simple range loop
    //using to (includes the end number)
    for(i <-1 to 5){   //<- operator is called the generator
      println(s"Number is $i")
    }

    //using until (Excludes the end number)
    for( i<-1 until 5){
      println(s"Number is $i")
    }


    //2 . iterating over collections
    // you can iterate over lists, arrays , sets , or vector seamlessly

    val fruits= List ("Apple","Banana" ,"Cherry")
    for(fruit <- fruits){
      println(s"I like $fruit")
    }

    //3 . adding filters(Guards)
    //add if statement directly inside the for loop to filter out elements is called a guard
    for(i<-1 to 10 if i%2==0){
      println(s"Even number is : $i")
    }

    //4 . nested loop
    for{
      i<-1 to 2
      j<- 'a' to 'b'
    }{
      println(s" $i , $j")
    }
    //5 .yielding values (functional ways)
    val numbers = List(1, 2, 3, 4)
    val doubledNumbers = for (n <- numbers) yield n * 2
    println(doubledNumbers)

  }
}
