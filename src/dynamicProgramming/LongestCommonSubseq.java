package dynamicProgramming;

public class LongestCommonSubseq {

	public static void main(String[] args) {
		String s1 = "ABCDEF";
		String s2 = "ACBCF";
		String result = LCSRecursive(s1, s2);
		System.out.println("Longest common subsequence is " + result);
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
