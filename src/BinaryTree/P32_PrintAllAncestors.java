package BinaryTree;

public class P32_PrintAllAncestors {

	public static void main(String[] args) {
		BinaryTreeNode root = createTree();
		printAncestor(root, 2);
	}
	
	private static Boolean printAncestor(BinaryTreeNode root, int target) {
		//check if we found the desired node or not
		if(root.getData() == target){
			System.out.println(target);
			return true;
		}
		else{
			Boolean temp = false;
			if(root.getLeft() != null){
				temp =  printAncestor(root.getLeft(), target);
			}
			//temp check is present so that we don't waste time checking again
			if(root.getRight() != null && temp != true){
				temp =  printAncestor(root.getRight(), target);
			}
			//print the current node
			if(temp){
				System.out.println(root.getData());
				return true;
			}
			else{
				return false;
			}
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
