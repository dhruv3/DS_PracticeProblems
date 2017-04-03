package sorting;

public class Mergesort {

	public static void main(String[] args) {
		int[] inpArr = {7, 4, 5, 2, 8, 3, 6};
		int[] sortedArr = mrgSort(inpArr, 0 , inpArr.length-1);
		for(int i = 0 ; i < sortedArr.length; i++){
			System.out.print(sortedArr[i] + " ");
		}
	}

	private static int[] mrgSort(int[] inpArr, int start, int end) {
		//base case
		if(start == end){
			int temp[] = {inpArr[start]};
			return temp;
		}
		
		int mid = (int)(start+end)/2;
		
		int[] lArr = mrgSort(inpArr, start, mid);
		int[] rArr = mrgSort(inpArr, mid+1, end);
		int[] sortedArr = merge(lArr, rArr);
		
		return sortedArr;
	}

	private static int[] merge(int[] lArr, int[] rArr) {
		int[] sortedArr = new int[lArr.length+rArr.length];
		
		//l and r two different index to traverse lArr and rArr
		for(int i = 0, l = 0, r = 0; i < sortedArr.length; i++){
			//checks added in case we finish with lArr or rArr
			if(r == rArr.length){
				sortedArr[i] = lArr[l];
				l++;
			}
			else if(l == lArr.length){
				sortedArr[i] = rArr[r];
				r++;
			}
			//checks added in case we finish with lArr or rArr
			else{
				if(lArr[l] < rArr[r]){
					sortedArr[i] = lArr[l];
					l++;
				}
				else{
					sortedArr[i] = rArr[r];
					r++;
				}
			}
		}
		return sortedArr;
	}

}
