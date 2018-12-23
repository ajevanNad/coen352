import java.util.Random;
import java.util.Scanner;

//Question 2.4.29

/**
 * data type with insert, delete the max, delete the min, all in log time;
 * find the max, find the min, both in constant time;
 * using two heaps
 * @author Ajevan
 *
 * @param <Key>
 */
public class Q2_4_29<Key extends Comparable<Key>> {
	
	MaxPQ maxPQ; //priority queue with max at top
	MinPQ minPQ; //priority queue with min at top
	
	public Q2_4_29(int maxN) {
		maxPQ = new MaxPQ<Key>(maxN);
		minPQ = new MinPQ<Key>(maxN);
		
	}
	
	public void insert(Key v) {
		maxPQ.insert(v);
		minPQ.insert(v);
	}
	
	public Key delMax() {
		return (Key) maxPQ.delMax();
	}
	
	public Key delMin() {
		return (Key) minPQ.delMin();
	}
	
	public Key findMax() {
		return (Key) maxPQ.findMax();
	}
	
	public Key findMin() {
		return (Key) minPQ.findMin();
	}
	
	public int size() {
		return maxPQ.size();
	}

	public static void main(String[] args) {
		
		try {
			System.out.println("Enter the size of the heap: ");
			Scanner sc = new Scanner(System.in);
			int size = sc.nextInt();
			
			Q2_4_29<Integer> heap = new Q2_4_29<Integer>(size);
			
			//create instance of random class
			Random rand = new Random();
			
			System.out.println("Original Heap");
			
			for(int i=0; i < size; i++) {
				//add random number in the range 0 to 19 to the heap
				int num = rand.nextInt(20);
				heap.insert(num);
				System.out.print(num + " ");
			}
			
			System.out.print("\n");
			System.out.println("Count of items in heap: " + heap.size());
			System.out.println("Maximum item in heap: " + heap.findMax());
			System.out.println("Minimum item in heap: " + heap.findMin());
			System.out.println("Delete items from heap in natural order");
			
			//delete half in natural order
			for(int i = 0; i < size/2; i++) {
				System.out.print(heap.delMin() + " ");
			}
			
			System.out.print("\n");
			System.out.println("Delete items from heap in reverse order");
			
			//delete the rest in reverse order
			for(int i = 0; i < size - size/2; i++) {
				System.out.print(heap.delMax() + " ");
			}
		}
		catch(Exception ex) {
			System.out.println("Invalid input!");
		}

	}

}
