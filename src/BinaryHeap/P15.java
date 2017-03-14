package BinaryHeap;

import java.util.Scanner;

public class P15 {

	public static void main(String[] args) {
		AdvancedBinaryHeap myHeap = createBinaryHeap();
		
		Scanner inp = new Scanner(System.in);
		System.out.println("Enter x, where x represents the xth largest element in the heap.");
		int k = inp.nextInt();
		
		myHeap.printAnswer(0, k);
	}

	private static AdvancedBinaryHeap createBinaryHeap() {
		AdvancedBinaryHeap newHeap = new AdvancedBinaryHeap(8, 1);
		int[] inpArr = {2,1,3,4,5,6,7,8};
		newHeap.BuildHeap(newHeap, inpArr, 8);
		return newHeap;
	}
}
