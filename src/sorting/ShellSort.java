package sorting;

public class ShellSort {

	public static void main(String[] args) {
		int[] inpArr = {9, 8, 7, 4, 5, 2, 8, 3, 6, 0, 1};
		int[] sortedArr = shellSort(inpArr);
		for(int i = 0 ; i < sortedArr.length; i++){
			System.out.print(sortedArr[i] + " ");
		}
	}

	//partially sort on the basis of h and then do normal insertion sort
	//its better because unlike insertion sort we don't have to move the entire list of elements
	//when we have to place the new element in its correct position
	private static int[] shellSort(int[] inpArr) {
		int h = inpArr.length/3;
		while(h>1){

			for(int i = 0; i < inpArr.length - h; i++){
				if(inpArr[i] > inpArr[h+i]){
					int temp = inpArr[h+i];
					inpArr[h+i] = inpArr[i];
					inpArr[i] = temp;
				}
			}
			
			h = h/3;
		}
		
		return normalInsSort(inpArr);
	}

	//normal insertion sort
	private static int[] normalInsSort(int[] inpArr) {
		for(int i = 0; i < inpArr.length; i++){
			for(int j = 0; j < i; j++){
				if(inpArr[i] < inpArr[j]){
					int temp = inpArr[j];
					inpArr[j] = inpArr[i];
					inpArr[i] = temp;
				}
			}
		}
		return inpArr;
	}

}
