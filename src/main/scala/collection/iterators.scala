package collection


//An Iterator is an object that lets you traverse (iterate through) a collection one element at a time.

/*
  | Feature       | Iterator                       | List           |
| ------------- | ------------------------------ | -------------- |
| Stores data   | ❌ No                           | ✅ Yes          |
| Traversal     | One-time                       | Multiple times |
| Memory        | Low                            | Higher         |
| Random access | ❌ No                           | O(n)           |
| Mutable state | Yes (current position changes) | No             |

 */

/*
    | Feature                    | Iterator | Iterable |
| -------------------------- | -------- | -------- |
| Can iterate multiple times | ❌ No     | ✅ Yes    |
| Consumed after use         | ✅ Yes    | ❌ No     |
| Has `next()`               | ✅ Yes    | ❌ No     |
| Has `hasNext()`            | ✅ Yes    | ❌ No     |

 */


/*
    Time Complexity
    | Operation | Complexity |
| --------- | ---------- |
| `hasNext` | O(1)       |
| `next`    | O(1)       |
| `map`     | O(n)       |
| `filter`  | O(n)       |
| `find`    | O(n)       |
| `exists`  | O(n)       |
| `forall`  | O(n)       |
| `toList`  | O(n)       |

 */
/*
   When Should You Use an Iterator?

Use an Iterator when:

✅ Processing large collections one element at a time.
✅ Reading data from files, database cursors, or streams.
✅ You don't need to keep all data in memory.
✅ You only need a single pass through the data.

Avoid an Iterator when:

❌ You need to traverse the same data multiple times.
❌ You need random access to elements.
❌ You need to reuse the sequence after processing.
 */
object iterators {
def main (args:Array[String]):Unit ={
  //creating iterators
  val numbers = List(10, 20, 30)
  val it = numbers.iterator

  //hasNext(): Checks whether another elements exists
  println(it.hasNext)  //true

  //return next element
  println(it.next())
  //println(it.next())
  //println(it.next())

  println(it.hasNext)  //false


  //using while loop
  while (it.hasNext){
    println(it.next())
  }


  //foreach()
  numbers.iterator.foreach(println)



  //iterator methods
  //map()
  val its = List(1, 2, 3).iterator
  val result = its.map(_ * 2)
  println(result.toList)


  //filter()
  val it1 = List(1, 2, 3, 4, 5).iterator
  println(it1.filter(_ % 2 == 0).toList)


  //take()
  val num=List(1,2,3,4,5,6).iterator
  println(num.take(2).toList)

  //drop
  println(num.drop(2).toList)

  //exists()
  println(num.exists(_ == 4)) // it gives false : toList consumes the iterator completely. After that, the iterator is exhausted, so exists has no elements to examine and returns false.
  /*
      Rule to remember:
                       List, Vector, Set, Map → Reusable, immutable collections.
                       Iterator → Single-use, stateful cursor. Once elements are consumed, they cannot be read again.
   */

  //forall()
  val it2 = List(2, 4, 6).iterator
  println(it2.forall(_ % 2 == 0))  //it gives true for all element are divisible by 2


  //find()
  val a = List(10, 20, 30).iterator
  println(a.find(_ > 15)) //Some(20)


  //contains
  val b = List(10, 20, 30).iterator
  println(b.contains(20)) //true


  //mkString()
  val c = List(1, 2, 3).iterator
  println(c.mkString(",")) //1,2,3


 //Convert Iterator to Collections
  //iterator -> List
 val d = Iterator(1,2,3)
  println(d.toList)   //List(1, 2, 3)


  //Iterator → Vector
  val e = Iterator(1, 2, 3)
  println(e.toVector)  //Vector(1, 2, 3)


  //Creating Iterator Directly
  val f = Iterator(10, 20, 30, 40)
  println(f.toList)


  //iterator is consumed


  case class Employee(id: Int, name: String)
  val employees = List(
      Employee(1, "Rahul"),
      Employee(2, "Amit"),
      Employee(3, "Priya")
    )

  val g = employees.iterator
  while (g.hasNext) {
    val emp = g.next()
    println(emp.name)
  }

//Each call to iterator creates a new iterator.
  val list = List(1, 2, 3)

  val x = list.iterator
  val y = list.iterator

  println(x.next()) // 1
  println(y.next()) // 1
  }
}
