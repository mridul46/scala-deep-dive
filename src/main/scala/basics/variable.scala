package basics

object variable{
   def main (args:Array[String]):Unit = {
     /*
     In Scala ,variables are used to store data
     Scala mainly has:
      -val->immutable(cannot change)
      -var -> mutable(can change)
      -lazy val
      -typed variable
      -inferred variable
      -pattern variable
      -destructing variable
      -class variable
      -Singleton object variable
      */

     //1. val
     /*
         Why val is Important
         Scala encourages functional programming.
         Immutable data:

         1. safer
         2. thread-safe
         3. predictable
         4. avoids bugs
      */
     val age:Int=34
     //  age=32 it give Error
      println(age)


      //2.var- >mutable
       var score=23
       score=100
       println(score)


     /*
         3. lazy val : initialized ony when used first time
            Useful for:

              database connection
              file loading
              expensive computations
              API calls
      */
     lazy val data = {
       println("Loading...")
       100
     }
     println("Program started")
     println(data)
   }

}
