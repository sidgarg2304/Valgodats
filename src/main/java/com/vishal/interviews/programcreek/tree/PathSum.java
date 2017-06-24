package com.vishal.interviews.programcreek.tree;

import java.util.*;

import com.vishal.interviews.util.TreeNode;

public class PathSum {

	public static void main(String[] args) {

	}

	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null)
			return false;

		Queue<TreeNode> queue = new LinkedList<>();
		Queue<Integer> sums = new LinkedList<>();

		queue.offer(root);
		sums.offer(root.val);

		while (!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			int curSum = sums.poll();

			if (cur.left == null && cur.right == null) {
				if (curSum == sum) {
					return true;
				}
			}

			if (cur.left != null) {
				queue.offer(cur.left);
				sums.offer(curSum + cur.left.val);
			}

			if (cur.right != null) {
				queue.offer(cur.right);
				sums.offer(curSum + cur.right.val);
			}
		}

		return false;

	}

}
