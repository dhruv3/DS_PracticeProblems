package linkedList;


public class P28_MidOfLL {

	public static void main(String[] args) {
		LinkedList sList = new LinkedList();
		createLL(sList);
		findMidNode(sList);
	}
	
	private static void findMidNode(LinkedList sList) {
		listNode temp = sList.getHead();
		listNode dTemp = temp;
		while(dTemp.getNode() != null){
			temp =  temp.getNode();
			if(dTemp.getNode().getNode() != null)
				dTemp =  dTemp.getNode().getNode();
			else{
				dTemp =  dTemp.getNode();
			}
		}
		System.out.println("Middle element is " + temp.getData());
	}

	private static void createLL(LinkedList sList) {
		sList.insert(1, 0);
		sList.insert(2, 1);
		sList.insert(3, 2);
		sList.insert(4, 3);
		sList.insert(5, 4);
		sList.insert(6, 5);
		sList.insert(7, 6);
		sList.insert(16, 7);
		sList.insert(17, 8);
		sList.insert(18, 9);
	}

}
