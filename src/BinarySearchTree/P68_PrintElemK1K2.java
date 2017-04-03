package BinarySearchTree;

public class P68_PrintElemK1K2 {
	static int k1 = 10, k2 = 12;
	
	public static void main(String[] args) {
		BSTNode root = createTree();
		printElem(root);
	}
	
	//do inorder traversal and decrement k
	//print when k if they lie within k1 and k2
	private static void printElem(BSTNode root) {
		if(root != null){
			printElem(root.getLeft());

			if(root.getData() > k1 && root.getData() < k2)
				System.out.println(root.getData());
			
			printElem(root.getRight());
		}
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
