package BinaryTree;

import java.util.Scanner;

public class P3 {

	private static int inputElement = Integer.MIN_VALUE;

	public static void main(String[] args) {
		BinaryTreeNode root = createTree();
		//take input
		Scanner in  = new Scanner(System.in);
		System.out.println("Enter the input that needs to be searched");
		inputElement = in.nextInt();
		
		String answer = PreOrderMaxNode(root) ? "Number exists" : "Number is not present";
		System.out.println(answer);
	}

	private static Boolean PreOrderMaxNode(BinaryTreeNode root) {
		if(root != null){
			if(root.getData() == inputElement){
				return true;
			}
			//return the answer from subtrees
			return (PreOrderMaxNode(root.getLeft()) || PreOrderMaxNode(root.getRight()) );
		}
		return false;
	}
	
	private static BinaryTreeNode createTree() {
		BinaryTreeNode n1 = new BinaryTreeNode(11);
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
