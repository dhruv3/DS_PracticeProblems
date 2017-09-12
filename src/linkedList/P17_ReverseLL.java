package linkedList;


public class P17_ReverseLL {

	public static void main(String[] args) {
		LinkedList sList = new LinkedList();
		createLL(sList);
		System.out.println("Linked list created is :\n" + sList.toString());
		listNode reversedsListHead = reversedLL(sList);
		System.out.println("Reversed linked list is : \n" + print(reversedsListHead));
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
		listNode prev = null, current = sList.getHead();
		while(current != null){
			listNode next = current.getNode();
			current.setNext(prev);
			prev = current;
			current = next;
		}
		return prev;
	}

	private static void createLL(LinkedList sList) {
		sList.insert(1, 0);
		sList.insert(2, 1);
		sList.insert(3, 2);
		sList.insert(4, 3);
		sList.insert(5, 4);
		sList.insert(6, 5);
	}

}
