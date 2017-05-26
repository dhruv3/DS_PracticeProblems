package sorting;

import java.util.LinkedHashMap;

public class BucketSort {

	public static void main(String[] args) {
		int[] inpArr = {7, 4, 2, 3, 6, 1, 7, 8, 6, 50};
		int[] sortedArr = buckSort(inpArr);
		for(int i = 0 ; i < sortedArr.length; i++){
			System.out.print(sortedArr[i] + " ");
		}
	}

	private static int[] buckSort(int[] inpArr) {
		LinkedHashMap<Integer, Integer> bucket = new LinkedHashMap<Integer, Integer>(inpArr.length);
		
		//https://stackoverflow.com/questions/7287099/why-does-math-ceil-return-a-double
		int divider = (int)(Math.ceil(getMax(inpArr)/(inpArr.length)));
		
		for(int i = 0; i < inpArr.length; i++){
			int buckIdx = inpArr[i]/divider;
			bucket.put(buckIdx, inpArr[i]);
		}
		
		for(int i = 0; i < bucket.size(); i++){
						
		}
		return null;
	}

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
