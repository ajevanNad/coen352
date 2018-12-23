//question 1.4.20

package q1p4p20;

import java.util.Scanner;

public class Bitonic {
	
	/**
	 * returns the index of an element that you are looking for in the array.
	 * returns -1 if not found.
	 * @param key element you are looking for
	 * @param a array in which to look for
	 * @return int the index of the element
	 */
	public static int search(int key, int[] a) {
		
		int low = 0;
		int high = a.length - 1;
		int mid = low + (high - low)/2;
		
		int ans = lowIndexOf(key, a, low, high);
		
		if(ans == -1) { //if -1 from looking in the 1st half, then there is a chance that it could be in the 2nd half
			ans = highIndexOf(key, a, mid + 1, high);
		}
		
		return ans;
	}
	
	/**
	 * return the index where the key is found. Taken from textbook (BinarySearch.rank).
	 * If key not found, returns -1. This method works only when array is in ascending order.
	 * @param key value looking for
	 * @param a array in which looking for key
	 * @param low index to start looking from in array
	 * @param high index to stop looking in array
	 * @return int index of the element
	 */
	public static int lowIndexOf(int key, int[] a, int low, int high) {
		
		while(low <= high) {
			int mid = low + (high - low)/2;
			
			if (key < a[mid]) {
				high = mid - 1;
			}
			else if(key > a[mid]) {
				low = mid + 1;
			}
			else {
				return mid;
			}
		}
		return -1;
	}
	
	/**
	 * return the index where the key is found. Taken from textbook (BinarySearch.rank).
	 * If key not found, returns -1. This method works only when array is in descending order.
	 * @param key value looking for
	 * @param a array in which looking for key
	 * @param low index to start looking from in array
	 * @param high index to stop looking in array
	 * @return int index of the element
	 */
	public static int highIndexOf(int key, int[] a, int low, int high) {
		
		while(low <= high) {
			int mid = low + (high - low)/2;
			
			if (key > a[mid]) {
				high = mid - 1;
			}
			else if(key < a[mid]) {
				low = mid + 1;
			}
			else {
				return mid;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter array: ");
			String input = sc.nextLine();
			
			System.out.println("Enter number looking for: ");
			int target = sc.nextInt();
			
			String[] temp = input.split(","); //temporary String array used for processing elements to ints
			int[] a = new int[temp.length]; //array a ex: a = {1,2,3,4,5,15,10,9,8,7,6}
			
			for(int i =0; i < temp.length; i++) { //convert strings to ints for a
				a[i] = Integer.parseInt(temp[i]);
			}
			
			int indexFound = search(target, a);
			System.out.println("Element at index: " + indexFound);
		}
		catch(Exception e) {
			System.out.println("Invalid input");
		}
	}
}
