package queue;

import java.util.Stack;

public class P1 {
	
	public static void main(String[] args) throws Exception {
		LinkedQueue llQ = new LinkedQueue();
		createQ(llQ);
		System.out.println("Initial Queue- " + llQ.toString());
		reverseQ(llQ);
		System.out.println("Reversed Queue- " + print(llQ));
	}

	private static String print(LinkedQueue llQ) throws Exception {
		String result = "";
		int counter = llQ.getSize();
		while(counter > 0){
			counter--;
			result = result + llQ.dequeue() + " ";
		}
		return result;
	}

	private static void reverseQ(LinkedQueue llQ) throws Exception {
		int counter = llQ.getSize();
		int temp = counter;
		Stack<Integer> myStack = new Stack(); //Stack used to store elements
		//fill the stack
		while(counter > 0){
			counter--;
			int topElement = llQ.dequeue();
			myStack.push(topElement);
		}
		//empty stack content into old empty queue
		while(temp > 0){
			temp--;
			int elem = (int) myStack.pop();
			llQ.enqueue(elem);
		}
	}

	private static void createQ(LinkedQueue llQ) {
		llQ.enqueue(1);
		llQ.enqueue(2);
		llQ.enqueue(3);
		llQ.enqueue(4);
		llQ.enqueue(5);
	}
}
