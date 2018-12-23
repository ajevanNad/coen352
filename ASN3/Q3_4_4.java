import java.util.ArrayList;
import java.util.Scanner;

//question 3.4.4

/**
 * finds a and M for the hash function (a*k)%M for S E A R C H X M P L with the smallest M to produce distinct values
 * @author Ajevan
 *
 */
public class Q3_4_4 {
	
	//array to keep track of the hash values so can check if there is collision
	private ArrayList<Integer> hashList = new ArrayList<Integer>();
	public int mSize; // M
	public int aIndex; //index to use in primes array as value of a
	
	//array with prime numbers, since prime numbers usually better for hashing
	public final int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 
			71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 
			173, 179, 181, 191, 193, 197, 199, 251,509,1021,2039,4093,8191,16381,32749,65521,131071,262139,
			524287,1048573,2097143,4194301,8388593,16777213,33554393,67108859,134217689,268435399,536870909,
			1073741789,2147483647};
	
	/**
	 * get value of a
	 * @return
	 */
	public int getA() {
		return primes[aIndex];
	}
	
	/**
	 * get value of M
	 * @return
	 */
	public int getM() {
		return mSize;
	}
	
	/**
	 * hash function being used
	 * @param k key
	 * @param a value of a
	 * @param M value of M
	 * @return hash value
	 */
	private int hash(String k, int a, int M) {
		return (a * k.hashCode()) % M;
	}
	
	/**
	 * method to find a and M so that M is smallest
	 * @param in
	 */
	public void findHash(String[] in) {

		mSize = in.length;
		aIndex = 0;
		boolean foundans = false; //to know if we have found a good a and M, if true, then we have found it
		
		while(!foundans) {
			while(aIndex < primes.length && !foundans) { //go through all the possible a, while keeping same M
			
				for(int i = 0; i < in.length; i++) {
					int hashval = hash(in[i], primes[aIndex], mSize); 
					
					//check if there collision
					if(!hashList.isEmpty() && hashList.contains(hashval)) {
						hashList.clear();
						break;
					}
					hashList.add(hashval);
					
					//if reached this point, then means have found hash collision free
					if(i == in.length - 1) {
						foundans = true;
					}
				}
				
				if(!foundans) {
					aIndex++;
				}
				
			}
						
			if(!foundans) {
				mSize++;
				aIndex = 0;
			}
		}
		
	}

	public static void main(String[] args) {
		
		try {
			System.out.println("Enter the Keys separated by spaces: ");
			Scanner sc = new Scanner(System.in);
			String rawInput = sc.nextLine();
			String[] input = rawInput.split(" ");
			
	//		String[] input = {"S", "E", "A", "R", "C", "H", "X", "M", "P", "L"};
			
			Q3_4_4 perfectHash = new Q3_4_4();
			perfectHash.findHash(input);
			
			System.out.print("Output: a = " + perfectHash.getA() + ", M = " + perfectHash.getM());
		}
		catch(Exception ex) {
			System.out.println("Invalid!");
		}

	}

}
