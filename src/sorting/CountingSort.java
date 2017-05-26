package sorting;

//tutorial: http://www.geeksforgeeks.org/counting-sort/
public class CountingSort {

	public static void main(String[] args) {
		int[] inpArr = {1, 4, 1, 2, 7, 5, 2};
		int[] sortedArr = countSort(inpArr, 10);
		for(int i = 0 ; i < sortedArr.length; i++){
			System.out.print(sortedArr[i] + " ");
		}
	}

	//K is the range 
	private static int[] countSort(int[] inpArr, int K) {
		int[] countArr = new int[K];
		for(int i = 0; i < inpArr.length; i++){
			countArr[inpArr[i]]++;
		}
		
		//modify count array
		for(int i = 0; i < countArr.length-1; i++){
			countArr[i+1] = countArr[i+1] + countArr[i]; 
		}
		
		int[] outArr = new int[inpArr.length];
		for(int i = 0; i < inpArr.length; i++){
			int idx = inpArr[i];
			int outIdx = countArr[idx];
			
			//-1 is done as this last step assumed that array index start from 1
			outArr[outIdx-1] = inpArr[i];
			countArr[idx]--;
		}
		
		return outArr;
	}
}
