package sorting;

import java.util.Scanner;

//problem: https://www.hackerrank.com/challenges/30-sorting
public class BubbleSort {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int totalSwaps = 0;
        int localSwap = 0;
        for(int i = 0; i < n; i++){
            localSwap = 0;
            for(int j = 0; j <=n-2; j++){
                if(a[j] > a[j+1]){
                    a[j] = a[j] + a[j+1];
                    a[j+1] = a[j] - a[j+1];
                    a[j] = a[j] - a[j+1];
                    
                    totalSwaps++;
                    localSwap = 1;
                }
            }
            if(localSwap == 0)
                break;
        }
        
        System.out.println("Array is sorted in " + totalSwaps + " swaps.");
        System.out.println("First Element: " + a[0]);
        System.out.println("Last Element: " + a[n-1]);

	}

}
