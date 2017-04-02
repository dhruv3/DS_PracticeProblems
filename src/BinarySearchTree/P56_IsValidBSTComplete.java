package BinarySearchTree;

//time complexity: n^2
//space complexity: n
public class P56_IsValidBSTComplete {

	public static void main(String[] args) {
		BSTNode root = createTree();
		//incomplete solution as it checks only current node
		//BSTNode root = createErrorTree();
		
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
		//no child node
		if(root.getLeft() == null && root.getRight() == null)
			return true;
		//compare root value against max value in left subtree
		if(root.getLeft() != null){
			BSTNode leftMax = findMax(root.getLeft());
			if(root.getData() < leftMax.getData()){
				return false;
			}
		}
		//compare root value against min value in right subtree
		if(root.getRight() != null){
			BSTNode rightMin = findMin(root.getRight());
			if(root.getData() > rightMin.getData()){
				return false;
			}
		}
		//do this process for left and right child
		//if we get false value, we return it
		if(!isValidBST(root.getLeft()) || !isValidBST(root.getRight())){
			return false;
		}
		
		return true;
	}

	//helper functions
	private static BSTNode findMax(BSTNode root) {
		if(root == null)
			return root;
		
		if(root.getRight() == null)
			return root;
		else
			return findMax(root.getRight());
	}
	
	private static BSTNode findMin(BSTNode root) {
		if(root == null)
			return root;
		
		if(root.getLeft() == null)
			return root;
		else
			return findMin(root.getLeft());
	}
	//helper functions
	
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
