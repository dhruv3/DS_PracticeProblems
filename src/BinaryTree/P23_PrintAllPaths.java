package BinaryTree;

public class P23_PrintAllPaths {

	public static void main(String[] args) {
		BinaryTreeNode root = createTree();
		int[] path = new int[256];
		printPath(root, path, 0);
	}


	private static void printPath(BinaryTreeNode root, int[] path, int pathLength) {
		if(root == null)
			return;
		
		//add this node to path array
		path[pathLength] = root.getData();
		pathLength++;
		
		//check if leaf > then print the path
		if(root.getLeft() == null && root.getRight() == null){
			printPath(path, pathLength);
		}
		else{
			printPath(root.getLeft(), path, pathLength);
			printPath(root.getRight(), path, pathLength);
		}
	}

	private static void printPath(int[] path, int pathLength) {
		System.out.println("Path starts");
		for(int i = 0; i < pathLength; i++){
			System.out.println(path[i]);
		}
		System.out.println("Path ends");
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
