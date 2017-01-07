package linkedList;


public class P32 {

	public static void main(String[] args) {
		LinkedList sList = new LinkedList();
		LinkedList dList = new LinkedList();
		createLL(sList, dList);
		mergeLLs(sList, dList);
	}
	
	private static void mergeLLs(LinkedList sList, LinkedList dList) {
		listNode sTemp = sList.getHead();
		listNode dTemp = dList.getHead();
		
		LinkedList mergedList = new LinkedList();
		int sData, dData;
		
		while(sTemp != null || dTemp != null){
			listNode mTemp = new listNode();
			sData = (sTemp != null) ? sTemp.getData() : Integer.MAX_VALUE;
			dData = (dTemp != null) ? dTemp.getData() : Integer.MAX_VALUE;
			
			if(sData >= dData){
				mTemp.setData(dData);
				dTemp = dTemp.getNode();
			}
			else{
				mTemp.setData(sData);
				sTemp = sTemp.getNode();
			}
			mergedList.insertAtEnd(mTemp);
		}
		
		System.out.println("Merged list is " + mergedList.toString());
	}

	private static void createLL(LinkedList sList, LinkedList dList) {
		sList.insert(1, 0);
		sList.insert(3, 1);
		sList.insert(4, 2);
		sList.insert(8, 3);
		sList.insert(18, 4);
		sList.insert(21, 5);
		System.out.println("First Sorted list is " + sList.toString());
		
		dList.insert(2, 0);
		dList.insert(6, 1);
		dList.insert(14, 2);
		dList.insert(19, 3);
		System.out.println("Second Sorted list is " + dList.toString());
	}

}
