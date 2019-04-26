package com.vishal.interviews.facebook.medium;

import java.util.LinkedList;
import java.util.Queue;

public class CheckCompletenessofaBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isCompleteTree(TreeNode root) {

		if (root == null) {
			return true;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		boolean nullSeen = false;
		while (!queue.isEmpty()) {

			TreeNode cur = queue.poll();

			if (cur == null) {
				nullSeen = true;
			} else {
				if (nullSeen) {
					return false;
				}
				queue.offer(cur.left);
				queue.offer(cur.right);
			}
		}
		return true;
	}

}
