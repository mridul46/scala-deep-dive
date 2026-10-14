package basics.patternMatching_reflection

/*
    1. what is pattern matching?
      -pattern matching is compares a value against a series of patterns and executes the first matching case.
      -Scala uses the match keyword.

      How it works:
       1. Scala evaluates number.
       2. It checks the cases from top to bottom.
       3. case 1 does not match.
       4. case 2 matches, so Scala executes println("Two").
       5. The remaining cases are skipped.
       The underscore _ is a wildcard pattern. It matches any value not matched by an earlier case.
 */
object pattern {
  def main(args: Array[String]) = {
    //basic example
    val number = 2
    number match
      case 1 => println("One")
      case 2 => println("Two")
      case 3 => println("Three")
      case _ => println("other number")

    //pattern matching is an expression :  match can return a value, so you can assign the result to a variable.
    val num = 3
    val res = num match {
      case 1 => "one"
      case 2 => "two"
      case 3 => "three"
      case _ => "Unknown"
    }
    println("check : " + res)


    // pattern matching is often cleaner than writing several if-else statements.
    def dayType(day: String) :String=
      day match{
        case "Saturday" | "Sunday" => "Weekend"
        case "Monday" | "Tuesday" | "Wednesday" | "Thursday" | "Friday" => "Weekday"
        case _ => "Invalid day"
      }

    println("check the day : " + dayType("Monday"))

    // constant and variable pattern
    // A constant pattern matches a specific value
    def describe(n: Int): String =
      n match {
        case 0 => "Zero"
        case 1 => "One"
        case _ => "Other"
      }
    println("check describe : " +  describe(1))

    //variable pattern :  A variable pattern captures the matched value.
    //Unlike _, a variable pattern matches any value and makes that value available inside the case body.
    val result = 100 match {
      case x => s"Value is $x"
    }

    println("variable pattern "+result)

    //pattern match with guard
    //A guard is an additional Boolean condition introduced by if.
    def classify(n: Int): String =
      n match {
        case x if x < 0 => "Negative"
        case 0 => "Zero"
        case x if x > 0 && x % 2 == 0 => "Positive even"
        case _ => "Positive odd"
      }

    println(classify(-5)) // Negative
    println(classify(0)) // Zero
    println(classify(8)) // Positive even
    println(classify(7)) // Positive odd

    //pattern matching with option
    def getUserName(id:Int):Option[String]=
      if(id==1) Some("Mridul")
      else None

    def describeUser(id:Int):String=
      getUserName(id) match
        case Some(name) => s"User found $name"
        case None => "User not found"

    println(describeUser(1)) //User found Mridul
    println(describeUser(2)) //User not found

    //pattern matching with lists
    //scala lists have a recursion structure : Nil represents an empty list
    //head::tail represents the first element and the remaining list
    def describeList(numbers:List[Int]): String=
      numbers match
        case Nil => "Empty list"
        case head::Nil => s"one element present in the list :  $head"
        case head ::tail =>s"first element : $head , remaining element are : $tail"

    println(describeList(Nil)) // Empty list
    println(describeList(List(10))) // One element: 10
    println(describeList(List(10, 20, 30))) // First: 10, remaining: List(20, 30)

    //pattern matching with case class
    //Case classes work especially well with pattern matching because Scala can inspect their constructor fields.
    case class User(id:Int, name:String, active:Boolean)
    def describe1(user:User):String=
      user match
        case User(_,name,true)=> s"$name is active"
        case User(_,name,false)=> s"$name is inactive"

    println(describe1(User(1,"Mridul",true))) //Mridul is active
    println(describe1(User(1,"Mridul",false ))) //Mridul is inactive

    //pattern matching with enums
    //enums are useful when a value must represent one of a defined set of alternatives
    enum paymentStatus {
      case pending
      case completed
      case failed(reason:String)
    }

    def describe2(status: paymentStatus): String =
      status match {
        case paymentStatus.pending => "Payment is pending"
        case paymentStatus.completed => "Payment completed"
        case paymentStatus.failed(reason) => s"Payment failed: $reason"
      }
    println(describe2(paymentStatus.failed("Insufficient balance")))


    //Pattern matching on types
    //You can also match based on a value's runtime type.
    def describeValue(value: Any): String =
      value match {
        case n: Int => s"Integer: $n"
        case s: String => s"String: $s"
        case d: Double => s"Double: $d"
        case _ => "Other type"
      }

    println(describeValue(10)) // Integer: 10
    println(describeValue("Scala")) // String: Scala
    println(describeValue(3.14)) // Double: 3.14
  }
}