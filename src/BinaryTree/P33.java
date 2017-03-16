package BinaryTree;

public class P33 {
	//Main Tutorial: http://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
	//Video Tutorial: https://www.youtube.com/watch?v=13m9ZCB8gjw
	public static void main(String[] args) {
		BinaryTreeNode root = createTree();
		BinaryTreeNode lca = LCA(root, 2, 7);
		System.out.println("Least Common Ancestor is " + lca.getData());
	}
	
	
	
	private static BinaryTreeNode LCA(BinaryTreeNode root, int i, int j) {
		BinaryTreeNode left, right;
		if(root == null)
			return null;
		//we get root matching i or j 
		if(root.getData() == i || root.getData() == j)
			return root;
		
		left = LCA(root.getLeft(), i, j);
		right = LCA(root.getRight(), i, j);
		//this is where i and j separate
		if(left != null && right != null)
			return root;
		else{
			//return whatever is not null
			return (left != null ? left : right);
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
		
		BinaryTreeNode root = n1;
		
		return root;
	}
	
}
