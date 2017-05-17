package dynamicProgramming;

//vid tutorial: https://www.youtube.com/watch?v=vgLJZMUfnsU
//code: https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/MatrixMultiplicationCost.java
public class P15_MatrixChainMultiplication {

	public static void main(String[] args) {
		int[] matDim = {2,3,6,4,5};
		int n = matDim.length;
		
		int temp[][] = new int[n][n];
		for(int i = 0; i < n; i++){
			temp[i][i] = 0; 
		}
		
		int q = 0;
        for(int l=2; l < n; l++){
            for(int i=0; i < n - l; i++){
                int j = i + l;
                temp[i][j] = 1000000;
                for(int k=i+1; k < j; k++){
                    q = temp[i][k] + temp[k][j] + matDim[i]*matDim[k]*matDim[j];
                    if(q < temp[i][j]){
                        temp[i][j] = q;
                    }
                }
            }
        }
        
        
        System.out.println("Cost is " +  temp[0][n-1]);
	
	}

}
