package hashing;

import java.util.Scanner;

public class firstRepeatedChar {

	public static void main(String[] args) {
		Scanner inp = new Scanner(System.in);
		String userInput = inp.nextLine();
		Boolean ans = checkIfRepeated(userInput);
		
	}

	private static Boolean checkIfRepeated(String userInput) {
		int count[] = new int[256];
		for(int i = 0; i < userInput.length(); i++){
			count[userInput.charAt(i)]++;
		}
		return false;
	}

}
