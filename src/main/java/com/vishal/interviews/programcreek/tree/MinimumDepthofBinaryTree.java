package com.vishal.interviews.programcreek.tree;

import java.util.*;

import com.vishal.interviews.util.TreeNode;

public class MinimumDepthofBinaryTree {

	public static void main(String[] args) {

	}

	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		Queue<Integer> depth = new LinkedList<>();
		depth.offer(1);

		while (!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			int curDepth = depth.poll();

			if (cur.left == null && cur.right == null) {
				return curDepth;
			}

			if (cur.left != null) {
				queue.offer(cur.left);
				depth.offer(curDepth + 1);
			}

			if (cur.right != null) {
				queue.offer(cur.right);
				depth.offer(curDepth + 1);
			}
		}

		return 0;

	}

}
