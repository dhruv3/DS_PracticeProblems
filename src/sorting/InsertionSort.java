package sorting;

public class InsertionSort {

	public static void main(String[] args) {
		int[] inpArr = {7, 4, 5, 2, 8, 3, 6};
		int[] sortedArr = insSort(inpArr);
		for(int i = 0 ; i < sortedArr.length; i++){
			System.out.print(sortedArr[i] + " ");
		}
	}
	
	//sort online => sort as you receive the list
	//new element received is decided by index i
	//already sorted list goes from j = 0 to i-1 
	private static int[] insSort(int[] inpArr) {
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
