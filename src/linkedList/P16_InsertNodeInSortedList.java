package linkedList;

import java.util.Scanner;

public class P16_InsertNodeInSortedList {

	public static void main(String[] args) {
		LinkedList sList = new LinkedList();
		createList(sList);
		System.out.println(sList.toString());
		Scanner scanner  =  new Scanner(System.in);
		System.out.println("Mention the node you want to insert");
		int userInput =  Integer.parseInt(scanner.nextLine());
		listNode temp =  sList.getHead();
		int pos = 0;
		boolean insertAtEnd = true;
		while(temp.getNode() != null){
			if(temp.getData() > userInput){
				sList.insert(userInput, pos);
				System.out.println(sList.toString());
				return;
			}
			temp = temp.getNode();
			pos++;
		}
		//handle the case when user input is greater than highest data
		if(temp.getData() <= userInput){
			sList.insertAtEnd(new listNode(userInput));
		}
		else{
			sList.insert(userInput, pos);
		}
		System.out.println(sList.toString());
	}

	private static void createList(LinkedList sList) {
		sList.insert(1, 0);
		sList.insert(3, 1);
		sList.insert(4, 2);
		sList.insert(7, 3);
		sList.insert(11, 4);
		sList.insert(15, 5);
		sList.insert(18, 6);
		sList.insert(20, 7);
		sList.insert(23, 8);
		sList.insert(30, 9);
	}

}
