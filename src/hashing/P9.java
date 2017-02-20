package hashing;

import linkedList.LinkedList;
import linkedList.listNode;

//Check if LinkedList has a cycle
public class P9 {

	public static void main(String[] args) {
		LinkedList sList = new LinkedList();
		cycleCreation(sList);
		
		Boolean ans = confirmCycle(sList);
		if(ans)
			System.out.println("Cycle exists");
		else
			System.out.println("No cycle");		
	}

	private static Boolean confirmCycle(LinkedList sList) {
		//new hashtable to store node and corresponding value
		Map<listNode, Integer> llTable = new Map<>();
		listNode temp = sList.getHead();
		//keep adding node and if node is already present implies a cycle
		while(temp != null){
			if(llTable.get(temp) != null){
				return true;
			}
			else{
				int data = temp.getData();
				llTable.add(temp, data);
			}
			temp = temp.getNode();
		}
		return false;
	}

	private static void cycleCreation(LinkedList sList) {
		sList.insert(1, 0);
		sList.insert(2, 1);
		sList.insert(3, 2);
		sList.insert(4, 3);
		sList.insert(5, 4);
		sList.insert(6, 5);
		sList.insert(7, 6);
		sList.insert(8, 7);
		sList.insert(9, 8);
		listNode temp = sList.getHead();
		listNode cycleNode = null;
		while(temp.getNode() != null){
			if(temp.getData() == 4){
				cycleNode = temp;
			}
			temp = temp.getNode();
		}
		temp.setNext(cycleNode);
	}

}
