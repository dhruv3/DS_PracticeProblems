package BinarySearchTree;

//time complexity: n
//space complexity: 1
public class P58_IsValidBSTEfficient {

	public static void main(String[] args) {
		BSTNode root = createTree();
		//incomplete solution as it checks only current node
		//BSTNode root = createErrorTree();
		
		Boolean ans = InOrder(root);
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
	
	//use inorder traversal and use prev pointer 
	//compare prev pointer with current node
	static BSTNode prev = null;
	
	private static Boolean InOrder(BSTNode root) {
		if(root != null){
			if(!InOrder(root.getLeft()))
				return false;
			
			if(prev != null && prev.getData() > root.getData())
				return false;
			prev = root;
			
			if(!InOrder(root.getRight()))
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
		BSTNode n6 = new BSTNode(11);
		BSTNode n7 = new BSTNode(13);
		n3.setLeft(n6);
		n3.setRight(n7);
		
		BSTNode root = n1;
		
		return root;
	}

}
