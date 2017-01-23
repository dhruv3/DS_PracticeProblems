package BinaryTree;

import java.util.Stack;

public class P10 {

	public static void main(String[] args) {
		BinaryTreeNode root = createTree();
		//print initial state
		System.out.println("Initial state of the tree:");
		PreOrder(root);
		
		int heightTree = maxDepthRecursive(root);
		System.out.println("Height of the tree by recursive method is: " + heightTree);
		
		heightTree = PostOrderTreeHeight(root);
		System.out.println("Height of the tree using a Stack is: " + heightTree);
	}

	//recursive method
	private static int maxDepthRecursive(BinaryTreeNode root) {
		if(root == null)
			return 0;
		int leftDepth = maxDepthRecursive(root.getLeft());
		int rightDepth = maxDepthRecursive(root.getRight());
		//+1 added so as to include the element at the present level
		return (leftDepth > rightDepth) ? leftDepth + 1 : rightDepth + 1;
	}

	//Height using a Stack
	private static int PostOrderTreeHeight(BinaryTreeNode root) {
		BinaryTreeNode current = root;
		Stack<BinaryTreeNode> st = new Stack<BinaryTreeNode>();
		int heightTree = 0;
		//loop 
		while(current != null || !st.isEmpty()){
			//if current is not empty; add it to stack and update current to left node
			if(current != null){
				st.push(current);
				current = current.getLeft();
			}
			else{
				//get right node of topmost node in the stack
				BinaryTreeNode temp = ((BinaryTreeNode) st.peek()).getRight();
				//if right node does NOT exist
				if(temp == null){
					//right node is NULL-->We are done with LEFT and RIGHT side of topmost stack node
					//pop and print topmost stack element
					temp = (BinaryTreeNode) st.pop();
					
					//Commenting print line // System.out.println(temp.getData());
					
					//check if popped node is same as the NEW topmost node right neighbor
					//if it is => we have completed with both left & right subtrees
					//pop topmost node
					while(!st.isEmpty() && temp == ((BinaryTreeNode) st.peek()).getRight()){
						temp = (BinaryTreeNode) st.pop();
						
						//Commenting print line // System.out.println(temp.getData());
					}
				}
				else{
					//set current to temp; This will insert the right element into the stack.
					current = temp;
				}
			}
			
			if(st.size() > heightTree){
				heightTree = st.size();
			}
		}
		return heightTree;
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
