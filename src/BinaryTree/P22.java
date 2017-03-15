package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class P22 {

	public static void main(String[] args) {
		BinaryTreeNode root = createTree();

		int maxSum = maxLevelSum(root);
		
		System.out.println("Max sum at a level is " + maxSum);
	}

	//do bfs 
	//add a delimiter node so as to check when a level ends
	private static int maxLevelSum(BinaryTreeNode root) {
		int maxSum = root.getData();
		int currSum = 0;
		BinaryTreeNode delimitNode = new BinaryTreeNode(Integer.MIN_VALUE);
		Queue<BinaryTreeNode> myQ = new LinkedList<BinaryTreeNode>();
		
		myQ.add(root);
		myQ.add(delimitNode);
		
		while(!myQ.isEmpty()){
			BinaryTreeNode tempNode  = myQ.poll();
			//compare level sum with max sum
			if(tempNode.equals(delimitNode)){
				if(currSum > maxSum)
					maxSum = currSum;
				currSum = 0;
				continue;
			}
			
			currSum += tempNode.getData();
			
			if(tempNode.getLeft() != null){
				myQ.add(tempNode.getLeft());				
			}
			if(tempNode.getRight() != null){
				myQ.add(tempNode.getRight());				
			}
			//when delimiter is on top it means we have finished a level
			//whatever is now present in queue belongs to lower level 
			if(myQ.peek().equals(delimitNode)){
				myQ.add(delimitNode);								
			}
		}
		return maxSum;
	}


	private static BinaryTreeNode createTree() {
		BinaryTreeNode n1 = new BinaryTreeNode(1);
		BinaryTreeNode n2 = new BinaryTreeNode(2);
		BinaryTreeNode n3 = new BinaryTreeNode(3);
		n1.setLeft(n2);
		n1.setRight(n3);
		BinaryTreeNode n4 = new BinaryTreeNode(-4);
		BinaryTreeNode n5 = new BinaryTreeNode(-5);
		n2.setLeft(n4);
		n2.setRight(n5);
		BinaryTreeNode n6 = new BinaryTreeNode(-6);
		BinaryTreeNode n7 = new BinaryTreeNode(7);
		n3.setLeft(n6);
		n3.setRight(n7);
		
		BinaryTreeNode root = n1;
		
		return root;
	}
	
}
