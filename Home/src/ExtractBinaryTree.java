import HelpClass.TreeNode;

//Given a Binary Tree, extract all leaves of it in a Doubly Linked List (DLL). 
//Note that the DLL need to be created in-place. 
//Assume that the node structure of DLL and Binary Tree is same, only the meaning of left and right pointers are different. 
//In DLL, left means previous pointer and right means next pointer. 
public class ExtractBinaryTree {

	public static void main(String[] args) {
		TreeNode root = createTree();
		TreeNode headOfDoublyLinkedList = null;
		TreeNode newroot = extractBinaryTreeToDoublyLinkedList(root, headOfDoublyLinkedList);
		System.out.println("Stop!");
	}

	public static TreeNode extractBinaryTreeToDoublyLinkedList(TreeNode root, TreeNode headOfLinkedList) {
		if (root == null) {
			return null;
		}
		if (root.getLeftChild() == null && root.getRightChild() == null) {
			root.rightChild = headOfLinkedList;
			if (headOfLinkedList != null) {
				headOfLinkedList.leftChild = root;
			}
			headOfLinkedList = root;
			return null;
		}
		root.setRightChild(extractBinaryTreeToDoublyLinkedList(root.getRightChild(), headOfLinkedList));
		root.setLeftChild(extractBinaryTreeToDoublyLinkedList(root.getLeftChild(), headOfLinkedList));
		return root;
	}

	public static TreeNode createTree() {
		TreeNode root = new TreeNode(1);
		root.leftChild = new TreeNode(2);
		root.rightChild = new TreeNode(3);

		root.leftChild.leftChild = new TreeNode(4);
		root.leftChild.rightChild = new TreeNode(5);
		root.leftChild.leftChild.leftChild = new TreeNode(7);
		root.leftChild.leftChild.rightChild = new TreeNode(8);

		root.rightChild.rightChild = new TreeNode(6);
		root.rightChild.rightChild.leftChild = new TreeNode(9);
		root.rightChild.rightChild.rightChild = new TreeNode(10);

		return root;
	}
}
