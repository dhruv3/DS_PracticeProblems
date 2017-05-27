package sorting;

//tutorial: http://www.geeksforgeeks.org/radix-sort/
public class RadixSort {

	public static void main(String[] args) {
		int[] inpArr = {170, 45, 75, 90, 802, 24, 2, 66};
		int[] sortedArr = radSort(inpArr);
		for(int i = 0 ; i < sortedArr.length; i++){
			System.out.print(sortedArr[i] + " ");
		}

	}

	private static int[] radSort(int[] inpArr) {
		int maxDigits = getMaxDigits(inpArr);
		int[] tempArr = new int[inpArr.length]; 
		for(int  i = 0; i < maxDigits; i++){
			fillTempArr(inpArr, tempArr, i);
			sortTempArr(inpArr, tempArr);
		}
		
		return inpArr;
	}
	
	//use insertion sort 
	private static void sortTempArr(int[] inpArr, int[] tempArr) {
		for(int i = 0; i < tempArr.length; i++){
			for(int j = 0; j < i; j++){
				if(tempArr[i] < tempArr[j]){
					int temp = inpArr[j];
					inpArr[j] = inpArr[i];
					inpArr[i] = temp;
					
					temp = tempArr[j];
					tempArr[j] = tempArr[i];
					tempArr[i] = temp;
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

	//returns the number of digits in the max number
	private static int getMaxDigits(int[] inpArr) {
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < inpArr.length; i++){
			if(max < inpArr[i]){
				max = inpArr[i];
			}
		}
		int cnt = 0;
		while(max >= 1){
			max = max / 10;
			cnt++;
		}
		return cnt;
	}

}
