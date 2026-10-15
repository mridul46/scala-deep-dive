package basics.lazyVal

/*
    In Scala, lazy val is a value that is initialized only when it is accessed for the first time. After initialization, the computed value is reused on every subsequent access.

    Difference between val, var, and lazy val
           Feature                                 	val                    	                    var	                                         lazy val
           Can be reassigned?                      	No	                                        Yes	                                         No
           Initialization	                          When execution reaches its definition      	When execution reaches its definition	       First time it is accessed
           Initialized once?                       	Yes                                       	No, its value can change                  	 Yes, successfully initialized value is reused
           Evaluation	                              Eager.                                      Eager	                                       Lazy



    Is lazy val thread-safe?
    Yes. Scala's lazy val initialization is designed to be thread-safe: concurrent accesses coordinate initialization so that only one successful initialization occurs for that lazy value, with other threads observing the initialized result.

 */

object Main extends App {
  val normalValue =
    println("Normal val initialized")
    100


  lazy val lazyValue =
    println("Lazy val initialized")
    200

  println("Program started")
  println(lazyValue)
  println(normalValue)
  println(lazyValue)

  //Why use lazy val?
  //Avoid expensive calculations when they are not need
  //delay database or service initialization
  //avoid unnecessary object notation

  lazy val report={
    println("Generating a large report .....")
    (1 to 1000000000).sum

  }
  println("Application started") //Application started


  class ReportService {

    lazy val configuration = {
      println("Loading report configuration")
      Map(
        "format" -> "PDF",
        "language" -> "English"
      )
    }

    def generateReport(): Unit = {
      println(configuration("format"))
    }

    //Does lazy val execute only once?
    //Under normal successful initialization, yes: a lazy val initializes once and reuses its value.
  }
}