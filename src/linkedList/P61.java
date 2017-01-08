package linkedList;

public class P61 {

	public static void main(String[] args) {
		LinkedList sList = new LinkedList();
		createLL(sList);
		System.out.println("List before duplicates removal " + sList.toString());
		removeDuplicateNodes(sList);
	}
	

	private static void removeDuplicateNodes(LinkedList sList) {
		listNode tempOut = sList.getHead();
		while(tempOut != null){ 
			listNode prev = tempOut; //created in case we need to delete a node; so we are saving a previous node
			listNode tempInner = tempOut.getNode();
			while(tempInner != null){
				//if we find a duplicate node
				if(tempOut.getData() == tempInner.getData()){
					prev.setNext(tempInner.getNode());
					tempInner.setNext(null);
					tempInner = prev.getNode();
				}
				else{
					prev = tempInner;
					tempInner = tempInner.getNode();
				}
			}
			tempOut = tempOut.getNode();
		}
		System.out.println("List after duplicates removal " + sList.toString());
	}


	private static void createLL(LinkedList sList) {
		sList.insert(1, 0);
		sList.insert(2, 1);
		sList.insert(1, 2);
		sList.insert(2, 3);
		sList.insert(5, 4);
		sList.insert(2, 5);
		sList.insert(5, 6);
		sList.insert(5, 7);
	}

}
