package linkedList;

import java.util.Scanner;

public class P59 {

	public static void main(String[] args) {
		LinkedList sList = new LinkedList();
		createLL(sList);
		System.out.println("Intial list " + sList.toString());
		Scanner scanner  =  new Scanner(System.in);
		System.out.println("Enter your pivot value");
		int userInput =  Integer.parseInt(scanner.nextLine());
		updateLL(sList, userInput);
	}
	

	private static void updateLL(LinkedList sList, int userInput) {
		listNode temp = sList.getHead();
		listNode prev = temp;
		int len = sList.listLength();
		while(len > 0)
		{
			len--;
			listNode nextNode = temp.getNode();
			if(temp.getData() >= userInput){
				//remove node and insert at end
				listNode newNode  = new listNode(temp.getData());
				sList.insertAtEnd(newNode);
				//case to handle if first element is greater than pivot element
				if(prev == temp){
					temp = sList.removeFromStart();
					prev = temp;
				}
				else{
					prev.setNext(temp.getNode());
					temp.setNext(null);
					temp = nextNode;
				}
			}
			else{
				//continue traversing the list
				prev = temp;
				temp = nextNode;
			}
		}
		System.out.println("Final list " + sList.toString());
	}
	
	private static void createLL(LinkedList sList) {
		sList.insert(1, 0);
		sList.insert(21, 1);
		sList.insert(3, 2);
		sList.insert(40, 3);
		sList.insert(52, 4);
		sList.insert(6, 5);
		sList.insert(71, 6);
	}

}
