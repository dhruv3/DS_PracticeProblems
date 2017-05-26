package sorting;

import java.util.LinkedList;

//tutorial: https://www.youtube.com/watch?v=geVyIsFpxUs	
public class BucketSort {

	public static void main(String[] args) {
		int[] inpArr = {7, 4, 2, 3, 6, 1, 7, 8, 6, 50};
		int[] sortedArr = buckSort(inpArr);
		for(int i = 0 ; i < sortedArr.length; i++){
			System.out.print(sortedArr[i] + " ");
		}
	}

	private static int[] buckSort(int[] inpArr) {
		//https://stackoverflow.com/questions/20202889/how-can-i-create-an-array-of-linked-lists-in-java
		@SuppressWarnings("unchecked")
		LinkedList<Integer>[] vertex = new LinkedList[inpArr.length];
		
		//https://stackoverflow.com/questions/7287099/why-does-math-ceil-return-a-double
		//getMax + 1 done as we want our numerator to be larger than max value
		//(double) typecast was required as int divided by int return (floor)integer
		int divider = (int)(Math.ceil(((double)(getMax(inpArr) + 1)) / (inpArr.length)));
		
		//distribute values across the array
		for(int i = 0; i < inpArr.length; i++){
			int buckIdx = inpArr[i]/divider;
			//initialize array element 
			if(vertex[buckIdx] == null){
				vertex[buckIdx] = new LinkedList<Integer>();
			}
			vertex[buckIdx].add(inpArr[i]);
		}
		
		//sort each LL
		for(int i = 0; i < vertex.length; i++){
			if(vertex[i] != null){
				sortLL(vertex[i]);
			}
		}
		
		int ctr = 0;
		//merge different sorted LL and overwrite input array
		for(int i = 0; i < vertex.length; i++){
			if(vertex[i] != null){
				for(int j = 0; j < vertex[i].size(); j++){
					inpArr[ctr++] = vertex[i].get(j);
				}
			}
		}
		
		return inpArr;
	}

	//sorts linked list received as input
	//normal insertion sort used to do this
	private static void sortLL(LinkedList<Integer> linkedList) {
		for(int i = 0; i < linkedList.size(); i++){
			for(int j = 0; j < i; j++){
				if(linkedList.get(i) < linkedList.get(j)){
					int temp = linkedList.get(j);
					linkedList.set(j, linkedList.get(i));
					linkedList.set(i, temp);
				}
			}
		}
	}

	//return the max value in input
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
