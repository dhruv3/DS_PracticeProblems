package hashing;

import java.util.Hashtable;
import java.util.Scanner;

//Removing unwanted string
public class P13 {

	public static void main(String[] args) {
		Scanner inp = new Scanner(System.in);
		System.out.println("Enter input string");
		String inpStr = inp.nextLine();
		System.out.println("Enter string that needs to be removed");
		String remStr = inp.nextLine();
		
		String finalStr = updateStr(inpStr, remStr);
		
		System.out.println("Updated string is: " + finalStr);
	}

	private static String updateStr(String inpStr, String remStr) {
		String finalStr = "";
		Hashtable<Character, Integer> map=new Hashtable<Character,Integer>(); 
		//create hashtable for string that needs to be removed
		for(int i = 0; i < remStr.length(); i++){
			char key = remStr.charAt(i);
			if(map.containsKey(key) == false){
				map.put(key, 1);
			}
		}
		//loop through input string and skip chars which are present in hashtable
		for(int i = 0; i < inpStr.length(); i++){
			char key = inpStr.charAt(i);
			if(map.containsKey(key) == false){
				finalStr = finalStr + key;
			}
		}
		
		return finalStr;
	}

}
