package dynamicProgramming;

//video tutorial: https://www.youtube.com/watch?v=8LusJS5-AGo
public class P18_01Knapsack {

	public static void main(String[] args) {
		int capacity = 7;
		int[] weight = {1, 3, 4, 5};
		int[] value = {1, 4, 5, 7};
		int maxVal = knapsack(capacity, weight, value);
		System.out.println("Max possible value is " + maxVal);
	}

	private static int knapsack(int capacity, int[] weight, int[] value) {
		int rows = weight.length; 
		int[][] table = new int[rows][capacity+1];
		
		for(int i = 0; i < rows; i++){
			int currWt = weight[i];
			int currVal = value[i];
			for(int j = 1; j < (capacity+1); j++){
				//check for first row
				if(i == 0){
					if(capacity >= currWt){
						table[i][j] = currVal;
					}
					else{
						table[i][j] = 0;
					}
				}
				//compare and add value
				else if(j>=currWt){
					table[i][j] = Math.max((table[i-1][j-currWt] + currVal), table[i-1][j]);
				}
				else{
					table[i][j] = table[i-1][j];
				}
			}
		}
		return table[rows-1][capacity];
	}

}
