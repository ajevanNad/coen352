//question 1.4.12

package q1p4p12;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter first array: ");
		String input = sc.nextLine();
		
		String[] temp = input.split(","); //temporary String array used for processing elements to ints
		int[] a = new int[temp.length]; //array a ex: a = {1,2,4,5}
		
		for(int i =0; i < temp.length; i++) { //convert strings to ints for a
			a[i] = Integer.parseInt(temp[i]);
		}
		
		System.out.println("Enter second array: ");
		input = sc.nextLine();
		sc.close(); //close scanner
		
		temp = input.split(",");
		int[] b = new int[temp.length]; //array b ex: b = {1,3,5,6}
		
		for(int i =0; i < temp.length; i++) { //convert strings to ints for b
			b[i] = Integer.parseInt(temp[i]);
		}
		
		try { //if the 2 arrays are not the same size, throw exception
			if(a.length != b.length) {
				throw new Exception();
			}
		
		
			int N = a.length; //since both arrays have the same size, doesn't matter which array size we take
			String output = "{ "; //to hold elements of both arrays in sorted order to print
			
			int indexA = 0; //current head in array a
			int indexB = 0; //current head in array b
			
			while(indexA < N || indexB < N) {
				
				//if end of array a is reached, do rest of b
				if(indexA == N) {
					output += b[indexB] + " ";
					indexB++;
				}
				
				// if end of array b is reached, do rest of a
				else if(indexB == N){
					output += a[indexA] + " ";
					indexA++;
				}
				
				else if(a[indexA] < b[indexB]) {
					output += a[indexA] + " ";
					indexA++;
					
				}
				else {
					output += b[indexB] + " ";
					indexB++;
				}
			}
			
			output += "}";
			System.out.println(output);
		
		}
		catch(Exception e) {
			System.out.println("Invalid input!");
		}

	}

}
