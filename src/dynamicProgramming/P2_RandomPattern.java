package dynamicProgramming;

public class P2_RandomPattern {

	public static int[] table;
	
	public static void main(String[] args) {
		table  = new int[5+1];
		int ans = func(3);
		System.out.println("Sum is " + ans);
	}

	private static int func(int n) {
		if(n == 0 || n == 1){
			return 2;
		}
		table[0] = table[1] = 2;
		
		for(int i = 2; i <= n; i++){
			table[i] = 2*(table[i-1] * table[i-2]);
			if(i > 2)
				table[i] += table[i-1];
		}
		
		return table[n];
	}

}
