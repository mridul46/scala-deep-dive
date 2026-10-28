package basics.Iterator


/*
      In Scala, an Iterator is a collection-like object that lets you access elements one at a time. Unlike a List or Vector,
       an iterator is usually consumed as you traverse it.

      Think of an iterator like reading a book page by page: once you move to the next page,
      you don't automatically return to the previous one.

      These are the two most important iterator methods.
        - hasNext: checks whether another element exists.
        - next: retrieves the next element and advances the iterator.

      Why use hasNext()?
        It prevents you from calling next() when the iterator has no elements left.

      Other useful methods include:
        - map: transforms each element.
        - filter: keeps elements matching a condition.
        - foreach: performs an action on each element.
        - take(n): takes at most n elements.
        - drop(n): skips the first n elements.
        - toList: converts the remaining iterator elements into a list.
 */
object iterator {
  def main(args:Array[String]):Unit=


    //basic examples
    val numbers=List(10,20,30,40,50,60,70,80,90)
    val iterator=numbers.iterator
    println(iterator.next()) //10
    println(iterator.hasNext)//true
    println(iterator.nextOption()) //Some(20)
}
