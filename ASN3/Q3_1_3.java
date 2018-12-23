//question 3.1.3

/**
 * ordered symbol table with ordered linked list
 * @author Ajevan
 *
 * @param <Key>
 * @param <Value>
 */
public class Q3_1_3<Key extends Comparable<Key>, Value> {
	
	private Node first;
	
	private class Node{
		//linked list node
		Key key;
		Value val;
		Node next;
		
		Node(Key key, Value val, Node next) {
			this.key = key;
			this.val = val;
			this.next = next;
		}
	}
	
	public Value get(Key key) {
		//search for key, return associated value
		for(Node x = first; x != null; x = x.next) {
			if(key.equals(x.key)) {
				return x.val;
			}
		}
		return null;
	}
	
	public void delete(Key key) {
		//find key and delete it
		
		//if the key to delete is the first key in the table
		if(first != null && key.equals(first.key)) {
			first = first.next;
			return;
		}
		
		//look for key in the table and delete it
		for(Node x = first; x != null; x = x.next) {
			if(x.next != null && key.equals(x.next.key)) {
				x.next = x.next.next;
				return;
			}
		}
	}
	
	public void put(Key key, Value val) {
		//search for key, update value if found; grow table if new
		
		//if the key being added is smaller than the first key
		if(first != null && key.compareTo(first.key) < 0) {
			first = new Node(key, val, first);
			return;
		}
		
		for(Node x = first; x != null; x = x.next) {
						
			if(key.equals(x.key)) {
				x.val = val;
				return;
			}
			
			//if the key being added is in between two keys, have to add the key in between them
			else if(x.next != null && key.compareTo(x.next.key) < 0) {
				x.next = new Node(key, val, x.next);
				return;
			}
			
			//if the key goes at the end of the table
			else if(x.next == null) {
				x.next = new Node(key, val, x.next);
				return;
			}
		}
		
		//if this is the first key being added to the table
		first = new Node(key, val, first);
	}
	
	public void print() {
		for(Node x = first; x != null; x = x.next) {
			System.out.println(x.key + " = " + x.val);
		}
	}

	public static void main(String[] args) {
		Q3_1_3<String, Integer> st = new Q3_1_3<String, Integer>();
		
		try {
			st.put("B", 10);
			st.put("A", 12);
			st.put("T", 4);
			st.put("Z", 34);
			st.put("J", 20);
					
			st.print();
			System.out.println("Change value of B to 21");
			st.put("B", 21);
			st.print();
			
			System.out.println("Get the value of T: " + st.get("T"));
			
			System.out.println("Deleting B");
			st.delete("B");
			st.print();
		}
		catch(Exception ex) {
			System.out.println("Invalid!");
		}
		
	}

}
