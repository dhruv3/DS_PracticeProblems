package sorting;

import java.util.LinkedList;

//tutorial: https://www.youtube.com/watch?v=YXFI4osELGU
public class RadixSort {

	public static void main(String[] args) {
		int[] inpArr = {170, 45, 75, 90, 802, 24, 2, 66};
		int[] sortedArr = radSort(inpArr);
		for(int i = 0 ; i < sortedArr.length; i++){
			System.out.print(sortedArr[i] + " ");
		}

	}

	private static int[] radSort(int[] inpArr) {
		int max = getMax(inpArr);
		int tempMax = max;
		int maxDigits = 0;
		while(tempMax >= 1){
			tempMax = tempMax / 10;
			maxDigits++;
		}
		
		int[] tempArr = new int[inpArr.length]; 
		for(int  i = 0; i < maxDigits; i++){
			fillTempArr(inpArr, tempArr, i);
			buckSort(inpArr, tempArr);
		}
		
		return inpArr;
	}
	
	
	private static void buckSort(int[] inpArr, int[] tempArr) {
		//https://stackoverflow.com/questions/20202889/how-can-i-create-an-array-of-linked-lists-in-java
		@SuppressWarnings("unchecked")
		LinkedList<Integer>[] vertex = new LinkedList[10];

		//distribute values across the array
		for(int i = 0; i < tempArr.length; i++){
			int buckIdx = tempArr[i];
			//initialize array element 
			if(vertex[buckIdx] == null){
				vertex[buckIdx] = new LinkedList<Integer>();
			}
			vertex[buckIdx].add(inpArr[i]);
		}
		
		updateInpArr(vertex, inpArr);
	}
	
	//remove elements from the bucket and add them to input array
	private static void updateInpArr(LinkedList<Integer>[] vertex, int[] inpArr) {
		int ctr = 0;
		//loop through the buckets and add content to input array 
		for(int i = 0; i < vertex.length; i++){
			if(vertex[i] != null){
				for(int j = 0; j < vertex[i].size(); j++){
					inpArr[ctr++] = vertex[i].get(j);
				}
			}
		}
	}

	//get the digit present at 'pos' and store it in temp array
	private static void fillTempArr(int[] inpArr, int[] tempArr, int pos) {
		int divider = (int)Math.pow(10, pos);
		for(int i = 0; i < inpArr.length; i++){
			tempArr[i] = (inpArr[i] / divider) % 10;
		}
	}

	//returns the max number
	private static int getMax(int[] inpArr) {
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < inpArr.length; i++){
			if(max < inpArr[i]){
				max = inpArr[i];
			}
		}
		return max;
	}

}
