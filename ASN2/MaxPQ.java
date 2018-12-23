/**
 * max priority queue using heap implementation.
 * taken from textbook.
 * @author Ajevan
 *
 * @param <Key>
 */
public class MaxPQ<Key extends Comparable<Key>> {
	
	private Key[] pq; //priority queue
	private int N = 0; //size of priority queue, pq[1..N] without using pq[0]
	
	private boolean less(int i, int j) {
		return pq[i].compareTo(pq[j]) < 0;
	}
	
	private void exch(int i, int j) {
		Key t = pq[i];
		pq[i] = pq[j];
		pq[j] = t;
	}
	
	/**
	 * swim up heap to restore heap property
	 * @param k index
	 */
	private void swim(int k) {
		while(k > 1 && less(k/2, k)) {
			exch(k/2, k);
			k = k/2;
		}
	}
	
	/**
	 * sink down heap to restore heap property
	 * @param k index
	 */
	private void sink(int k) {
		while(2*k <= N) {
			int j = 2*k;
			
			if(j < N && less(j, j+1)) { //check other child, take other child if greater
				j++;
			}
			
			if(!less(k, j)) {
				break;
			}
			
			exch(k, j);
			k = j;
		}
	}
	
	public MaxPQ(int maxN) {
		pq = (Key[]) new Comparable[maxN+1];
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public int size() {
		return N;
	}
	
	public void insert(Key v) {
		pq[++N] = v;
		swim(N);
	}
	
	public Key findMax() {
		return pq[1];
	}
	
	public Key delMax() {
		Key max = pq[1]; //get max key from top
		exch(1, N--); //swap with last item
		pq[N+1] = null; //avoid loitering
		sink(1); //restore heap property
		return max;
	}

}
