import java.util.Scanner;

//question 3.1.1

/**
 * ordered symbol table.
 * symbol table code taken from textbook.
 * @author Ajevan
 *
 * @param <Key>
 * @param <Value>
 */
public class Q3_1_1<Key extends Comparable<Key>, Value>{
	
	private Key[] keys;
	private Value[] vals;
	private int N;
	
	public Q3_1_1(int capacity) {
		keys = (Key[]) new Comparable[capacity];
		vals = (Value[]) new Object[capacity];
	}
	
	public int size() {
		return N;
	}
	
	public Value get(Key key) {
		if(isEmpty()) {
			return null;
		}
		
		int i = rank(key);
		
		if(i < N && keys[i].compareTo(key) == 0) {
			return vals[i];
		}
		
		else {
			return null;
		}
	}
	
	public int rank(Key key) {
		int lo = 0;
		int hi = N-1;
		
		while(lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			int cmp = key.compareTo(keys[mid]);
			
			if(cmp < 0) {
				hi = mid - 1;
			}
			else if(cmp > 0) {
				lo = mid + 1;
			}
			else {
				return mid;
			}
		}
		return lo;
	}
	
	public void put(Key key, Value val) {
		//search for key, update value if found; grow table if new
		int i = rank(key);
		
		if(i < N && keys[i].compareTo(key) == 0) {
			vals[i] = val;
			return;
		}
		
		for(int j = N; j > i; j--) {
			keys[j] = keys[j-1];
			vals[j] = vals[j-1];
		}
		
		keys[i] = key;
		vals[i] = val;
		N++;
	}
	
	public Key min() {
		return keys[0];
	}
	
	public Key max() {
		return keys[N-1];
	}
	
	public Key select(int k) {
		return keys[k];
	}
	
	public Key ceiling(Key key) {
		int i = rank(key);
		return keys[i];
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public boolean contains(Key key) {
		return get(key) != null;
	}
	
	public static void main(String[] args) {
		
		Q3_1_1<String, Double> st = new Q3_1_1<String, Double>(11);
		
		st.put("A+", 4.33);
		st.put("A", 4.00);
		st.put("A-", 3.67);
		st.put("B+", 3.33);
		st.put("B", 3.00);
		st.put("B-", 2.67);
		st.put("C+", 2.33);
		st.put("C", 2.00);
		st.put("C-", 1.67);
		st.put("D", 1.00);
		st.put("F", 0.00);
		
		try {
			System.out.println("Enter list of letter grades seperated by spaces: ");
			Scanner sc = new Scanner(System.in);
			String rawInput = sc.nextLine();
			String[] input = rawInput.split(" ");
			
			System.out.println("Grades with GPA: ");
			
			for (String grade : input) {
				if(st.get(grade) != null) {
					System.out.println(grade + " : " + st.get(grade));
				}				
			}
		}
		catch(Exception ex) {
			System.out.println("Invalid!");
		}

	}

}
