import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import HelpClass.TreeNode3;

//Write a function to connect all the adjacent nodes at the same level in a binary tree. 
//Structure of the given Binary Tree node is like following.
//struct node{
//  int data;
//  struct node* left;
//  struct node* right;
//  struct node* nextRight; 
//}
//
//Initially, all the nextRight pointers point to garbage values. Your function should set these pointers to point next right for each node.

public class ConnectNodesAtTheSameLevel {

	public static void main(String[] args) {

	}

	public static void connect(TreeNode3 root) {
		Queue<TreeNode3> queue = new LinkedBlockingQueue<TreeNode3>();
		if (root == null) {
			return;
		}
		// init
		List<TreeNode3> list = new ArrayList<TreeNode3>();
		queue.add(root);
		while (!queue.isEmpty()) {
			for (Iterator<TreeNode3> iter = queue.iterator(); iter.hasNext();) {
				TreeNode3 node = iter.next();
				if (node != null) {
					list.add(node);
					if(node.getLeftChild() != null){
						queue.add(node.getLeftChild());
					}
					if(node.getRightChild() != null){
						queue.add(node.getRightChild());
					}
				}
				queue.poll();
			}
			int i = 0;
			for (; i < list.size() - 1; i++) {
				list.get(i).setNextRight(list.get(i + 1));
			}
			list.get(i).setNextRight(null);
			list.clear();
		}
	}
}
