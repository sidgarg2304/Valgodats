package com.vishal.interviews.programcreek.tree;

import com.vishal.interviews.util.TreeNode;

public class LargestBSTSubtree {

	public static void main(String[] args) {

	}

	int max = 0;

	public int largestBSTSubtree(TreeNode root) {

		if (root == null) {
			return 0;
		}

		process(root);

		return max;
	}

	Result process(TreeNode root) {

		if (root == null) {
			return new Result(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
		}

		Result left = process(root.left);
		Result right = process(root.right);

		if (left.size == -1 || right.size == -1 || root.val <= left.higher || root.val >= right.lower) {
			return new Result(-1, 0, 0);
		}

		int size = left.size + right.size + 1;
		max = Math.max(max, size);

		return new Result(size, Math.min(left.lower, root.val), Math.max(right.higher, root.val));
	}

}

class Result {
	int size;
	int lower;
	int higher;

	Result(int size, int lower, int higher) {
		this.size = size;
		this.lower = lower;
		this.higher = higher;
	}
}
