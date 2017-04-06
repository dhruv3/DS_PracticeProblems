package BinaryTree;

import java.util.HashMap;

public class P35_VerticalSums {

	public static void main(String[] args) {
		BinaryTreeNode root = createTree();
		verticalSum(root);
	}
	
	
	private static void verticalSum(BinaryTreeNode root) {
		HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
		vSum(hash, root, 0);
		
		for(int k: hash.keySet()){
			System.out.println(k + " : " + hash.get(k));
		}
	}


	private static void vSum(HashMap<Integer, Integer> hash, BinaryTreeNode root, int i) {
		if(root.getLeft() != null)
			vSum(hash, root.getLeft(), i - 1);
		if(root.getRight() != null)
			vSum(hash, root.getRight(), i + 1);
		
		int data = 0;
		//key is Horizontal distance
		//value is the value of node
		if(hash.containsKey(i))
			data = (int) hash.get(i);
		
		hash.put(i, root.getData() + data);
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
