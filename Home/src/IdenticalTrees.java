import HelpClass.TreeNode;

//Two trees are identical when they have same data and arrangement of data is also same.
//
//To identify if two trees are identical, we need to traverse both trees simultaneously, 
//and while traversing we need to compare data and children of the trees. 

public class IdenticalTrees {

	public static void main(String[] args) {
		TreeNode tree1 = new TreeNode(1);
		TreeNode tree2 = new TreeNode(1);
		
		tree1.setLeftChild(new TreeNode(2));
		tree1.setRightChild(new TreeNode(4));
		
		tree1.getLeftChild().setLeftChild(new TreeNode(3));
		
		tree2.setLeftChild(new TreeNode(2));
		tree2.setRightChild(new TreeNode(4));
		
		if(compareTwoTrees(tree1, tree2) == 1){
			System.out.println("identical tree");
		}else{
			System.out.println("different tree");
		}
	}

	public static int compareTwoTrees(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null) {
			return 1;
		}
		if (root1 != null && root2 != null) {
			if (root1.getValue() == root2.getValue()
					&& compareTwoTrees(root1.getLeftChild(), root2.getLeftChild()) == 1
					&& compareTwoTrees(root1.getRightChild(), root2.getRightChild()) == 1) {
				return 1;
			}
		}
		return -1;
	}
}
