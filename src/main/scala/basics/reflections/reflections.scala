package basics.reflections

/*
  Reflection is the ability of a program to inspect information about itself while it is running.

 */

class Employee(val name: String, val salary: Double) {
  def greet(): String = s"Hello, $name"

  def calculateBonus(): Double = salary * 0.10
}
object  reflections {
  def main(args:Array[String]):Unit ={
   //Normally you call a method directly:
   val employee = new Employee("Mridul", 30000.0)
    println(employee.greet()) //Hello,Mridul

    /*
    The exact name may include a package, depending on where the class is defined.
       Here:
       - employee is an object.
       - getClass returns its runtime Class object.
       - clazz provides metadata about the class.
     */
    val clazz = employee.getClass
    println(clazz.getName)  //basics.reflections.Employee


    println(clazz.getSimpleName)
    println(clazz.getDeclaredMethods.map(_.getName).mkString(", ")) //name, greet, salary, calculateBonus
    //discover methods dynamically
    //You can inspect the methods exposed by the class.
    /*
       getMethods returns public methods, including inherited public methods.
        Output are :
        name
        greet
        salary
        calculateBonus
        equals
        toString
        hashCode
        getClass
        notify
        notifyAll
        wait
        wait
        wait

     */
    clazz.getMethods.foreach { method =>
      println(method.getName)
    }

    //Invoke a method using reflection
    //This is where reflection becomes more powerful.
    /*
    Step by step:
                 1. employee.getClass obtains the runtime class.
                 2. getMethod("greet") finds the public, zero-argument method named greet.
                 3. invoke(employee) calls that method on the object.
                 4. The result is returned as an Object at the Java reflection API level.
     */
    val method = employee.getClass.getMethod("greet")
    val result = method.invoke(employee)
    println(result) //Hello, Mridul

    //Create an object dynamically
    //Reflection can load a class using its fully qualified name and instantiate it.
    //For a simple class with a public no-argument constructor:
//    val className = "com.example.Greeting"
//    val claz = Class.forName(className)
//    val instance = claz.getDeclaredConstructor().newInstance()
//    println(instance.getClass.getName)
  }
}
