package BinarySearchTree;

public class P55_IsValidBST {

	public static void main(String[] args) {
		//BSTNode root = createTree();
		
		BSTNode root = createErrorTree();
		
		Boolean ans = isValidBST(root);
		if(ans == true){
			System.out.println("Given tree is a valid bst");
		}
		else{
			System.out.println("Given tree is an invalid bst");
		}
	}
	
	private static BSTNode createErrorTree() {
		BSTNode n1 = new BSTNode(6);
		BSTNode n2 = new BSTNode(2);
		BSTNode n3 = new BSTNode(8);
		n1.setLeft(n2);
		n1.setRight(n3);
		BSTNode n4 = new BSTNode(1);
		BSTNode n5 = new BSTNode(9);
		n2.setLeft(n4);
		n2.setRight(n5);

		BSTNode root = n1;
		return root;
	}

	private static Boolean isValidBST(BSTNode root) {
		if(root == null)
			return false;
		
		if(root.getLeft() != null){
			if(root.getData() > root.getLeft().getData()){
				if(isValidBST(root.getLeft()) == false)
					return false;
			}
			else
				return false;
		}
		
		if(root.getRight() != null){
			if(root.getData() < root.getRight().getData()){
				if(isValidBST(root.getRight()) == false)
					return false;
			}
			else
				return false;
		}
		
		return true;
	}

	private static BSTNode createTree() {
		BSTNode n1 = new BSTNode(10);
		BSTNode n2 = new BSTNode(8);
		BSTNode n3 = new BSTNode(12);
		n1.setLeft(n2);
		n1.setRight(n3);
		BSTNode n4 = new BSTNode(4);
		BSTNode n5 = new BSTNode(9);
		n2.setLeft(n4);
		n2.setRight(n5);
		BSTNode n6 = new BSTNode(20);
		BSTNode n7 = new BSTNode(13);
		n3.setLeft(n6);
		n3.setRight(n7);
		
		BSTNode root = n1;
		
		return root;
	}

}
