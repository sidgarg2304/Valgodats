package com.vishal.interviews.uber.medium;

import java.util.*;

import com.vishal.interviews.util.TreeNode;

public class PrintBinaryTree {

	public static void main(String[] args) {

	}

	public List<List<String>> printTree(TreeNode root) {
		List<List<String>> res = new ArrayList<>();

		if(root == null) {
			return res;
		}
		int h = height(root);

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while (!queue.isEmpty() && h > 0) {
			int size = queue.size();

			List<String> curRes = new ArrayList<>();
			for (int s = 0; s < size; s++) {

				TreeNode p = queue.poll();
				if (p == null) {
					queue.offer(null);
					queue.offer(null);
				} else {
					queue.offer(p.left);
					queue.offer(p.right);
				}

				int len = (int) (Math.pow(2, h) - 1);
				for (int j = 0; j < len; j++) {
					if (j == len / 2) {
						curRes.add(p == null ? "" : p.val + "");
					} else {
						curRes.add("");
					}
				}

				if (s < size - 1) {
					curRes.add("");
				}
			}
			res.add(curRes);
			h--;
		}
		return res;
	}

	int height(TreeNode root) {
		if (root == null) {
			return 0;
		}

		return 1 + Math.max(height(root.left), height(root.right));
	}

}
