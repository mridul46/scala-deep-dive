package AdvancedTypes


/*
            What are Intersection Types?
                      An Intersection Type allows a value to have multiple types at the same time.
                      It is written using the & (ampersand) operator.

                      A & B

                      This means:
                      The value must satisfy both type A and type B.

                      Think of it as the opposite of a Union Type.
                      Union (|) → Either A or B
                      Intersection (&) → Both A and B
 */
object intersections {
  def main(args:Array[String]):Unit ={
    //Basic Examples
    trait Printable {
      def print(): Unit
    }

    trait Savable {
      def save(): Unit
    }
    //implementation
    class Document extends Printable with Savable {

      def print(): Unit =
        println("Printing")

      def save(): Unit =
        println("Saving")
    }
    //function
    def process(doc: Printable & Savable): Unit = {
      doc.print()
      doc.save()
    }

    val document = new Document()

    process(document)


    //Backend Examples
    //Suppose a backend service must : Log operation and cache results
    trait Logger {
      def log(msg:String) :Unit
    }
    trait Cache {
      def put(key:String) :Unit
    }
    class UserService extends Logger with Cache {

      def log(msg: String): Unit =
        println(msg)

      def put(key: String): Unit =
        println(s"Cached: $key")
    }
    def process1(service: Logger & Cache): Unit = {

      service.log("Fetching User")

      service.put("user_101")
    }

    process1(new UserService())

    //Multiple Traits:Intersection types can combine more than two types
    trait A
    trait B
    trait C

    type ABC = A & B & C

    //Tpe Alias
    //type Service = Logger & Database
  }
}
