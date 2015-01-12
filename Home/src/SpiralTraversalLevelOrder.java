import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

import HelpClass.TreeNode;

//Write a function to print spiral order traversal of a tree. 
public class SpiralTraversalLevelOrder {

	public static void main(String[] args) {
		TreeNode root = createTree();
		printLevelOrderInSpiralSequenece(root);
	}

	public static void printLevelOrderInSpiralSequenece(TreeNode node) {
		if (node == null) {
			return;
		}
		Queue<TreeNode> q = new LinkedBlockingQueue<TreeNode>();
		q.add(node);

		int flip = 1;
		while (!q.isEmpty()) {
			int size = q.size();
			Stack<TreeNode> stack = new Stack<TreeNode>();
			while (size > 0) {
				TreeNode n = q.poll();
				if (flip == 1) {
					stack.add(n);
				} else {
					System.out.print(n.value + " ");
				}

				if (n.leftChild != null) {
					q.add(n.leftChild);
				}
				if (n.rightChild != null) {
					q.add(n.rightChild);
				}
				size--;
			}
			flip *= -1;
			while(!stack.isEmpty()){
				System.out.print(stack.pop().value + " ");
			}
		}
	}
	
	public static TreeNode createTree() {
		TreeNode root = new TreeNode(1);
		root.leftChild = new TreeNode(2);
		root.rightChild = new TreeNode(3);

		root.leftChild.leftChild = new TreeNode(7);
		root.leftChild.rightChild = new TreeNode(6);

		root.rightChild.leftChild = new TreeNode(5);
		root.rightChild.rightChild = new TreeNode(4);

		return root;
	}
}
