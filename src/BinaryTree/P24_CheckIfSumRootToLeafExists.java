package BinaryTree;

import java.util.Scanner;

public class P24_CheckIfSumRootToLeafExists {

	public static void main(String[] args) {
		BinaryTreeNode root = createTree();
		//get value from user
		System.out.println("Enter sum you want to check");
		Scanner inp = new Scanner(System.in);
		int sum = inp.nextInt();
		
		Boolean ans = checkSum(root, sum);
		
		if(ans){
			System.out.println("Sum exists");
		}
		else{
			System.out.println("Sum does not exist");
		}
	}


	private static Boolean checkSum(BinaryTreeNode root, int sum) {
		if(root == null)
			return false;
		//remove data and check
		sum = sum - root.getData();
		if(root.getLeft() == null && root.getRight() == null && sum == 0)
			return true;
		else{
			return (checkSum(root.getLeft(), sum) || checkSum(root.getRight(), sum));
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
