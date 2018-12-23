//question 1.3.9

package q1p3p9;

import java.util.Scanner;

/**
 * program that takes an expression without left parentheses and prints the equivalent infix expression with the parentheses
 * @author Ajevan
 *
 */
public class App {

	public static void main(String[] args) {
		
		System.out.println("Enter expression: ");
		Scanner sc = new Scanner(System.in);
		String exp = sc.nextLine();
//		String exp = "1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )";
		
		LinkedStack<String> vals = new LinkedStack<String>(); //stack of operands
		LinkedStack<String> ops = new LinkedStack<String>(); //stack of operators
		String[] expArray = exp.split("\\s+"); //split expression on space so that operands and operators can be separated
		
		for(int i = 0; i < expArray.length; i++) {
			String s = expArray[i];
			
			switch(s) {
			case "+":
				ops.push("+");
				break;
			case "-":
				ops.push("-");
				break;
			case "*":
				ops.push("*");
				break;
			case "/":
				ops.push("/");
				break;
			case ")":
				String substring = vals.pop();
				substring = "( " + vals.pop() +  " " + ops.pop() + " " + substring + " )";
				vals.push(substring);
				break;
				default:
					vals.push(s);
			}
	
		}
		
		System.out.println(vals.pop());

	}

}
