package stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackWithTwoQueues {
	Queue<Integer> Q1 = new LinkedList<Integer>();
	Queue<Integer> Q2 = new LinkedList<Integer>();
	
	public void push(int data){
		Q1.add(data);
	}
	
	public int pop() throws Exception{
		//Q2 empty and Q1 has content
		if(!Q1.isEmpty() && Q2.isEmpty()){
			for(int i = 0; i < Q1.size() - 1; i++){
				Q2.add(Q1.poll());
			}
			return Q1.poll();
		}
		//Q1 empty and Q2 has content
		else if(Q1.isEmpty() && !Q2.isEmpty()){
			for(int i = 0; i < Q2.size() - 1; i++){
				Q1.add(Q2.poll());
			}
			return Q2.poll();
		}
		else{
			throw new Exception("Both queues are empty!");
		}
	}
}
