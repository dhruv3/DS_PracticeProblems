package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class P9 {

	private static int inputElement = Integer.MIN_VALUE;

	public static void main(String[] args) {
		BinaryTreeNode root = createTree();
		//print initial state
		System.out.println("Initial state of the tree:");
		PreOrder(root);
		//reverse and print
		ReverseLevelOrder(root);
	}

	//to print the tree
	private static void PreOrder(BinaryTreeNode root) {
		if(root != null){
			System.out.println(root.getData());
			PreOrder(root.getLeft());
			PreOrder(root.getRight());
		}
	}
	
	private static void ReverseLevelOrder(BinaryTreeNode root) {
		Queue<BinaryTreeNode> myLine = new LinkedList<BinaryTreeNode>();
		//stack to store nodes
		Stack<Integer> st = new Stack<Integer>();
		//do bfs and add into stack
		myLine.add(root);
		while(!myLine.isEmpty()){
			BinaryTreeNode temp = myLine.poll();
			st.add(temp.getData());
			if(temp.getLeft() != null){
				myLine.add(temp.getLeft());
			}
			if(temp.getRight() != null){
				myLine.add(temp.getRight());
			}
		}
		//function to print stack
		printStack(st);
	}
	
	//print output
	private static void printStack(Stack<Integer> st) {
		System.out.println("After Insertion:");
		while(!st.isEmpty()){
			int temp = st.pop();
			System.out.println(temp);
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
