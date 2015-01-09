//Two trees are identical when they have same data and arrangement of data is also same.
//
//To identify if two trees are identical, we need to traverse both trees simultaneously, 
//and while traversing we need to compare data and children of the trees. 

public class IdenticalTrees {

	public static void main(String[] args) {
		TreeNode tree1 = new TreeNode();
		TreeNode tree2 = new TreeNode();
		tree1.value = 1;
		tree2.value = 1;
		
		tree1.leftChild = new TreeNode();
		tree1.leftChild.value = 2;
		tree1.rightChild = new TreeNode();
		tree1.rightChild.value = 4;
		
		tree1.leftChild.leftChild = new TreeNode();
		tree1.leftChild.leftChild.value = 3;
		
		tree2.leftChild = new TreeNode();
		tree2.leftChild.value = 2;
		tree2.rightChild = new TreeNode();
		tree2.rightChild.value = 4;
		
		if(compareTwoTrees(tree1, tree2) == 1){
			System.out.println("identical tree");
		}else{
			System.out.println("different tree");
		}
	}

	public static class TreeNode {
		int value;
		TreeNode leftChild;
		TreeNode rightChild;
	}

	public static int compareTwoTrees(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null) {
			return 1;
		}
		if (root1 != null && root2 != null) {
			if (root1.value == root2.value
					&& compareTwoTrees(root1.leftChild, root2.leftChild) == 1
					&& compareTwoTrees(root1.rightChild, root2.rightChild) == 1) {
				return 1;
			}
		}
		return -1;
	}
}
