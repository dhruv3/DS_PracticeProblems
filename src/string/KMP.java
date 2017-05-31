package string;

public class KMP {

	public static int[] prefixTable;
	
	public static void main(String[] args) {
		String input = "Brown fox jumps over a sleeping something like this is a long sentence";
		String pattern = "pingi some";
		
		fillPrefixTable(pattern.toCharArray(), pattern.length());

	}

	private static void fillPrefixTable(char[] pattern, int patLength) {
		int i = 1, j = 0;
		while(i < patLength){
			if(pattern[i] == pattern[j]){
				prefixTable[i] = j+1;
				i++;
				j++;
			}
			else if(j > 0){
				j = prefixTable[j - 1];
			}
			else{
				prefixTable[i] = 0;
				i++;
			}
		}
	}

}
