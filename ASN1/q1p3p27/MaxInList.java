//question 1.3.27

package q1p3p27;

public class MaxInList {
	
	private class Node{
		int val;
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
	public void push(int val) {
		Node oldFirst = first;
		first = new Node();
		first.val = val;
		first.next = oldFirst;
		N++;
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
				s = s + ", " + node.val;
			}
			else {
				s += node.val;
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
	
	/**
	 * finds the maximum key in the list.
	 * @param firstNode reference to the the first node
	 * @return int max key
	 */
	public int max(Node firstNode) {
		int max = 0;
		
		while(firstNode != null) {
			if(max < firstNode.val) {
				max = firstNode.val;
			}
			
			firstNode = firstNode.next;
		}
		
		return max;
	}
	
	

	public static void main(String[] args) {
		MaxInList list = new MaxInList();
		list.push(1);
		list.push(24);
		list.push(12);
		
		int maxKey = list.max(list.first);
		System.out.println("The max key is " + maxKey);

	}

}
