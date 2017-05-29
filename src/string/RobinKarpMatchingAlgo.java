package string;

public class RobinKarpMatchingAlgo {

	static int prime  = 101;
	
	public static void main(String[] args) {
		String input = "Brown fox jumps over a sleeping something like this is a long sentence";
		String pattern = "pingi some";
		Boolean ans = false;
		int patternHash = createHash(pattern);

		int patLen = pattern.length();
		int tempHash = 0;
		
		for(int i = 0; i < (input.length() - patLen + 1); i++){
			if(tempHash == 0){
				String tempStr = input.substring(i, i+patLen);
				tempHash = createHash(tempStr);
			}
			else{
				tempHash = updateHash(tempHash, input.charAt(i-1), input.charAt(i+patLen - 1), patLen-1);
			}
			
			if(tempHash == patternHash){
				ans = checkIfSame(input.substring(i, i+patLen), pattern);
				if(ans == true)
					break;
			}
		}
		
		if(ans == true){
			System.out.println("Pattern exists");
		}
		else{
			System.out.println("Pattern does not exist");
		}
	}

	private static Boolean checkIfSame(String substring, String pattern) {
		for(int i = 0; i < substring.length(); i++){
			if(substring.charAt(i) != pattern.charAt(i))
				return false;
		}
		return true;
	}

	private static int updateHash(int tempHash, char oldChar, char newChar, int pow) {
		int hashVal = tempHash;
		//step 1:
		hashVal = (int) (hashVal - oldChar);
		//step 2:
		hashVal = hashVal / prime;
		//step 3:
		hashVal = (int) (hashVal + newChar*Math.pow(prime, pow));
		
		return hashVal;
	}

	private static int createHash(String pattern) {
		int hashVal = 0;
		for(int i = 0; i < pattern.length(); i++){
			hashVal += (pattern.charAt(i)*Math.pow(prime, i));
		}
		return hashVal;
	}

}
