package foundation.higherOderFunction


/*
     Idempotent means:
        You can perform the same operation multiple times, and the final result is the same as performing it once.
 */

def upperCase(text:String):String={
  val characters=text.toArray
  for(i<-0 until text.length){
    characters(i)=characters(i).toUpper
  }
  new String(characters)
}

def lowerCase(text:String):String={
  val characters=text.toArray
  for(i<-0 until text.length){
    characters(i)=characters(i).toLower
  }
  new String(characters)
}
//Capture pattern
// A capture pattern is a pattern used in match that matches a values that gives
//that matched value a name so you can use it inside the case.

def map(text:String, update:Char=>Char):String={
  val characters=text.toArray
  for(i <-0 until text.length){
    characters(i)=update(characters(i))
  }
  new String(characters)
}
def upperCase1(text:String):String= map(text,c=>c.toUpper)
def lowerCase2(text:String):String= map(text,c=>c.toLower)

/*
     Iterator in scala
       An Iterator is an object that lets you process elements one at a time , instead of having all elements available as a collection at once.
 */
object input {
  def main(args:Array[String]):Unit={
   println("convert to upper case : " +  upperCase("Hello"))
   println("convert to lower case : " + lowerCase("MRIDUL"))
    println("convert to upper case : " + upperCase("Helloffgfdvfg"))
    println("convert to lower case : " + lowerCase("MRIDULdfSDFGFG"))
  }
}
