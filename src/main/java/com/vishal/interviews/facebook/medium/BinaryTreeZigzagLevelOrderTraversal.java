package com.vishal.interviews.facebook.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		
		if(root == null) {
			return res;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int reverse = 0;

		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> level = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				TreeNode cur = queue.poll();

				if (cur.left != null) {
					queue.offer(cur.left);
				}

				if (cur.right != null) {
					queue.offer(cur.right);
				}

				if (reverse == 1) {
					level.add(0, cur.val);
				} else {
					level.add(cur.val);
				}				
			}
			reverse ^= 1;
			res.add(level);
		}

		return res;
	}

}
