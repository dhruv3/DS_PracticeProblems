package graphs;

public class LinkedList {
	
	private int length = 0;
	listNode head;
	
	public LinkedList(){
		length = 0;
	}
	
	public synchronized listNode getHead(){
		return head;
	}
	
	public synchronized void insertAtStart(listNode node){
		node.setNext(head);
		head = node;
		length++;
		//http://stackoverflow.com/questions/2411270/when-should-i-use-this-in-a-class
	}
	
	public synchronized void insertAtEnd(listNode node){
		if(head == null){
			head = node; 
		}
		else{
			listNode temp = head;
			while(temp.getNode() != null){
				temp = temp.getNode();
			}
			temp.setNext(node);
			node.setNext(null);
		}
		length++;
	}
	
	public void insert(int data, int position){
		listNode temp = new listNode(data);
		if(position <= 0){
			insertAtStart(temp);
		}
		else if(position >= length){
			insertAtEnd(temp);
		}
		else{
			int counter = 0;
			listNode currentNode = head;
			while(counter != (position-1)){
				counter++;
				currentNode = currentNode.getNode();
			}
			temp.setNext(currentNode.getNode());
			currentNode.setNext(temp);
		}
		length++;
	}
	
	//remove head and then return the new head
	public synchronized listNode removeFromStart(){
		listNode temp = head;
		head = temp.getNode();
		temp.setNext(null);
		length--;
		return head;
	}
	
	//remove last node and the return new tail
	public synchronized listNode removeFromEnd(){
		listNode prevTemp = head, temp = head;
		while(temp.getNode() != null){
			prevTemp = temp;
			temp = temp.getNode();
		}
		prevTemp.setNext(null);
		length--;
		return prevTemp;
	}
	
	//remove a node matching the specified node from the list
	public synchronized void removeMatched(listNode node){
		listNode prevTemp = head, temp = head;
		if(temp.equals(node)){
			removeFromStart();
		}
		else{
			while(!temp.equals(node)){
				prevTemp = temp;
				temp = temp.getNode();
			}
			prevTemp.setNext(temp.getNode());
			temp.setNext(null);
		}
	}
	
	//remove the value from given position (position start at 0)
	public void remove(int position){
		int temp = 0;
		listNode tempNode = head, prevNode = head;
		if(position <= 0){
			removeFromStart();
		}
		else if(position >= length){
			removeFromEnd();
		}
		else{
			while(temp != position){
				temp++;
				prevNode = tempNode;
				tempNode = tempNode.getNode();
			}
			prevNode.setNext(tempNode.getNode());
			tempNode.setNext(null);
			length--;
		}
	}
	
	public String toString(){
		String result = "";
		listNode temp = head;
		while(temp.getNode() != null){
			result = result + temp.getData() + ">";
			temp = temp.getNode();
		}
		result = result + temp.getData();
		return result;
	}
	
	public int getPosition(int data){
		int position = 0;
		listNode temp = head;
		if(temp.getData() == data)
			return 0;
		else{
			while(temp.getNode() != null){
				if(temp.getData() == data){
					return position;
				}
				else{
					temp = temp.getNode();
					position++;
				}
			}
		}
		return position;
	}
	
	public int listLength(listNode head){
		int counter = 0;
		listNode temp = head;
		while(temp != null){
			counter++;
			temp = temp.getNode();
		}
		return counter;
//		Case below fails when head is a null node. To fix it we have used current node instead of next node to increment the pointer
//		int counter = 1;
//		listNode temp = head;
//		while(temp.getNode() != null){
//			counter++;
//			temp = temp.getNode();
//		}
//		return counter;
	}
}
