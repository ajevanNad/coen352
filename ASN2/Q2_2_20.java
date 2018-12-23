//question 2.2.20
//mergesort related code taken from textbook.

import java.util.Random;
import java.util.Scanner;

/**
 * merge sort that doesn't rearrange the array, instead returns int array perm of the indices,
 * such that perm[i] is the ith smallest entry.
 * merge sort code from textbook.
 * @author Ajevan
 *
 */
public class Q2_2_20 {
	
	private static int[] perm; //array with sorted indices
	private static int[] permaux; //extra array used for merging indices
	
	
	/**
	 * check if v less than w.
	 * taken from textbook.
	 * @param v
	 * @param w
	 * @return boolean
	 */
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}
	
	/**
	 * merge two subarrays. 
	 * Taken from textbook.
	 * @param a
	 * @param lo
	 * @param mid
	 * @param hi
	 */
	public static void merge(Comparable[] a, int lo, int mid, int hi) {
		int i = lo;
		int j = mid + 1;
		
		//make a copy of perm
		for(int k=lo; k <= hi; k++) {
			permaux[k] = perm[k];
		}
		
		for(int k=lo; k<= hi; k++) {
			if (i > mid) {
				perm[k] = permaux[j++];
			}
			
			else if(j > hi) {
				perm[k] = permaux[i++];
				
			}
			
			else if(less(a[permaux[j]], a[permaux[i]])) {
				perm[k] = permaux[j++];
				 
			}
			
			else {
				perm[k] = permaux[i++];
			}
		}
	}
	
	/**
	 * sort method to be used by the client
	 * @param a array that is to be sorted
	 * @return perm array with the sorted indices
	 */
	public static int[] sort(Comparable[] a) {
		perm = new int[a.length];
		permaux = new int[a.length];
		
		//initialize indices
		for (int i =0; i<a.length; i++) {
			perm[i] = i;
		}
		
		sort(a, 0, a.length - 1);
		
		return perm;
	}
	
	private static void sort(Comparable[] a, int lo, int hi) {
		if (hi <= lo) {
			return ;
		} 
		
		int mid = lo + (hi - lo)/2;
		
		sort(a, lo, mid); //sort left half
		sort(a, mid + 1, hi); //sort right half
		merge(a, lo, mid, hi); //merge the 2 halves
	}

	public static void main(String[] args) {
		
		try {
			System.out.println("Enter the array size: ");
			Scanner sc = new Scanner(System.in);
			int size = sc.nextInt();
			
			Integer[] a = new Integer[size];
			
			//create instance of random class
			Random rand = new Random();
			
			for(int i = 0; i < size; i++) {
				//generate random elements in the range of 0 to 19
				a[i] = rand.nextInt(20); 
			}
			
			System.out.println("Original Array");
			System.out.print("[ ");
			for (int i=0; i < a.length; i++) {
				System.out.print(a[i] + " ");
			}
			System.out.print("]\n");
			
			int[] sorted = Q2_2_20.sort(a);
			
			System.out.println("Perm");
			System.out.print("[ ");
			
			for (int i=0; i < sorted.length; i++) {
				System.out.print(sorted[i] + " ");
			}
			System.out.print("]\n");
		
		}
		catch(Exception ex) {
			System.out.println("Invalid input!");
		}

	}

}
