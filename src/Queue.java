
/**
 * 
 * A class that implements a queue.  It is your job to complete this class.  Your queue
 * will use a linked list constructed by QueueElements.  However, your queue must be general and allow
 * setting of any type of Object.  Also you cannot use ArrayLists or arrays (you will get zero).  
 * @author you
 *
 */


import java.util.NoSuchElementException;
import java.util.LinkedList;

public class Queue<T> {

	LinkedList<T> queue = new LinkedList<T>();


	/**
	 * Constructs an empty Queue.
	 */
	public Queue () {
	    //TODO: Write the Queue constructor
	}

	/**
	 * Returns true if the queue is empty
	 */
	public boolean isEmpty () {
		return queue.isEmpty();
	}


	/**
	 * Returns the element at the head of the queue
	 */
	public T peek () throws NoSuchElementException {
		return queue.getFirst(); //DELETE AND CHANGE TO SOMETHING SENSIBLE
	}

	/**
	 * Removes the front element of the queue
	 */
	public void dequeue () throws NoSuchElementException {
		queue.removeFirst();
	}

	/**
	 * Puts an element on the back of the queue.
	 */
	public void enqueue (T element) {
	    //Enqueue code is needed here
		queue.addLast(element);
	}

	/**
	 * Method to print the full contents of the queue in order from head to tail.
	 */
	public void print () {
		for(var i = 0; i < queue.size(); i++){
			System.out.println(queue.get(i));
		}
	}
}
