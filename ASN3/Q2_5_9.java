//question 2.5.9

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/**
 * data type to sort a file such as that in this question.
 * heapsort code taken from textbook.
 * @author Ajevan
 *
 */
public class Q2_5_9 {
	
	public static void sort(String[] a) {
		//N is one less than the array length since we don't use index 0
		int N = a.length-1;
		
		for(int k=N/2; k>=1; k--) {
			sink(a, k, N);
		}
		
		while(N > 1) {
			exch(a, 1, N--);
			sink(a, 1, N);
		}
	}
	
	private static void exch(String[] a, int i, int j) {
		String t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
	private static boolean less(String[] a, int i, int j) {
		/*
		 * ex: 	1-Oct-28 3500000
		 * 		2-Oct-28 3850000 <-- if these were in the file
		 * then look at only 3500000 and 3850000 to determine if one is less than the other 
		 */
		return Long.valueOf(a[i].replaceAll("^\\d+-[a-zA-z]+-\\d+\\s+(\\d+)", "$1"))
				.compareTo(Long.valueOf(a[j].replaceAll("^\\d+-[a-zA-z]+-\\d+\\s+(\\d+)", "$1"))) < 0;
	}
	
	private static void sink(String[] a, int k, int N) {
		while(2*k <= N) {
			int j = 2*k;
			
			if(j < N && less(a, j, j+1)) { //check other child, take other child if greater
				j++;
			}
			
			if(!less(a, k, j)) {
				break;
			}
			
			exch(a, k, j);
			k = j;
		}
	}

	public static void main(String[] args) {
		
		try {
			int lines = 0; //number of lines in file
			File inputFile = new File("input.txt");
			Scanner sc = new Scanner(inputFile);
			
			//get number of lines in file
			while(sc.hasNextLine()) {
				sc.nextLine();
				lines++;
			}
			sc.close();
			
			String[] volumes = new String[lines+1]; //need to make array size plus one since won't be using index 0
			int index = 1;
			sc = new Scanner(inputFile);
			
			//fill volumes array with content from file
			while(sc.hasNextLine()) {
				volumes[index++] = sc.nextLine();
			}
			sc.close();
			
			Q2_5_9.sort(volumes);
			
			FileWriter filewriter = new FileWriter("output.txt");
			BufferedWriter bufferedwriter = new BufferedWriter(filewriter);
			
			for(int i = 1; i < volumes.length; i++) {
				bufferedwriter.write(volumes[i]);
				bufferedwriter.newLine();
			}
			
			bufferedwriter.close();
					
		}
		catch(Exception ex) {
			System.out.println("File error!");
		}

	}

}
