package hashing;

import java.util.Scanner;

public class firstRepeatedChar {

	static char firstRepeated;
	
	public static void main(String[] args) {
		Scanner inp = new Scanner(System.in);
		System.out.println("Enter string to be tested");
		String userInput = inp.nextLine();
		Boolean ans = checkIfRepeated(userInput);
		if(ans){
			System.out.println("First repeated element is " + firstRepeated);
		}
		else{
			System.out.println("No repeated element");
		}
	}

	private static Boolean checkIfRepeated(String userInput) {
		int count[] = new int[256];//default all array values set to zero
		for(int i = 0; i < userInput.length(); i++){
			//check if repeated
			if(count[userInput.charAt(i)] == 1){
				firstRepeated = userInput.charAt(i);
				return true;
			}
			else{
				count[userInput.charAt(i)]++;
			}
		}
		
		return false;
	}

}
