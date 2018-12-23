package q1p3p9;

/**
 * Stack implemented with linked list
 * @author Ajevan
 *
 * @param <Item> type of stack ex:String
 */
public class LinkedStack<Item> {
	
	private class Node{
		Item val;
		Node next;
	}
	
	private Node first;
	
	/**
	 * checks if the list is empty
	 * @return boolean
	 */
	public boolean isEmpty() {
		return first == null;
	}
	
	/**
	 * pushes item onto the stack
	 * @param val value to push
	 */
	public void push(Item val) {
		Node oldFirst = first;
		first = new Node();
		first.val = val;
		first.next = oldFirst;
	}
	
	/**
	 * pop the last item (LIFO)
	 * @return item
	 */
	public Item pop() {
		if (isEmpty()) {
			return null;
		}
		Item val = first.val;
		first = first.next;
		return val;
	}

}
