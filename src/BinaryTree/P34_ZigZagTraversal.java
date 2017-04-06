package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class P34_ZigZagTraversal {

	public static void main(String[] args) {
		BinaryTreeNode root = createTree();
		zigZagTraversal(root);
	}
	
	
	private static void zigZagTraversal(BinaryTreeNode root) {
		int dirCtr = 0;
		Queue<BinaryTreeNode> myQ = new LinkedList<BinaryTreeNode>();
		Stack<BinaryTreeNode> mySt = new Stack<BinaryTreeNode>();
		
		myQ.add(root);
		
		while(!myQ.isEmpty()){
			BinaryTreeNode temp = myQ.poll();
			System.out.println(temp.getData());
			//LC then RC
			if(dirCtr%2 == 0){
				if(temp.getLeft() != null){
					mySt.push(temp.getLeft());
				}
				if(temp.getRight() != null){
					mySt.push(temp.getRight());
				}
			}
			//RC then LC
			else{
				if(temp.getRight() != null){
					mySt.push(temp.getRight());
				}
				if(temp.getLeft() != null){
					mySt.push(temp.getLeft());
				}
			}
			//queue is empty(a level is over)
			//stack not empty(all the children have been added to the stack)
			if(myQ.isEmpty() && !mySt.isEmpty()){
				//increment directional counter so as to change direction 
				dirCtr++;
				//till stack gets empty add content to queue
				while(!mySt.isEmpty()){
					myQ.add(mySt.pop());
				}
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
