package hashing;

import java.util.LinkedHashSet;

//http://www.geeksforgeeks.org/remove-all-duplicates-from-the-input-string/
//Removing Duplicate From Char Array
public class P4 {

	static int newLength = 0; 
	
	public static void main(String[] args) {
		char[] charArray = {'a', 't', 'e', 'a', 't', 'p'};
		
		LinkedHashSet<Character> outputLHS = removeDuplicate(charArray);
		
		// print string after deleting duplicate elements
        for(Character ch : outputLHS)
            System.out.print(ch);
	}

	private static LinkedHashSet<Character> removeDuplicate(char[] charArray) {
		LinkedHashSet<Character> lhs = new LinkedHashSet<>();
		for(int i=0;i<charArray.length;i++)
            lhs.add(charArray[i]);
		
		return lhs;
	}

}
