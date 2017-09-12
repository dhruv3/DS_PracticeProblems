package linkedList;


public class P34_ReverseHalfLL {

	public static void main(String[] args) {
		LinkedList sList = new LinkedList();
		createLL(sList);
		System.out.println("Linked list created is :\n" + sList.toString());
		listNode reversedsListHead = reversedLL(sList);
		System.out.println("Reversed pair linked list is : \n" + print(reversedsListHead));
	}
	
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

	private static listNode reversedLL(LinkedList sList) {
		//returnNode created so as to save the node which shall become the new head
		listNode current = sList.getHead(), returnNode = sList.getHead().getNode();
		while(current.getNode() != null){
			//spl treatment for end case (where total nodes are even)
			if(current.getNode().getNode() == null){
				current.getNode().setNext(current);
				current.setNext(null);
			}
			//spl treatment for end case (where total nodes are odd)
			else if(current.getNode().getNode().getNode() == null){
				listNode next = current.getNode().getNode();
				current.getNode().setNext(current);
				current.setNext(next);
				current = current.getNode();
			}
			else{
				listNode next = current.getNode().getNode();
				listNode nextPlusOne = current.getNode().getNode().getNode();
				current.getNode().setNext(current);
				current.setNext(nextPlusOne);
				current = next;
			}
		}
		return returnNode;
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
