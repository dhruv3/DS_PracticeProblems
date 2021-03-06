package BinaryTree;

public class P13_MinDepthBinaryTree {

	public static void main(String[] args) {
		BinaryTreeNode root = createTree();
		//print initial state
		System.out.println("Initial state of the tree:");
		PreOrder(root);
		
		int heightTree = minDepthRecursive(root);
		System.out.println("Min depth of the tree by recursive method is: " + heightTree);
	}

	//recursive method
	//Video tutorial: https://www.youtube.com/watch?v=hmWhJyz5kqc
	private static int minDepthRecursive(BinaryTreeNode root) {
		//trivial case
		if(root == null)
			return 0;
		
		//check if its a leaf node
		if(root.getLeft() == null && root.getRight() == null)
			return 1;
		
		//Integer.Max_Value is used as we don't want to consider the null child as depth
		int leftDepth = root.getLeft() != null ? minDepthRecursive(root.getLeft()) : Integer.MAX_VALUE;
		int rightDepth = root.getRight() != null ? minDepthRecursive(root.getRight()) : Integer.MAX_VALUE;
		
		//+1 added so as to include the element at the present level
		return 1 + Math.min(leftDepth , rightDepth);
	}

	
	//to print the tree
	private static void PreOrder(BinaryTreeNode root) {
		if(root != null){
			System.out.println(root.getData());
			PreOrder(root.getLeft());
			PreOrder(root.getRight());
		}
	}
	
	private static BinaryTreeNode createTree() {
		BinaryTreeNode n1 = new BinaryTreeNode(1);
		BinaryTreeNode n2 = new BinaryTreeNode(2);
		BinaryTreeNode n3 = new BinaryTreeNode(3);
		n1.setLeft(n2);
		n1.setRight(n3);
		BinaryTreeNode n4 = new BinaryTreeNode(4);
		BinaryTreeNode n5 = new BinaryTreeNode(5);
		n2.setLeft(n4);
		n2.setRight(n5);
		BinaryTreeNode n6 = new BinaryTreeNode(6);
		BinaryTreeNode n7 = new BinaryTreeNode(7);
		n3.setLeft(n6);
		n3.setRight(n7);
		
		BinaryTreeNode n8 = new BinaryTreeNode(8);
		BinaryTreeNode n9 = new BinaryTreeNode(9);
		n6.setLeft(n8);
		n7.setLeft(n9);
		
		BinaryTreeNode root = n1;
		
		return root;
	}
}
