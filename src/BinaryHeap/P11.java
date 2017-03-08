package BinaryHeap;

import java.util.Scanner;

public class P11 {

	public static void main(String[] args) {
		AdvancedBinaryHeap myHeap = createBinaryHeap();
		
		Scanner inp = new Scanner(System.in);
		System.out.println("Enter int less than which you need all elements");
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
