package com.vishal.interviews.facebook.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class BinaryTreeLevelOrderTraversalII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<List<Integer>> levelOrderBottom(TreeNode root) {

		List<List<Integer>> res = new ArrayList<>();

		if(root == null) {
			return res;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> level = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				TreeNode cur = queue.poll();
				level.add(cur.val);

				if (cur.left != null) {
					queue.offer(cur.left);
				}

				if (cur.right != null) {
					queue.offer(cur.right);
				}
			}
			res.add(0, level);
		}
		return res;
	}

}
