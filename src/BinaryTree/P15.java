package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P15 {

	public static void main(String[] args) {
		BinaryTreeNode root = createTree();
		//print initial state
		System.out.println("Initial state of the tree:");
		PreOrder(root);
		//get input from  user
		Scanner inp = new Scanner(System.in);
		System.out.println("Enter node you want to remove");
		int userIn = inp.nextInt();
		//call function to remove node
		deleteNode(root, userIn);
		//print final state
		System.out.println("Initial state of the tree:");
		PreOrder(root);
	}

	private static void deleteNode(BinaryTreeNode root, int userIn) {
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.add(root);
		
		BinaryTreeNode deepestNode = null;
		BinaryTreeNode nodeDelete = null;
		//traverse till you get the deepest node
		while(!q.isEmpty()){
			deepestNode = q.poll();
			//check if present node and node to be deleted have same value or not
			//if same and then we have found our target node
			if(deepestNode.getData() == userIn){
				nodeDelete = deepestNode;
			}

			if(deepestNode.getLeft() != null){
				q.add(deepestNode.getLeft());
			}
			if(deepestNode.getRight() != null){
				q.add(deepestNode.getRight());
			}
		}
		//set deletion node value to that of deepest  node
		nodeDelete.setData(deepestNode.getData());
		//ISSUE: how to remove this node??
		deepestNode.setData(Integer.MAX_VALUE);
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
