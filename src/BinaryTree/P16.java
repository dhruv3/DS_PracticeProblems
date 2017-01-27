package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class P16 {

	public static void main(String[] args) {
		BinaryTreeNode root = createTree();
		//print initial state
		System.out.println("Initial state of the tree:");
		PreOrder(root);
		
		int leaves = totalLeaves(root);
		System.out.println("Total number of leaves are: " + leaves);
	}

	private static int totalLeaves(BinaryTreeNode root) {
		//trivial case
		if(root == null)
			return 0;
		
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.add(root);
		
		BinaryTreeNode temp = null;
		int counter = 0;
		
		while(!q.isEmpty()){
			temp = q.poll();
			
			if(temp.getLeft() == null && temp.getRight() == null){
				counter++;
			}
			
			if(temp.getRight() != null){
				q.add(temp.getRight());
			}
			
			if(temp.getLeft() != null){
				q.add(temp.getLeft());
			}
		}
		
		return counter;
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
