package sorting;

public class SelectionSort {

	public static void main(String[] args) {
		int[] inpArr = {7, 4, 5, 2, 8, 3, 6};
		int[] sortedArr = selSort(inpArr);
		for(int i = 0 ; i < sortedArr.length; i++){
			System.out.print(sortedArr[i] + " ");
		}
	}

	private static int[] selSort(int[] inpArr) {
		for(int i = 0; i < inpArr.length - 1; i++){
			int minIdx = i;
			//get the index of minimum valued element
			for(int j = i+1; j < inpArr.length; j++){
				if(inpArr[minIdx] > inpArr[j]){
					minIdx = j;
				}
			}
			//swap only if required
			if(minIdx != i){
				int temp = inpArr[minIdx];
				inpArr[minIdx] = inpArr[i];
				inpArr[i] = temp;
			}
		}
		return inpArr;
	}
}
