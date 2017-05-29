package string;

public class BruteForcePatternMatch {

	public static void main(String[] args) {
		String input = "Brown fox jumps over a sleeping something like this is a long sentence";
		String pattern = "ping some";
		Boolean ans = isPatternPresent(input, pattern);
		if(ans){
			System.out.print("Pattern exists");
		}
		else{
			System.out.print("Pattern does not exist");
		}
	}

	private static Boolean isPatternPresent(String input, String pattern) {
		Boolean ans = false;
		int inpLen = input.length();
		int patLen = pattern.length();
		for(int i = 0; i < (inpLen - patLen + 1); i++){
			
		}
		return ans;
	}

}
