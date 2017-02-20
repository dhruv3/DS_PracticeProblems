package hashing;

import java.util.Hashtable;
import java.util.Scanner;

public class P14 {

	static char firstNonRepeated;
	
	public static void main(String[] args) {
		Scanner inp = new Scanner(System.in);
		System.out.println("Enter string to be tested");
		String userInput = inp.nextLine();
		Boolean ans = checkIfRepeated(userInput);
		if(ans){
			System.out.println("First non repeated element is " + firstNonRepeated);
		}
		else{
			System.out.println("All elements are repeated");
		}
	}

	private static Boolean checkIfRepeated(String userInput) {
		Hashtable<Character, Integer> map=new Hashtable<Character,Integer>(); 
		
		//create hashtable for string with frequencies
		for(int i = 0; i < userInput.length(); i++){
			char key = userInput.charAt(i);
			if(map.containsKey(key) == false){
				map.put(key, 1);
			}
			else{
				int val = map.get(key);
				map.put(key, ++val);
			}
		}
		//loop and check frequency of each element
		for(int i = 0; i < userInput.length(); i++){
			char key = userInput.charAt(i);
			if(map.get(key) == 1){
				firstNonRepeated = key;
				return true;
			}
		}
		
		return false;
	}

}
