package linkedList;

public class P10 {

	public static void main(String[] args) {
		LinkedList sList = new LinkedList();
		cycleCreation(sList);
		System.out.println("List node with cycle created");
		confirmCycle(sList);
	}

	private static void confirmCycle(LinkedList sList) {
		listNode slowPtr, fastPtr = sList.getHead();
		slowPtr = fastPtr;
		
		//confirm that loop exists
		boolean runOnce = true;
		while(slowPtr != fastPtr || runOnce){
			runOnce = false;
			slowPtr = slowPtr.getNode();
			fastPtr = fastPtr.getNode().getNode();
		}
		System.out.println("Pointers converge on node with data " + slowPtr.getData());
		
		//https://www.youtube.com/watch?v=apIw0Opq5nk Explains why it works
		slowPtr = sList.getHead();
		while(slowPtr != fastPtr){
			slowPtr = slowPtr.getNode();
			fastPtr = fastPtr.getNode();
		}
		System.out.println("Start node of the loop is " + slowPtr.getData());
		
		//length of the loop
		listNode startNodeOfLoop = slowPtr;
		int len = 0;
		while(slowPtr != startNodeOfLoop || len == 0){
			len++;
			slowPtr = slowPtr.getNode(); 
		}
		System.out.println("Length of the loop is " + len);
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
