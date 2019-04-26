package com.vishal.interviews.facebook.easy;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthofBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int minDepth(TreeNode root) {

		if (root == null) {
			return 0;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int depth = 1;
		while(!queue.isEmpty()) {
			int s = queue.size();
			for(int i = 0; i< s; i++) {
				TreeNode cur = queue.poll();
				if(cur.left == null && cur.right == null) {
					return depth;
				}
				
				if(cur.left != null) {
					queue.offer(cur.left);
				}
				
				if(cur.right != null) {
					queue.offer(cur.right);
				}
			}
			depth++;
		}
		
		return 0;
		
	}

}
