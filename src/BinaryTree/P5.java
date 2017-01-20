package BinaryTree;

import java.util.Scanner;

public class P5 {

	private static int inputElement = Integer.MIN_VALUE;

	public static void main(String[] args) {
		BinaryTreeNode root = createTree();
		//take input
		Scanner in  = new Scanner(System.in);
		System.out.println("Enter node you want to insert");
		inputElement = in.nextInt();
		//print initial state
		System.out.println("Initial state of the tree:");
		PreOrder(root);
		//add node
		PreOrderInsertNode(root);
		//print tree
		System.out.println("After Insertion:");
		PreOrder(root);
		
	}

	//to print the tree
	private static void PreOrder(BinaryTreeNode root) {
		if(root != null){
			System.out.println(root.getData());
			PreOrder(root.getLeft());
			PreOrder(root.getRight());
		}
	}
	
	//check if left empty > insert node
	//check if right empty > insert node
	//return added so as so prevent further insertion
	private static Boolean PreOrderInsertNode(BinaryTreeNode root) {
		if(root.getLeft() == null){
			BinaryTreeNode temp = new BinaryTreeNode(inputElement);
			root.setLeft(temp);
			return true;
		}
		else if(root.getRight() == null){
			BinaryTreeNode temp = new BinaryTreeNode(inputElement);
			root.setRight(temp);
			return true;
		}
		else{
			return (PreOrderInsertNode(root.getLeft()) ||	PreOrderInsertNode(root.getRight()) );
		}
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
