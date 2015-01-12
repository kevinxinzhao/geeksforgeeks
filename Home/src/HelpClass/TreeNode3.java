package HelpClass;

public class TreeNode3 {
	private int value;
	private TreeNode3 leftChild;
	private TreeNode3 rightChild;
	private TreeNode3 nextRight;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public TreeNode3 getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(TreeNode3 leftChild) {
		this.leftChild = leftChild;
	}

	public TreeNode3 getRightChild() {
		return rightChild;
	}

	public void setRightChild(TreeNode3 rightChild) {
		this.rightChild = rightChild;
	}

	public TreeNode3 getNextRight() {
		return nextRight;
	}

	public void setNextRight(TreeNode3 nextRight) {
		this.nextRight = nextRight;
	}
}
