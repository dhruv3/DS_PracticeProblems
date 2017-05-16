package dynamicProgramming;

//tutorial: https://www.youtube.com/watch?v=MUjOEJLtm6Y
public class P6_MaxValSubseq {

	public static void main(String[] args) {
		int[] arr = {1, -3, 4, -2, -1, 6};//{-2, 11, -4, 13, -5, 2};
		int sum = maxSubSeq(arr);
		System.out.println("Max subsequence sum is " + sum);

	}

	private static int maxSubSeq(int[] arr) {
		int res = 0;
		int testSum = 0;
		int seqStart = 0, endSeq = 0;
		
		for(int i = 0; i < arr.length; i++){
			//we continue with the prev sequence and include the current int as well
			if((testSum + arr[i]) > arr[i]){
				testSum = testSum + arr[i];
			}
			//we start our new sequence
			else{
				testSum = arr[i];
				seqStart = i;
			}
			//this is done so as ensure we get MAX value
			if(testSum >= res){
				res = testSum;
				endSeq = i;
			}
		}
		//print the sequence
		for(int j = seqStart; j <=endSeq; j++){
			System.out.print(arr[j] + "\t");
		}
		System.out.print("\n");
		
		return res;
	}

}
