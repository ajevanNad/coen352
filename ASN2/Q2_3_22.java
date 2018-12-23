//Question 2.3.22

import java.util.Random;
import java.util.Scanner;

public class Q2_3_22 {
	
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
		
		try {
			System.out.println("Enter a string seperated by spaces: ");
			Scanner sc = new Scanner(System.in);
			String rawInput = sc.nextLine();
			String[] input = rawInput.split(" ");
			
			Q2_3_22.sort(input);
			System.out.println("Sorted string is ");
			
			for(int i=0; i<input.length; i++) {
				System.out.print(input[i] + " ");
			}
		}
		catch(Exception ex) {
			System.out.println("Invalid!");
		}

	}

}
