package dynamicProgramming;

//video tutorial: https://www.youtube.com/watch?v=NnD96abizww
public class LongestCommonSubseq {

	public static void main(String[] args) {
		String s1 = "ACBCF";
		String s2 = "ABCDAF";
		
		String result = LCSRecursive(s1, s2);
		System.out.println("Longest common subsequence using recursion is " + result);
		
		result = LCSByDP(s1, s2);
		System.out.println("Longest common subsequence using DP is " + result);
	}

	private static String LCSByDP(String X, String Y) {
		int xLen = X.length();
		int yLen = Y.length();
		
		int[][] dpTable = new int[xLen+1][yLen+1];
		//updating the table
		for(int i = 1; i <= xLen; i++){
			for(int j = 1; j <= yLen; j++){
				if(X.charAt(i-1) == Y.charAt(j-1)){
					dpTable[i][j] = dpTable[i-1][j-1] + 1;
				}
				else{
					if(dpTable[i-1][j] > dpTable[i][j-1]){
						dpTable[i][j] = dpTable[i-1][j];
					}
					else{
						dpTable[i][j] = dpTable[i][j-1];
					}
				}
			}
		}
		//getting the string out of the table
		//stringbuffer creates a mutable string
		StringBuffer result = new StringBuffer();
		for(int x = X.length(), y = Y.length(); x != 0 && y != 0;){
			if(dpTable[x][y] == dpTable[x-1][y])
				x--;
			else if(dpTable[x][y] == dpTable[x][y-1])
				y--;
			else{
				result.append(X.charAt(x-1));
				x--;
				y--;
			}
		}
		
		return result.reverse().toString();
	}

	//total of 3 cases
	//case 1: char at the start match. Take this char and find LCS for the remaining string
	//case 2: either char of X is included or char of Y is included. Do LCS taking char of X
	//case 3: Do LCS taking char of Y
	//choose in case 2 or 3 which ever has longest length
	private static String LCSRecursive(String X, String Y) {
		String result = "";
		int xLen = X.length();
		int yLen = Y.length();
		
		if(xLen == 0 || yLen == 0)
			return result;
		
		if(X.charAt(0) == Y.charAt(0)){
			return (X.charAt(0) + LCSRecursive(X.substring(1, xLen), Y.substring(1, yLen)));
		}
		else{
			String xRes = LCSRecursive(X.substring(1, xLen), Y);
			String yRes = LCSRecursive(X, Y.substring(1, yLen));
			return (xRes.length() > yRes.length() ? xRes : yRes);
		}
	}

}
