package com.vishal.interviews.leetcodereremaining.medium;

import java.util.*;
import com.vishal.interviews.util.TreeNode;

public class FindBottomLeftTreeValue {

	public static void main(String[] args) {

	}

	public int findBottomLeftValue(TreeNode root) {

		if (root == null) {
			return -1;
		}
		int res = root.val;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			res = cur.val;
			if (cur.right != null) {
				queue.offer(cur.right);
			}

			if (cur.left != null) {
				queue.offer(cur.left);
			}
		}

		return res;
	}

}
