//Question 2.3.12

import java.util.Random;

/**
 * entropy optimal quicksort.
 * Taken from textbook.
 * @author Ajevan
 *
 */
public class Q2_3_12 {
	
	/**
	 * swaps two elements
	 * @param a array
	 * @param i 
	 * @param j
	 */
	private static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j]; 
		a[j] = t;
	}
	
	/**
	 * shuffle the array
	 * @param a array
	 */
	private static void shuffle(Comparable[] a) {
		Random rand = new Random(); //create instance of random class
		
		for(int i = 0; i < a.length; i++) {
			int index = rand.nextInt(a.length); //generate random index within array to swap with
			exch(a, i, index);
		}
	}
	
	/**
	 * print the trace of entropy-optimal quicksort
	 * @param lt
	 * @param i
	 * @param gt
	 * @param a
	 */
	private static void print(int lt, int i, int gt, Comparable[] a) {
		System.out.print(lt + " ");
		System.out.print(i + " ");
		System.out.print(gt + " ");
		
		for (int j = 0; j < a.length; j++) {
			System.out.print(a[j] + " ");
		}
		
		System.out.print("\n");
	}
	
	/**
	 * sort method that the client will use to sort an array
	 * @param a
	 */
	public static void sort(Comparable[] a) {
		shuffle(a); //eliminate dependence on input
		sort(a, 0, a.length - 1);
	}
	
	private static void sort(Comparable[] a, int lo, int hi) {
		if (hi <= lo) {
			return;
		}
		
		int lt = lo;
		int i = lo + 1;
		int gt = hi;
		Comparable v = a[lo];
		
		while (i <= gt) {
			
			print(lt, i, gt, a); //print trace of array's current state
			
			int cmp = a[i].compareTo(v);
			
			//if less than v
			if(cmp < 0) {
				exch(a, lt++, i++);
			}
			
			//if greater than v
			else if(cmp > 0) {
				exch(a, i, gt--);
			}
			
			//if equal to v
			else {
				i++;
			}
		} //Now a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi
		
		sort(a, lo, lt - 1); //sort left third
		sort(a, gt + 1, hi); //sort right third
	}

	public static void main(String[] args) {
		
		String[] input = {"B", "A", "B", "A", "B", "A", "B", "A", "C", "A", "D", "A", "B", "R", "A"};
		
		System.out.println("lt i gt 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14");
		System.out.println("--------------------------------------------");
		Q2_3_12.sort(input);

	}

}
