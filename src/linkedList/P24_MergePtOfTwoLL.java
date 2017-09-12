package linkedList;


public class P24_MergePtOfTwoLL {

	public static void main(String[] args) {
		LinkedList sList = new LinkedList();
		LinkedList dList = new LinkedList();
		createLL(sList, dList);
		findMergingPoint(sList, dList);
	}
	
	private static void findMergingPoint(LinkedList sList, LinkedList dList) {
		listNode sTemp = sList.getHead();
		listNode dTemp = dList.getHead();
		int sListLen =  sList.listLength();
		int dListLen =  dList.listLength();
		int ctr = 0;
		//add offset to the pointer in the longer list
		if(sListLen >= dListLen){
			while(ctr != (sListLen - dListLen)){
				sTemp = sTemp.getNode();
				ctr++;
			}
		}
		else{
			while(ctr != (dListLen - sListLen)){
				dTemp = dTemp.getNode();
				ctr++;
			}
		}
		//add offset to the pointer in the longer list
		
		//move in both list till we reach the common node
		while(dTemp != sTemp){
			sTemp = sTemp.getNode();
			dTemp = dTemp.getNode();
		}
		//move in both list till we reach the common node
		
		System.out.println("Merging node is " + sTemp.getData());
	}

	private static void createLL(LinkedList sList, LinkedList dList) {
		sList.insert(1, 0);
		sList.insert(2, 1);
		sList.insert(3, 2);
		sList.insert(4, 3);
		sList.insert(5, 4);
		sList.insert(6, 5);
		
		dList.insert(1, 0);
		dList.insert(2, 1);
		dList.insert(3, 2);
		
		listNode c1 = new listNode(8);
		sList.insertAtEnd(c1);
		dList.insertAtEnd(c1);
		
		listNode c2 = new listNode(9);
		sList.insertAtEnd(c2);
		dList.insertAtEnd(c2);
		
		listNode c3 = new listNode(10);
		sList.insertAtEnd(c3);
		dList.insertAtEnd(c3);
		
		listNode c4 = new listNode(11);
		sList.insertAtEnd(c4);
		dList.insertAtEnd(c4);
	}

}
