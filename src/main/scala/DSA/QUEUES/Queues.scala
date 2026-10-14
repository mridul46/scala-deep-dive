package DSA.QUEUES

import scala.collection.immutable.Queue
//Queue is a data structure that follows the FIFO (First in ,First out) principle
/*

    Queue is the collection type.
    numbers is a queue containing four integers.
    val means the variable cannot be reassigned.
    The immutable queue itself cannot be modified in place.
 */
/*
     When are Queues useful?
        - Task scheduling: Process jobs in arrival order.
        - Breadth-First Search (BFS): Visit graph nodes level by level.
        - Message processing: Handle incoming messages in order.
        - Request handling: Process requests in a first-in, first-out sequence.
 */
object Queues {
  def main (args:Array[String]):Unit={
    val num= Queue(10,20,30,40)
    println(s"queue of number are : $num") //Queue(10, 20, 30, 40)
    //Enqueue- Add an element
    val q1= Queue(10,20,30)
    val q2= q1.enqueue(80)
    println(q2) //Queue(10, 20, 30, 80)

    //Dequeue - remove the front element
   // The dequeue operation returns a pair :
   //   -first —the removed front element
   //  -remaining —the queue after removing that element
   // Important: dequeue on an empty queue throws an exception.
    val q= Queue(9,8,7)
    println(q.head) //9
    val(first,remaining)=q.dequeue
    println(first) //9
    println(remaining) //Queue(8, 7)

  }
}
