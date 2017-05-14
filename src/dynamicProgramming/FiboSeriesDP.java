package dynamicProgramming;

import java.util.Scanner;

public class FiboSeriesDP {

	//memoization table
	public static int[] fib;
	
	public static void main(String[] args) {
		System.out.println("Choose type of DP technique:");
		System.out.println("1. Bottom-Up");
		System.out.println("2. Top-Down");
		Scanner inp = new Scanner(System.in);
		int choice = inp.nextInt();
		System.out.println("Enter n for Fibo series");
		int n = inp.nextInt();
		//n+1 done for top-down approach only
		fib = new int[n+1];
		int ans = -1;
		switch(choice){
			case 1:
				ans = bottomUpFib(n);
				break;
			case 2:
				ans = topDownFib(n);
				break;	
			default:
				System.out.println("Incorrect choice");
		}
		
		System.out.println("The " + n + " term in fibonacci series is " + ans);
	}

	private static int topDownFib(int n) {
		if(n==1 || n==2)
			return 1;
		//if the fib[i] has been initialized then return the stored value
		if(fib[n] != 0)
			return fib[n];
		return fib[n] = topDownFib(n-1) + topDownFib(n-2);
	}

	private static int bottomUpFib(int n) {
		if(n==0 || n==1)
			return 1;
		//set the initial indexes
		fib[0] = fib[1] = 1;
		//get prev set values and update new index
		for(int i = 2; i < n; i++){
			fib[i] = fib[i-1] + fib[i-2];
		}
		return fib[n-1];
	}

}
