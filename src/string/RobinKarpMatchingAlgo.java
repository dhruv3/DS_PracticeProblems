package string;

//tutorial: https://www.youtube.com/watch?v=H4VrKHVG5qI
public class RobinKarpMatchingAlgo {

	static int prime  = 101;
	
	public static void main(String[] args) {
		String input = "Brown fox jumps over a sleeping something like this is a long sentence";
		String pattern = "pingi some";
		
		Boolean ans = false;
		//get hash of our pattern
		int patternHash = createHash(pattern);

		int patLen = pattern.length();
		int tempHash = 0;
		for(int i = 0; i < (input.length() - patLen + 1); i++){
			//separate case when i = 0
			if(tempHash == 0){
				String tempStr = input.substring(i, i+patLen);
				//create a hash value initially
				tempHash = createHash(tempStr);
			}
			else{
				//just update previous hash value 
				tempHash = updateHash(tempHash, input.charAt(i-1), input.charAt(i+patLen - 1), patLen-1);
			}
			//if hash value is same then check by comparing characters
			if(tempHash == patternHash){
				ans = checkIfSame(input.substring(i, i+patLen), pattern);
				if(ans == true)
					break;
			}
		}
		//print output
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
		//step 1: remove old char
		hashVal = (int) (hashVal - oldChar);
		//step 2: reduce the base by division
		hashVal = hashVal / prime;
		//step 3: add new char with appropriate power
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
