package BinarySearchTree;


public class P61_ArrayToBST {

	public static void main(String[] args) {
		int[] inpArr = {1, 2, 3, 4, 5, 6, 7};
		BSTNode root = buildTree(inpArr, 0, inpArr.length-1);
		System.out.println("Tree created is as follows:");
		InOrder(root);
	}
	
	private static BSTNode buildTree(int[] inpArr, int start, int end) {
		//check added after crash occurred when array length is even 
		if(end < 0 || start >= inpArr.length)
			return null;
		//only single element left
		if(start == end)
			return new BSTNode(inpArr[start]);
		
		int mid = (start + end)/2;
		BSTNode midElem = new BSTNode(inpArr[mid]);
		midElem.right = buildTree(inpArr, mid+1, end);
		midElem.left = buildTree(inpArr, start, mid-1);
		
		return midElem;
	}

	private static void InOrder(BSTNode root) {
		if(root != null){
			InOrder(root.getLeft());
			System.out.println(root.getData());
			InOrder(root.getRight());
		}
	}

}
