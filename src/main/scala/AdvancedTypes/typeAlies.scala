package AdvancedTypes
/*
       A Type Alias gives an existing type a new, more meaningful name.
        It does not create a new type. It simply creates another name for an existing type.

        Syntax:    type AliasName = ExistingType
 */
/*
         Advantages
                  ✅ Improves readability
                  ✅ Reduces repetition
                  ✅ Gives meaningful names to complex types
                  ✅ Makes function signatures easier to understand
                  ✅ Works with collections, functions, tuples, Option, Either, etc.

                  Limitations
                     A type alias does not provide extra type safety.

                     For example:

                     type UserId = Int
                     type ProductId = Int
                     val user: UserId = 101
                     val product: ProductId = user

                     This compiles because both are aliases for Int.

                     If you need the compiler to distinguish them, use a case class or another custom type.
 */
/*
                  | Feature              | Type Alias            | Case Class              |
               | -------------------- | --------------------- | ----------------------- |
               | Creates a new type   | ❌ No                  | ✅ Yes                   |
               | Improves readability | ✅ Yes                 | ✅ Yes                   |
               | Extra type safety    | ❌ No                  | ✅ Yes                   |
               | Runtime overhead     | ❌ No                  | Small object allocation |
               | Best for             | Naming existing types | Modeling domain objects |

 */
object typeAlies {
  def main(args:Array[String]):Unit ={
    //basic examples
    type UserId = Int
    val id: UserId = 101
    println(s"user id is : ${id}")

    //Why use Type Aliases? : Suppose your application uses many String values:Using aliases makes the code more readable:
    type Email = String
    type Phone = String
    type Address = String

    val email: Email = "abc@gmail.com"
    val phone: Phone = "9876543210"
    val address: Address = "Guwahati"
    println(s"Email is ${email}, phone is ${phone} and Address is ${address}")


    //Alias for collection
    //Map[String, Int]
    type Marks=Map[String,Int]
    val studentMarks:Marks=Map(
      "Math"->90,
      "Science" -> 95
    )
    println(studentMarks)


    //Alias for list
    type Employees = List[String]
    val names: Employees = List("Rahul", "Amit", "Priya")
    println(names)

    //Alias for function type
    //without alias
    val add: (Int, Int) => Int = (a, b) => a + b
    //With Alias
    type Calculator = (Int, Int) => Int
    val add1: Calculator = (a, b) => a + b
    println(add1(10, 20))


    //Alias for tuples
    type Employee = (Int, String)
    val emp: Employee =(101, "Rahul")
    println(emp)

    //Alias for Option
    type UserName = Option[String]
    val user: UserName = Some("Rahul")
    println(user)

    //Alias with Union Types (Scala 3)
    type Id = Int | String
    val id1: Id = 101
    val id2: Id = "EMP101"
    println(s"id1 is ${id1} , id2 is ${id2}")


    type EmployeeId = Int
    type Salary = Double
    type Employee1 = (String, Salary)

    val employees: Map[EmployeeId, Employee1] =
      Map(
        101 -> ("Rahul", 50000),
        102 -> ("Amit", 65000)
      )

    println(employees)


    //Alias for API Response
    //with Alias
    type ApiResponse = Either[String, List[String]]
    def getUsers(): ApiResponse = Right(List("Rahul", "Amit"))

    //without alias
   // def getUser(): Either[String, List[String]]

    //Real Play Framework Example
    //Without alias
    /*
    def getUser(
                 id: Int
               ): Future[Either[String, Option[User]]]
     */
    //with alias
    /*
           type UserId = Int
           type Result = Either[String, Option[User]]

           def getUser(
             id: UserId
           ): Future[Result]
     */
  }
}
