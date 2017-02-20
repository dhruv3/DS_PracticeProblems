package hashing;

import java.util.Hashtable;
import java.util.Map.Entry;

//Most frequent element
public class P11 {

	public static void main(String[] args) {
		int[] myArr = {1, 2, 2, 2, 3, 4, 5, 1, 3, 4, 9};
		int ans = mostFreqElement(myArr);
		System.out.println("Most frequent element is: " + ans);
	}

	private static int mostFreqElement(int[] myArr) {
		Hashtable<Integer, Integer> map=new Hashtable<Integer,Integer>(); 
		//add elements in hashtable
		for(int i = 0; i < myArr.length; i++){
			int key = myArr[i];
			//I was earlier using contains instead of containsKey, which caused issues
			if(map.containsKey(key) == false){
				map.put(key, 1);
			}
			else{
				int val = map.get(key);
				map.put(key, ++val);
			}
		}
		//get the most frequent key by iterating over the elements 
		int maxVal = 1;
		int freqKey = -1;
		//tutorial on how to iterate: http://www.javatpoint.com/java-hashtable
		for(Entry<Integer, Integer> key : map.entrySet()){
			int value = key.getValue();
			if(value > maxVal){
				freqKey = key.getKey();
				maxVal = value;
			}
		}
		return freqKey;
	}

}
