package basics.errorHandling

import jdk.jfr.DataAmount


/*
     Error handling in scala is away to detect ,represent,recover from and communicate
     failures without crashing your entire program unexpectedly.

     Success: Return the expected result.
     Failure: Recover, return an error value, or handle an exception.

     Scala provides several mechanisms for these situations:
               Mechanism	                     Main purpose
               try / catch / finally	         Handle exceptions
               Option[A]	                     Represent a value that may be absent
               Either[E, A]                   	Represent a success or a failure with a reason
               Try[A]	                         Represent the result of a computation that may throw
               Future[A]	                     Represent an asynchronous computation that may fail
               throw	                         Raise an exception
               require,assert	                 Check preconditions and program invariants
           The most important distinction is that not every failure should be represented by an exception.

           When should you use Option?
              Use it when the normal outcome might legitimately contain no value:
              - A user lookup finds no matching user.
              - A configuration setting is optional.
              - A database query returns no row.
              - A map does not contain a requested key.



                       Option vs Either vs Try vs Future
              This comparison is especially useful when deciding how to design service methods.
              Feature                                 	Option[A] 	         Either[E, A]           	        Try[A]	                                   Future[A]
              Success                                 	Some(a)	             Right(a)	                        Success(a)	                               Successful completion
              Failure/ absence	                        None	               Left(error)	                    Failure(ex)	                               Failed completion
              Carries an error reason?	                No	                 Yes,	                            Yes, exception                    	       Yes, exception
              Handles thrown exceptions automatically? 	No,	                 No	                              Yes, non-fatal exceptions         	       Yes, exceptions in its computation
              Primary use	                              Missing value	       Expected, typed failures	        Exception-prone synchronous code  	       Asynchronous work



             A practical rule:
             - Use Option :               when absence is the only information you need.
             - Use Either :               when the caller should understand a specific failure reason.
             - Use Try    :               when wrapping code that can throw.
             - Use Future :              when a result is asynchronous and can complete later.
 */
