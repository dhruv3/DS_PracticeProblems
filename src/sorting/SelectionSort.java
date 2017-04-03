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
			for(int j = i+1; j < inpArr.length; j++){
				if(inpArr[i] > inpArr[j]){
					int temp = inpArr[j];
					inpArr[j] = inpArr[i];
					inpArr[i] = temp;
				}
			}
		}
		return inpArr;
	}
}
