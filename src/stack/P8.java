package stack;

import java.util.Scanner;
import java.util.Stack;

public class P8 {

	
	public static void main(String[] args) {
		Scanner inp  = new Scanner(System.in);
		System.out.println("Enter string to check for palindrome");
		String userInput = inp.nextLine();
		
		Boolean flag = basicPalindromeCheck(userInput);
		
		if(flag)
			System.out.println("It is a Palindrome.");
		else
			System.out.println("Not a Palindrome");
		
		flag = stackPalindromeCheck(userInput);
		
		if(flag)
			System.out.println("It is a Palindrome.");
		else
			System.out.println("Not a Palindrome");
	}

	private static Boolean stackPalindromeCheck(String userInput) {
		int j = userInput.length();
		Stack<Character> st = new Stack<Character>();
		
		//adding half the characters to stack
		for(int i = 0; i < j/2; i++){
			st.push(userInput.charAt(i));
		}
		
		//pop and compare
		//Adding j%2: required as we need to add 1 in case length is odd
		for(int i = j/2 +(j%2); i < j; i++){
			if(st.pop() != userInput.charAt(i))
				return false;
		}
		
		return true;
	}

	private static Boolean basicPalindromeCheck(String userInput) {
		int j = userInput.length() - 1;
		int i = 0;
		while(i <= j && userInput.charAt(i) == userInput.charAt(j)){
			i++;
			j--;
		}
		//pointers crossover => It is a palindrome
		if(i >= j) {
			return true;
		}
		
		return false;
	}


}
