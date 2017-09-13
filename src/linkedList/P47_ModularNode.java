package linkedList;

import java.util.Scanner;

public class P47_ModularNode {

	public static void main(String[] args) {
		LinkedList sList = new LinkedList();
		createLL(sList);
		Scanner scanner  =  new Scanner(System.in);
		System.out.println("Mention the number for which you want to the last node");
		int userInput =  Integer.parseInt(scanner.nextLine());
		findModularNode(sList, userInput);
	}
	

	private static void findModularNode(LinkedList sList, int userInput) {
		listNode temp = sList.getHead();
		listNode storeNode = null;
		int counter = 1; 
		while(temp != null){
			//store node only if its divisible by user input
			if(counter%userInput == 0){
				storeNode = temp;
			}
			temp = temp.getNode();
			counter++;
		}
		//check added in case we don't find modular number 
		if(storeNode == null){
			System.out.println("List is too short or the user input is too big! Run again.");
		}else{
			System.out.println("Modular node is " + storeNode.getData());
		}
	}


	private static void createLL(LinkedList sList) {
		sList.insert(1, 0);
		sList.insert(2, 1);
		sList.insert(3, 2);
		sList.insert(4, 3);
		sList.insert(5, 4);
		sList.insert(6, 5);
		sList.insert(7, 6);
	}

}
