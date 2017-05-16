package dynamicProgramming;

public class P15_MatrixChainMultiplication {

	public static void main(String[] args) {
		int[] matDim = {2,3,6,4,5};
		int n = matDim.length;
		
		int[][] totalMult = new int[n][n];
		for(int i = 0; i < n; i++){
			totalMult[i][i] = 0; 
		}
	}

}
