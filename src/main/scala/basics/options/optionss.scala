package basics.options


// Option is used  to represent a value that may or may not exist.
// Instead of returning null when a value is missing ,scala code cam run
//Some(Value) - a value exists
//None - no value exists
/*
     1. Why do we need Option?
        Imagine you want to find an employee's name by their ID.
        Without Option, you might return null when the employee doesn't exist:
 */
/*
      flatmap vs flatten
      flatmap: map + flatten conceptually. it transforms each element and then flatten the result.
              - when you need to transform each element into a collection or wrapper and combine the results.
      flatten: only flattens an already nested collection or wrapper. it doesn't transform the element.
              - when you already have nested data and only want to remove one layer.
 */
def findName (id: Int):String={
  if(id==1) "Mridul"
  else null
}
def findName1(id:Int):Option[String]={
  if (id == 1) Some("Mridul")
  else None
}

object optionss {
  def main(args:Array[String]): Unit = {
     println(findName1(3)) //None
     println(findName1(1))  //Some(Mridul)
    //pattern matching
     val name :Option[String]=Some("Mridul")
     name match
      case Some(value)=> println(s"Name: $value")
      case _          => println("name is not found")

    //use in getOrElse : use getOrElse when you want a default value if the value is missing.
      val name1 :Option[String] = None
      val res= name1.getOrElse("Unknown")
      val res1 = name.getOrElse("Unknown")
      println(res) //Unknown
      println(res1) //Mridul

      //use in map: Use map to transform the value inside an Option without manually checking whether it
      val upperName=name.map(_.toUpperCase)
      println(upperName) //Some(MRIDUL)


      //Use flatmap when the function you call alreay returns an Option.
      def findUser(id:Int):Option[String]=
        if(id==1) Some("Mridul")
        else None

      def findEmail(name:String):Option[String]=
        if(name=="Mridul") Some("mridul@example.com")
        else None

      val email= findUser(1).flatMap(findEmail)
      val email1=findUser(1).map(findEmail)
      println(email) //Some("mridul@example.com")
      println(email1) //Some(Some("mridul@example.com"))

      //map and flatmap use in list
      //map : transform values
      //flatmap : transform and flatten
      val numbers=List(1,2,3,4,5)
      val result= numbers.map(n=> n*2)
      val result1=numbers.flatMap(n=> List(n*2))
      println(result) //List(2,4,6,8,10)
      println(result1) //List(2,4,6,8,10)

      //understanding  flatten
      val num=List(List(1,2),List(3,4))
      val res2= num.flatten //basics.options.optionss$$$Lambda/0x00000000170b40f0@6108b2d7
      println(res2) //List(1, 2, 3, 4)

  }
}
