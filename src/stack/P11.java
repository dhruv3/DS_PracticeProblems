package stack;

import java.util.Stack;

public class P11 {

	
	public static void main(String[] args) {
		Stack<Integer> st = createStack();
		st = reverseStack(st);
		//print the reversed stack
		while(!st.isEmpty()){
			System.out.println(st.pop());
		}
	}

	//first pop all elements of the stack till it becomes empty
	private static Stack<Integer> reverseStack(Stack<Integer> st) {
		if(st.isEmpty())
			return st;
		int temp = st.pop();
		reverseStack(st);
		insertAtBottom(st, temp);
		return st;
	}

	//insert the element at the bottom of stack
	private static void insertAtBottom(Stack<Integer> st, int data) {
		if(st.isEmpty()){
			st.push(data);
			return;
		}
		int temp = st.pop();
		//recursive step
		insertAtBottom(st, data);
		st.push(temp);
	}

	//create stack
	private static Stack<Integer> createStack() {
		Stack<Integer> st = new Stack<Integer>();
		int i = 10;
		while(i > 0){
			st.push(i--);
		}
		return st;
	}

}
