package linkedList;

import java.util.Scanner;

public class P57_RotateListByK {

	public static void main(String[] args) {
		LinkedList sList = new LinkedList();
		createLL(sList);
		System.out.println("Intial list " + sList.toString());
		Scanner scanner  =  new Scanner(System.in);
		System.out.println("How many elements would you like to rotate?");
		int userInput =  Integer.parseInt(scanner.nextLine());
		rotateLL(sList, userInput);
	}
	

	private static void rotateLL(LinkedList sList, int userInput) {
		//take two pointers
		listNode tempStart = sList.getHead();
		listNode tempEnd = sList.getHead();
		int counter = userInput; 
		
		//move one pointer by based on user input
		while(counter > 0){
			counter--;
			tempEnd = tempEnd.getNode();
			if(tempEnd == null){
				System.out.println("Number entered is too large compared to list. Terminating.");
				return;
			}
		}
		//move both pointers together till farther one reaches the end
		while(tempEnd.getNode() != null){
			tempEnd = tempEnd.getNode();
			tempStart = tempStart.getNode();
		}
		//add final node to head and create new tail
		listNode newHead = tempStart.getNode();
		tempEnd.setNext(sList.getHead());
		tempStart.setNext(null);
		System.out.println("Final list " + print(newHead));
	}

	//as the head is not updated we had to create this print function to fix it
	public static String print(listNode head){
		String result = "";
		listNode temp  = head;
		while(temp.getNode() != null){
			result = result + temp.getData() + ">";
			temp = temp.getNode();
		}
		result = result + temp.getData();
		return result;
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
