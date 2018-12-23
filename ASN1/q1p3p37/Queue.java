package q1p3p37;

/**
 * queue implemented with linked list
 * @author Ajevan
 *
 * @param <Item> type of queue
 */
public class Queue<Item> {
	
	private Node first; //first in line
	private Node last; //last in line
	private int N; //number of elements in queue
	
	private class Node{
		Item item;
		Node next;
	}
	
	/**
	 * check if queue is empty
	 * @return boolean
	 */
	public boolean isEmpty() {
		return first == null;
	}
	
	/**
	 * return the size of the queue
	 * @return int
	 */
	public int size() {
		return N;
	}
	
	/**
	 * add elements to the queue
	 * @param item item to add to queue
	 */
	public void enqueue(Item item) {
		Node oldLast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		
		if(isEmpty()) {
			first = last;
		}
		else {
			oldLast.next = last;
		}
		N++;
		
	}
	
	/**
	 * remove element from the beginning of the line
	 * @return Item 
	 */
	public Item dequeue() {
		Item item = first.item;
		first = first.next;
		
		if(isEmpty()) {
			last = null;
		}
		N--;
		return item;
	}
	
	

}
