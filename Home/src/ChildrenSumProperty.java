import HelpClass.TreeNode;


//Check for Children Sum Property in a Binary Tree.
//
//Given a binary tree, write a function that returns true if the tree satisfies below property.
//
//For every node, data value must be equal to sum of data values in left and right children. 
//Consider data value as 0 for NULL children. Below tree is an example

public class ChildrenSumProperty {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		
		root.setLeftChild(new TreeNode(8));
		root.setRightChild(new TreeNode(2));
		
		root.getLeftChild().setLeftChild(new TreeNode(5));
		root.getLeftChild().setRightChild(new TreeNode(3));
		
		root.getRightChild().setLeftChild(new TreeNode(2));
		
		if(checkChildrenSumProperty(root) == 1){
			System.out.print("Satisfy");
		}else{
			System.out.print("Not Satisfy");
		}
	}
	
	public static int checkChildrenSumProperty(TreeNode node){
		if(node == null || (node.getLeftChild() == null && node.getRightChild() == null)){
			return 1;
		}
		int leftChildValue = 0;
		if(node.getLeftChild() != null){
			leftChildValue = node.getLeftChild().getValue();
		}
		
		int rightChildValue = 0;
		if(node.getRightChild() != null){
			rightChildValue = node.getRightChild().getValue();
		}
		
		if(node.getValue() == (leftChildValue + rightChildValue) &&
				checkChildrenSumProperty(node.getLeftChild()) == 1 &&
				checkChildrenSumProperty(node.getRightChild()) == 1){
			return 1;
		}else{
			return -1;
		}
	}
}
