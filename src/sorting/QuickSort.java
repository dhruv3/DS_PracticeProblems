package sorting;

//tutorial: http://www.vogella.com/tutorials/JavaAlgorithmsQuicksort/article.html
public class QuickSort {

	public static void main(String[] args) {
		int[] inpArr = {7, 4, 5, 2, 8, 3, 6, 1};
		int[] sortedArr = qSort(inpArr, 0, inpArr.length-1);
		for(int i = 0 ; i < sortedArr.length; i++){
			System.out.print(sortedArr[i] + " ");
		}

	}

	private static int[] qSort(int[] inpArr, int low, int high) {
		int i = low, j = high;
		int pivot = inpArr[(low+high)/2];
		
		//go till left ptr and right ptr cross each other
		while(i <= j){
			//get left idx of element which is GREATER than pivot element
			while(inpArr[i] < pivot){
				i++;
			}
			
			//get right idx of element which is LESSER than pivot element
			while(inpArr[j] > pivot){
				j--;
			}
			
			if(i <= j){
				//swap elements at i and j
				int temp = inpArr[j];
				inpArr[j] = inpArr[i];
				inpArr[i] = temp;
				
				i++;
				j--;
			}
		}
		
		//Recursion
		//now array is subdivided so we sort the two parts
        if (low < j)
            qSort(inpArr, low, j);
        if (i < high)
            qSort(inpArr, i, high);
        
		return inpArr;
	}

}