object error {
  def main(args:Array[String]):Unit ={

    //Exceptions in Scala
    //val res= 10/0
    //println(res)   //This throws an ArithmeticException because integer division by zero is invalid.


    //Understanding try and catch
    /*
         1.try: contains the code that might throw an exception.
         2.catch: matches the thrown exception against cases and handles a matching type.
         3.finally: executes when control leaves the try/catch, whether normally or exceptionally, barring abrupt termination of the runtime.
     */
    //Arithmetic error :/ by zero
    //operation finished
    try {
      val r1 = 10 / 0
      println(r1)
    }catch {
      case e: ArithmeticException => println(s"Arithmetic error :${e.getMessage}")
    }
    finally {
      println("operation finished")
    }


    //what is throw ?
    //Use "throw" when you want to raise an exception yourself.
    def withdraw(balance:Double,amount:Double):Double={
      if(amount<0) {
        throw new IllegalArgumentException("Amount must be positive")
      } else  if(amount>balance) {
        throw new IllegalStateException("Insufficent balance")
      } else {
        balance - amount
      }
    }
    println("check withdraw amount : " + withdraw(123.23,112))


    //Option: Handling missing values
    //one of the simplest forms of error prevention in Scala is Option.
    // if value is found the  output :Some(value)
    //if value is not found   output: None
    //this helps you avoid using null
    val users=Map(
      1-> "Mridul",
      2 -> "Rahul",
      3->  "Anup"
    )
    val user = users.get(5)
    println(user)

    def findUser(id: Int): Option[String] = {
      val users = Map(
        1 -> "Mridul",
        2 -> "Rahul"
      )

      users.get(id)
    }
    findUser(1) match {
      case Some(name) =>
        println(s"User found: $name")

      case None =>
        println("User not found")
    }

    //useful Option method
    val name:Option[String]= Some("Mridul")
    val missing: Option[String]=None

    //getOrElse => provide a default value



    //Either: Handling failures with meaningful error messages
    //Either is one of the most important concepts for backend development in Scala.
    //Either[E, A]
    //Here:
    //- E is the error type.
    //- A is the success type.
    //It has two cases:
    //- Left(error) — failure.   scala use left for errors
    //- Right(value) — success   scala use right for success

    /*
         Why Either is valuable
            Consider an API that transfers points from one employee to another. Possible failures include:
            - UserNotFound
            - InsufficientPoints
            - TransferLimitExceeded
            - InvalidAmount
         You can model these errors explicitly instead of returning null, using arbitrary status codes, or throwing exceptions for ordinary business decisions.
     */

    def withdrawAmount(balance:Double,amount:Double):Either[String,Double]={
      if(amount<0)
        Left("Amount must be positive")
      else if(amount>balance)
        Left("Insufficient balance")
      else
        Right(balance-amount)
    }

    println(withdrawAmount(1000, 300)) //Right(700.0)
    println(withdrawAmount(1000, 1500)) //Left(Insufficient balance)
    println(withdrawAmount(1000, -100))  //Left(Amount must be positive)

    //Handling the result
    withdrawAmount(10000, 1500) match {
      case Right(newBalance) =>
        println(s"Withdrawal successful: $newBalance")

      case Left(error) =>
        println(s"Withdrawal failed: $error")
    }


    //Use a custom error type
   //Strings are fine for learning, but custom error types are more robust.

    sealed trait WithdrawalError
    case object InvalidAmount extends WithdrawalError
    case object InsufficientBalance extends WithdrawalError

    def withdrawBalance(balance:Double,amount:Double):Either[WithdrawalError,Double]={
      if(amount<0) Left(InvalidAmount)
      else if (amount>balance) Left(InsufficientBalance)
      else Right(balance-amount)
    }
    withdrawBalance(100000, 1500) match {
      case Right(balance) =>
        println(s"New balance: $balance")

      case Left(InvalidAmount) =>
        println("Enter a valid amount")

      case Left(InsufficientBalance) =>
        println("Not enough funds")
    }


  //map and flatmap with Either
    def validateAmount(amount:Double):Either[String,Double]=
      if(amount > 0) Right(amount)
      else Left("Amount must be positive")

    def calculateFee(amount:Double):Either[String,Double]=
      if(amount<=1000) Right(amount*0.01)
      else Left("Amount exceeds the fee calculation limit")

    val result=validateAmount(500).map(_*2)
    println("validate amount :  " + result)  //Right(1000.0)
    val result1= validateAmount(-10).map(_ * 2)
    println(result1)  //Left(Amount must be positive)

    //Using flatmap
    val res= validateAmount(500).flatMap{
      amount=>calculateFee(amount).map(fee=>amount-fee)
    }
    println(res) //Right(495.0)


    //for comprehension
    val res1= for{
      amount <- validateAmount(500)
      fee <- calculateFee(amount)
    } yield amount-fee
    println(res1)  //Right(495.0)



    //Try

    /*
       Try: Handling computations that throw exceptions
           Unlike Either, which usually represents an explicit business failure, Try is designed to capture the result of a computation that might throw a non-fatal exception.
           Its two cases are:
           - Success(value)
           - Failure(exception)
        Import it from scala.util.
     */
    import scala.util.Try

    val valid = Try("123".toInt)
    val invalid = Try("abc".toInt)

    println(valid)
    println(invalid)



    //Handling a Try
    import scala.util.{Try,Success,Failure}
    def parseNumber(input:String) :Try[Int]=
      Try(input.toInt)

    parseNumber("123") match
      case Success(number) => println(s"Parsed: $number")
      case Failure(error)  => println(s"Parsing failed : ${error.getMessage}")

  //useful Method
    val r = Try("abc".toInt)
    println(r.getOrElse(0)) //0
    println(r.toOption)       //None
    println(r.isSuccess)  //false
    println(r.isFailure)  //true

    //recover from failure
    val re=Try("abc".toInt)
      .recover {
        case _: NumberFormatException => 0
      }
    println(re) //Success(0)



    //Future: Handling asynchronous error
    /*
       In backend development, some operations take time:
         - Database queries
         - HTTP requests to external services
         - File operations
         - Calls to third-party APIs
         Scala's Future represents a result that may become available later. A Future can complete successfully or fail with an exception.
     */

    import scala.concurrent.Future
    import scala.concurrent.ExecutionContext.Implicits.global

    def fetchUser():Future[String]={
      Future{
        throw  new RuntimeException("Database unavailable")
        "Mridul"
      }
    }
    println(fetchUser()) //Future(<not completed>)

    //handle the failure with recover
    val userFuture=fetchUser()
    val recovered= userFuture.recover{
      case _ : RuntimeException=> "Guest"
    }


    //require and assert
    //Scala also provides two ways to check conditions.
    //require
    //Use require to validate a precondition, such as an argument supplied to a function.

    def calculateDiscount(price: Double): Double = {
      require(price >= 0, "Price cannot be negative")
      price * 0.10
    }
    //println(calculateDiscount(-120))
    //assert
    //Use assert to check an assumption or invariant that should hold if the program is working correctly.
    val balance = 1000
    assert(balance >= 0, "Balance should not be negative")
    //Difference: require validates inputs and preconditions. assert checks internal assumptions. Neither automatically converts a failure into a user-friendly API response.

    //Error handling in Play Framework
    //Your controller should distinguish between:
    //- A valid request with a user found → HTTP 200 OK
    //- A valid request with no user found → HTTP 404 Not Found
    //- An unexpected database failure → HTTP 500 Internal Server Error
    
  
    
  }
}
