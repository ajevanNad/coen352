//question 2.2.12

import java.util.Random;
import java.util.Scanner;

/**
 * merge sort that uses M extra space instead of N and selection sort on block of M.
 * merge code taken from textbook.
 * assumes N is a multiple of M.
 * @author Ajevan
 *
 */
public class Q2_2_12 {
	
	private static Comparable[] aux; //extra array used for merging, where at max is size N/M
	private static int block; //M - size of the block
	
	
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
	 * merge two subarrays using at most N/M sized extra array 
	 * @param a array
	 * @param lo
	 * @param mid
	 * @param hi
	 */
	public static void merge(Comparable[] a, int lo, int mid, int hi) {
		int i = lo; //index of left half
		int j = mid + 1; //index of right half
		int l = 0; //index of extra array
		
		aux = new Comparable[mid - lo + 1]; //extra array with N/M size at most 
		
		//make a copy of left half of a
		for(int k=lo; k <= mid; k++) {
			aux[l++] = a[k];
		}
		
		l = 0; //reset index in aux to 0
		
		for(int k=lo; k<= hi; k++) {
			if (i > mid) {
				a[k] = a[j++];
			}
			
			else if(j > hi) {
				a[k] = aux[l++];
				i++;
			}
			
			else if(less(a[j], aux[l])) {
				a[k] = a[j++];				 
			}
			
			else {
				a[k] = aux[l++];
				i++;
			}
		}
	}
	
	/**
	 * selection sort modified to work with merge sort, it will sort within its M block
	 * taken from textbook
	 * @param a
	 * @param lo
	 * @param hi
	 */
	public static void selsort(Comparable[] a, int lo, int hi) {

		for(int i = lo; i <= hi; i++) {
			int min = i;
			
			for(int j = i + 1; j <= hi; j++) {
				//exchange a[i] with smallest entry
				if(less(a[j], a[min])) {
					min = j;
				}
			}
			exch(a, i, min);
		}
	}
	
	/**
	 * sort method to be used by the client
	 * @param a array to be sorted
	 * @param M block size
	 */
	public static void sort(Comparable[] a, int M) {
		
		block = M;
		sort(a, 0, a.length - 1);
	}
	
	private static void sort(Comparable[] a, int lo, int hi) {
		if (hi <= lo) {
			return ;
		} 
		
		//if the current block size is M, then use selction sort on it
		if((hi - lo) + 1 == block*2) {
			int selmid = lo + (hi - lo)/2; //index of the middle within the selection sort
			selsort(a, lo, selmid); //selction sort the left half
			selsort(a, selmid + 1, hi); //selction sort the right half
			merge(a, lo, selmid, hi); //merge the 2 halves
		}
		
		else {
			int mid = lo + (hi - lo)/2; //index of middle
			sort(a, lo, mid); //sort left half
			sort(a, mid + 1, hi); //sort right half
			merge(a, lo, mid, hi); //merge the 2 halves
		}
	}

	public static void main(String[] args) {
		
		try {
			System.out.println("Enter the size of the array: ");
			Scanner sc = new Scanner(System.in);
			int size = sc.nextInt();
			
			System.out.println("Enter the size of the block: ");
			int M = sc.nextInt();
			
			Integer[] a = new Integer[size];
			
			//create instance of random class
			Random rand = new Random();
			
			for(int i = 0; i < size; i++) {
				//generate random elements in the range of 0 to 19
				a[i] = rand.nextInt(20); 
			}
			
			System.out.println("Original Array");
			for (int i=0; i < a.length; i++) {
				System.out.print(a[i] + " ");
			}
			System.out.print("\n");
			
			Q2_2_12.sort(a,M);
			
			System.out.println("Sorted array");
			for (int i=0; i < a.length; i++) {
				System.out.print(a[i] + " ");
			}
			System.out.print("\n");
		
		}
		catch(Exception ex) {
			System.out.println("Invalid input!");
		}

	}
	
}
