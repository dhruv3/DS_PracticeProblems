package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class P1 {

	static char openDelimiter[] = {'[', '{', '('};
	static char closeDelimiter[] = {']', '}', ')'};
	static Map<Character, Character> limiterPairs = new HashMap<Character, Character>();
	
	public static void main(String[] args) {
		buildMap();
		Scanner scanner  =  new Scanner(System.in);
		System.out.println("Enter string to be validated");
		String userInput =  scanner.nextLine();
		
		boolean isValid = validateString(userInput);
		if(isValid)
			System.out.println("String is valid");
		else
			System.out.println("String is invalid");
	}

	private static void buildMap() {
		for(int i = 0; i < openDelimiter.length; i++){
			limiterPairs.put(openDelimiter[i], closeDelimiter[i]);
		}
	}

	private static boolean validateString(String userInput) {
		char tempChar;
		Stack<Character> stk =  new Stack<Character>();
		
		for(int i = 0, n = userInput.length() ; i < n ; i++) { 
			
			tempChar = userInput.charAt(i);
			//check if its opening delimiter
			for(char oDChar: openDelimiter){
				if(oDChar == tempChar){
					//push to stack
					stk.push(oDChar);
					//break as looping over for now is waste
					break;
				}
			}
			
			//check if its closing delimiter
			for(char oDChar: closeDelimiter){
				if(oDChar == tempChar){
					//check is stack has content or not
					if(stk.isEmpty()){
						return false;
					}
					//if popped char not same as input char its an error
					char out = stk.pop();
					if(limiterPairs.get(out) != tempChar){
						return false;
					}
					//stop looping and carry on
					break;
				}
			}
		}
		//if valid string then stack should be empty at the end
		if(stk.isEmpty() == false){
			return false;
		}
		
		return true;
	}

}
