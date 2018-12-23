//question 1.4.14

package q1p4p14;

import java.util.Arrays;
import java.util.Scanner;

public class Sum4 {
	
	/**
	 * return the index where the key is found. Taken from textbook (BinarySearch.rank).
	 * If key not found, returns -1
	 * @param key value looking for
	 * @param a array in which looking for key
	 * @return int index of key
	 */
	public static int indexOf(int key, int[] a) {
		int low = 0;
		int high = a.length - 1;
		
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
	 * return number of combinations that sum to target sum.
	 * Also, prints all combinations to console.
	 * @param targetSum sum that 4 numbers should add up to
	 * @param a array to use 
	 * @return int number of combinations
	 */
	public static int sumF(int targetSum, int[] a) {
		Arrays.sort(a);
		
		int count = 0; //number of 4 nums that add up to targetSum
		int N = a.length; //number of elements in array
		String combo = ""; //save the various combinations that sum to targetSum
		
		for(int i = 0; i < N; i++) {
			for(int j = i + 1; j < N; j++) {
				for(int k = j + 1; k < N; k++) {
					int matchIndex = indexOf(targetSum - a[i] - a[j] - a[k], a);
					if(matchIndex > k) {
						count++;
						combo += a[i] + "," + a[j] + "," + a[k] + "," + a[matchIndex] + '\n'; 
					}
				}
			}
		}
		
		System.out.println(combo);
		return count;
	}

	public static void main(String[] args) {
		
		try {
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter array: ");
			String input = sc.nextLine();
			
			System.out.println("Enter target sum: ");
			int targetSum = sc.nextInt();
			
			String[] temp = input.split(","); //temporary String array used for processing elements to ints
			int[] a = new int[temp.length]; //array a ex: a = {1,2,3,4,5}
			
			for(int i =0; i < temp.length; i++) { //convert strings to ints for a
				a[i] = Integer.parseInt(temp[i]);
			}
			
			int count = sumF(targetSum, a);
			System.out.println("\nTotal number of 4 nums that sum to target sum: " + count);
		}
		catch(Exception e) {
			System.out.println("Invalid input!");
		}
		
	}
}
