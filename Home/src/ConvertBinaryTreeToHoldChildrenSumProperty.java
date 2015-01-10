import HelpClass.TreeNode;

//Question: Given an arbitrary binary tree, convert it to a binary tree that holds Children Sum Property. 
//You can only increment data values in any node (You cannot change structure of tree and cannot decrement value of any node). 

public class ConvertBinaryTreeToHoldChildrenSumProperty {

	public static void main(String[] args) {

	}

	public static void convert(TreeNode root) {
		if (root == null || (root.getLeftChild() == null && root.getRightChild() == null)) {
			return;
		}
		convert(root.getLeftChild());
		convert(root.getRightChild());
		int leftChildValue = 0;
		if (root.getLeftChild() != null) {
			leftChildValue = root.getLeftChild().getValue();
		}
		int rightChildValue = 0;
		if (root.getRightChild() != null) {
			rightChildValue = root.getRightChild().getValue();
		}
		int diff = root.getValue() - (leftChildValue + rightChildValue);

		if (diff > 0) {
			increment(root, diff);
		}
		if (diff < 0) {
			root.setValue(leftChildValue + rightChildValue);
		}
	}

	public static void increment(TreeNode node, int diff) {
		if (node.getLeftChild() != null) {
			node.getLeftChild().setValue(node.getLeftChild().getValue() + diff);
			increment(node.getLeftChild(), diff);
		} else if (node.getRightChild() != null) {
			node.getRightChild().setValue(node.getRightChild().getValue() + diff);
			increment(node.getRightChild(), diff);
		}
	}

	public static void postOrderTraverse(TreeNode node) {
		if (node == null) {
			return;
		}
		postOrderTraverse(node.getLeftChild());
		postOrderTraverse(node.getRightChild());
		System.out.println(node.getValue());
	}
}
