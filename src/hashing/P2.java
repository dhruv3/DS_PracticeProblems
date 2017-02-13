package hashing;

import java.util.Scanner;

//Removing Duplicate From Char Array
public class P2 {

	static int newLength = 0; 
	
	public static void main(String[] args) {
		char[] charArray = {'a', 't', 'e', 'a', 't', 'p'};
		
		char[] outputArr = removeDuplicate(charArray);
		
		for(int j = 0; j < newLength; j++){
			System.out.println(outputArr[j]);
		}
	}

	private static char[] removeDuplicate(char[] charArray) {
		int n = charArray.length;
		
		//we cannot reduce the length of the array
		//so we are  using 'n' to manage how we shall iterate over it
		for(int i = 0; i < n; i++){
			char temp = charArray[i];
			for(int j = i+1; j < n;){
				if(temp == charArray[j]){
					//copy last element to this repeated element
					//reduce value of n
					charArray[j] = charArray[--n];
				}
				else{
					j++;
				}
			}
		}
		//to get the new value of string length
		newLength = n;
		return charArray;
	}

}
