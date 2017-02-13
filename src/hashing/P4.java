package hashing;

import java.util.Hashtable;
import java.util.Scanner;

//Removing Duplicate From Char Array
public class P4 {

	static int newLength = 0; 
	
	public static void main(String[] args) {
		char[] charArray = {'a', 't', 'e', 'a', 't', 'p'};
		
		char[] outputArr = removeDuplicate(charArray);
		
		for(int j = 0; j < newLength; j++){
			System.out.println(outputArr[j]);
		}
	}

	private static char[] removeDuplicate(char[] charArray) {
		Hashtable ht = new Hashtable();
		int current = 0;
		int last = 0;
		for(;if(charArray[current] != null); current++){
			
		}
		return charArray;
	}

}
