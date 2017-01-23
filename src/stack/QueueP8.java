package stack;

import java.util.Stack;

public class QueueP8 {

	
	public static void main(String[] args) {
		Stack<Integer> mySt = createStack();
		Boolean flag = checkIfConsecutive(mySt);
		
		if(flag)
			System.out.println("Successive Pairs are consecutive ");
		else
			System.out.println("Successive Pairs are not consecutive");
	}

	private static Boolean checkIfConsecutive(Stack<Integer> mySt) {
		//remove the odd element out
		if(mySt.size() % 2 != 0)
			mySt.pop();
		
		while(!mySt.isEmpty()){
			//get 2 consecutive integers
			int n1 = (int) mySt.pop();
			int n2 = (int) mySt.pop();
			//compare if they are cosecutive
			if(Math.abs(n1 - n2) != 1){
				return false;
			}
		}
		return true;
	}

	private static Stack<Integer> createStack() {
		Stack<Integer> mySt = new Stack<Integer>();
		mySt.add(5);
		mySt.add(4);
		mySt.add(1);
		mySt.add(2);
		mySt.add(6);
		mySt.add(7);
		mySt.add(200);
		return mySt;
	}

}
