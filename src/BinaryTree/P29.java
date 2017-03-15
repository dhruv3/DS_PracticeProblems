package BinaryTree;

public class P29 {

	public static void main(String[] args) {
		int preorder[] = {1, 2, 4, 5, 3, 6, 7};
		int inorder[] = {4, 2, 5, 1, 6, 3, 7};
		BinaryTreeNode root = createTree(preorder, inorder);
		System.out.println("Tree created is:");
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

	private static BinaryTreeNode createTree(int[] preorder, int[] inorder) {
		if(preorder.length == 0  || preorder.length != inorder.length)
			return null;
		return buildBT(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
	}

	private static BinaryTreeNode buildBT(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
		if(preStart > preEnd || inStart > inEnd)
			return null;
		int data = preorder[preStart];
		BinaryTreeNode curr = new BinaryTreeNode(data);
		int offset = inStart;
		for(; offset <= inEnd; offset++){
			if(inorder[offset] == data)
				break;
		}
		
		curr.setLeft(buildBT(preorder, preStart + 1, preStart + offset - inStart, inorder, inStart, offset - 1));
		
		curr.setRight(buildBT(preorder, preStart + 1, preStart + offset - inStart + 1, inorder, offset + 1, inEnd));
		
		return curr;
	}
	
}
