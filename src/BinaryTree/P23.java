package BinaryTree;

public class P23 {

	public static void main(String[] args) {
		BinaryTreeNode root = createTree();
		int sum = calculateSum(root);
		System.out.println("Sum of the tree is " + sum);
	}


	private static int calculateSum(BinaryTreeNode root) {
		if(root == null)
			return 0;
		return (root.getData() + calculateSum(root.getLeft()) + + calculateSum(root.getRight()));
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
		
		BinaryTreeNode root = n1;
		
		return root;
	}
	
}
