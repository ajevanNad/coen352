//question 1.3.37

package q1p3p37;

public class Josephus {

	public static void main(String[] args) {
		try {
			int N = Integer.parseInt(args[0]); //number of people
			int M = Integer.parseInt(args[1]); //eliminate every Mth person
			
			if (M < 1) {
				System.out.println("M has to be at least 1. M will be set to 1");
				M = 1;
			}
			
			Queue<Integer> peopleLeft = new Queue<Integer>(); //people still alive
			Queue<Integer> peopleOut = new Queue<Integer>(); //people that are out
			
			//fill up with all the people
			for(int i = 0; i < N; i++) { 
				peopleLeft.enqueue(i);
			}
			
			int skipped = 1; //number of people skipped
			
			while(peopleLeft.size() > 0) {
				if (skipped == M) {
					peopleOut.enqueue(peopleLeft.dequeue()); //if Mth person, put in queue of people that are out
					skipped = 1;
				}
				else {
					peopleLeft.enqueue(peopleLeft.dequeue()); //if not, then put person at the end of the queue
					skipped++;
				}
			}
			
			String output = "";
			
			while(peopleOut.size() > 0) {
				output += peopleOut.dequeue() + " ";
			}
			
			System.out.println(output);
		
		}
		catch(Exception e) {
			System.out.println("Invalid Input!");
		}

	}

}
