package queue;

import linkedList.listNode;

//enqueue = insert node at end of list
//dequeue  = deleting the node from beginning of the list

public class LinkedQueue {
	//indicate size of stack
	private int length = 0;
	
	private listNode front, rear;
	
	public LinkedQueue(){
		length = 0;
		front = rear = null;
	}
	
	//insert node at end of list
	public void enqueue(int data){
		listNode newNode = new listNode(data);
		if(rear == null){
			front = newNode;
			rear = newNode;
		}
		else{
			rear.setNext(newNode);
			rear = newNode;
		}
		length++;
	}
	
	
	//deleting the node from beginning of the list
	public int dequeue() throws Exception{
		if(isEmpty()){
			throw new Exception("Queue is empty. Dequeue wont work.");
		}
		int frontElement =  front.getData();
		front = front.getNode();
		//Bug fix P1
		if(front == null){
			rear = null;
		}
		length--;
		return frontElement;
	}
	

	public int first() throws Exception{
		if(isEmpty()){
			throw new Exception("Queue is empty. Nothing to return.");
		}
		return front.getData();
	}
	
	//get size of the stack
	public int getSize(){
		return length;
	}
	
	public boolean isEmpty(){
		return (length == 0);
	}
	
	
	public String toString(){
		String result = "";
		listNode temp = front;
		while(temp.getNode() != null){
			result = result + temp.getData() + ">";
			temp = temp.getNode();
		}
		result = result + temp.getData();
		return result;
	}

}
