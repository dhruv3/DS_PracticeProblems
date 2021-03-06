package BinaryTree;

public class P20_DiameterOfTree {

	static int diameter = -1;
	static BinaryTreeNode mainRoot = null; 
	
	public static void main(String[] args) {
		BinaryTreeNode root = createTree();
		mainRoot = root;
		int diameter = diameterOfTree(root);
		
		System.out.println("Tree diameter is " + diameter);
	}

	private static int diameterOfTree(BinaryTreeNode root) {
		int left, right;
		if(root == null)
			return 0;
		
		left = diameterOfTree(root.getLeft());
		right = diameterOfTree(root.getRight());
		
		if(left + right >= diameter){
			diameter = left + right;
		}
		//check added 
		//issue does not exist because we are returning diameter+1
		//diameter contains the longest path encountered
		if(root == mainRoot){
			return diameter + 1;
		}
		//modified this part
		return Math.max(left, right) + 1;
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
//		n3.setLeft(n6);
//		n3.setRight(n7);
		
		BinaryTreeNode n8 = new BinaryTreeNode(8);
		BinaryTreeNode n9 = new BinaryTreeNode(9);
		BinaryTreeNode n10 = new BinaryTreeNode(10);
		n5.setLeft(n8);
		n8.setRight(n9);
		n9.setRight(n10);
		
		BinaryTreeNode n11 = new BinaryTreeNode(11);
		BinaryTreeNode n12 = new BinaryTreeNode(12);
		n4.setLeft(n11);
		n11.setRight(n12);
		
		BinaryTreeNode root = n1;
		
		return root;
	}
	
}
