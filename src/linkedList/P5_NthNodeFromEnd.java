package linkedList;

import java.util.Scanner;

public class P5_NthNodeFromEnd {

	public static void main(String[] args) {
		LinkedList sList = new LinkedList();
		sList.insert(1, 0);
		sList.insert(2, 1);
		sList.insert(3, 2);
		sList.insert(4, 3);
		sList.insert(5, 4);
		sList.insert(6, 5);
		Scanner scanner  =  new Scanner(System.in);
		System.out.println("Find the nth element from end. Enter value of n:");
		int n =  Integer.parseInt(scanner.nextLine());
		int len =  sList.listLength();
		if(n > len){
			System.out.println("Incorrect value of n entered");
			return;
		}
		listNode p1 =  sList.getHead();
		listNode p2 =  sList.getHead();
		int counter = 0;
		while(counter < n){
			counter++;
			p2 = p2.getNode();
		}
		if(p2.getNode() == null){
			System.out.println("Value: " + p1.getData()); 
		}
		else{
			while(p2.getNode() != null){
				p2 = p2.getNode();
				p1 = p1.getNode();
			}
			System.out.println("Value: " + p1.getData());
		}
		
	}

}
