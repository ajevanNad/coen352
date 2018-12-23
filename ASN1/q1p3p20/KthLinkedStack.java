//question 1.3.20

package q1p3p20;

/**
 * Linked stack with method delete
 * @author Ajevan
 *
 * @param <Item> stack type
 */
public class KthLinkedStack<Item> {
	
	private class Node{
		Item val;
		Node next;
	}
	
	private Node first;
	private int N=0; //number of items
	
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
		N++;
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
		N--;
		return val;
	}
	
	/**
	 * returns the size of the linked list
	 * @return int
	 */
	public int size() {
		return N;
	}
	
	/**
	 * print the list
	 */
	public void print() {
		Node node = first;
		String s = "{";
		boolean comma = false;
		
		while(node != null) {
			if(comma) {
				s = s + ", " + node.val + " @" + node;
			}
			else {
				s += node.val + " @" + node;
				comma = true;
			}
			
			node = node.next;
		}
		s += "}";
		System.out.println(s);
	}
	
	/**
	 * deletes the kth element in the linked list
	 * @param k int 
	 */
	public void delete(int k) {
		if (k > size() || k < 1) {
			return ;
		}
		
		Node newNode = first;
		
		for (int i = 1; i <= k-2; i++) {
			newNode = newNode.next;
		}
		
		if(k == 1) { //if deleting the first element
			first = newNode.next;
		}
		else if(newNode.next.next == null) { //if deleting the last element
			newNode.next = null;
		}
		else {
			newNode.next = newNode.next.next; //if deleting in between the list
		}
	}

	public static void main(String[] args) {
		KthLinkedStack<String> t = new KthLinkedStack<String>();
		t.print();
		t.push("a");
		t.push("b");
		t.push("c");
		t.print();
		t.delete(1);
		t.print();
		t.push("c");
		t.print();
		t.delete(3);
		t.print();
		t.push("e");
		t.print();
		t.delete(2);
		t.print();

	}

}
