package queue;

import java.util.Stack;

public class QueueWithTwoStacks {
	
	private Stack<Integer> S1 = new Stack<Integer>();
	private Stack<Integer> S2 = new Stack<Integer>();
	
	public void enqueue(int data){
		S1.push(data);
	}
	
	public int dequeue() throws Exception{
		//if S2 has content. Pop S2
		if(!S2.isEmpty()){
			return S2.pop();
		}
		//Transfer S1 contents to S2. Pop S2
		else if(!S1.isEmpty()){
			for(int i : S1){
				S2.push(S1.pop());
			}
			return S2.pop();
		}
		//Both stacks empty. Throw exception. 
		else{
			throw new Exception("Insert an element");
		}
	}
}
