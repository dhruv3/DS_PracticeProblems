package BinaryTree;

public class P38 {

	public static void main(String[] args) {
		int[] inpArr = {2, 0, 2, 0, 0};
		BinaryTreeNode root = buildTree(inpArr, 0);
		System.out.println("Tree created is:");
		PreOrder(root);
	}
	
	private static BinaryTreeNode buildTree(int[] inpArr, int i) {
		if(inpArr.length == i)
			return null;
		//create new node and initialize it with value in array
		BinaryTreeNode temp = new BinaryTreeNode(inpArr[i]);
		temp.setLeft(null);
		temp.setRight(null);
		//if its leaf node then return the node
		if(inpArr[i] == 0)
			return temp;
		//increment i and build tree
		//first we'll add the left child then right
		//we know each node has either 0 or 2 children
		i = i + 1;
		temp.setLeft(buildTree(inpArr, i));
		i = i + 1;
		temp.setRight(buildTree(inpArr, i));

		return temp;
	}

	//to print the tree
	private static void PreOrder(BinaryTreeNode root) {
		if(root != null){
			System.out.println(root.getData());
			PreOrder(root.getLeft());
			PreOrder(root.getRight());
		}
	}
}
