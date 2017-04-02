package BinarySearchTree;

public class P64_kthElement {
	static int k = 3;
	
	public static void main(String[] args) {
		BSTNode root = createTree();
		getKthElem(root);
	}
	
	//do inorder traversal and decrement k
	//print when k equals zero and 
	private static void getKthElem(BSTNode root) {
		if(k < 0){
			return;
		}
		if(root != null){
			getKthElem(root.getLeft());
			k--;
			System.out.println("element " + root.getData());
			if(k == 0){
				System.out.println("kth element in BST is " + root.getData());
				return;
			}
			
			getKthElem(root.getRight());
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
