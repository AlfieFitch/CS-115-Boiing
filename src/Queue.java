
/**
 * 
 * A class that implements a queue. The Queue is general and allows setting of any datatype.
 * @author you
 *
 */


import java.util.NoSuchElementException;


public class Queue<T> {

	private QueueElement<T> head;

	/**
	 * Constructs an empty Queue.
	 */
	public Queue () {
		this.head = null;
	}

	/**
	 * Returns true if the queue is empty
	 */
	public boolean isEmpty () {
		return head == null;
	}


	/**
	 * Returns the element at the head of the queue
	 * If the queue is empty an error is thrown.
	 */
	public T peek () throws NoSuchElementException {
		if(head == null){
			throw new NoSuchElementException("Queue is empty");
		}else{
			return head.getElement();
		}
	}

	/**
	 * Removes the front element of the queue
	 * If the queue is empty an error is thrown.
	 */
	public void dequeue () throws NoSuchElementException {
		if(head == null){
			throw new NoSuchElementException("Queue is empty");
		}
		else{
			head = head.getNext();
		}
	}

	/**
	 * Puts an element on the back of the queue.
	 */
	public void enqueue (T element) {
		QueueElement<T> newElement = new QueueElement<T>(element, null);
		if(head == null){
			head = newElement;
		}else{
			QueueElement<T> temp = head;
			while(temp.getNext() != null){
				temp = temp.getNext();
			}
			temp.setNext(newElement);
		}
	}

	/**
	 * Method to print the full contents of the queue in order from head to tail.
	 */
	public void print () {
		if(head != null){
			QueueElement<T> temp = head;
			while(temp != null){
				System.out.println(temp.getElement());
				temp = temp.getNext();
			};
		}
	}
}
