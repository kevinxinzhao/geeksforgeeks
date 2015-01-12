package HelpClass;

public class TreeNode {
	public int value;
	public TreeNode leftChild;
	public TreeNode rightChild;
	
	public TreeNode(int value) {
		super();
		this.value = value;
		this.leftChild = null;
		this.rightChild = null;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public TreeNode getLeftChild() {
		return leftChild;
	}
	public void setLeftChild(TreeNode leftChild) {
		this.leftChild = leftChild;
	}
	public TreeNode getRightChild() {
		return rightChild;
	}
	public void setRightChild(TreeNode rightChild) {
		this.rightChild = rightChild;
	}
}