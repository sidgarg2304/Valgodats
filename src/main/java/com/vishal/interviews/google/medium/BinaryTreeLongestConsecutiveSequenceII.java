package com.vishal.interviews.google.medium;

public class BinaryTreeLongestConsecutiveSequenceII {

	public static void main(String[] args) {

	}

	int maxVal;

	public int longestConsecutive(TreeNode root) {

		longestConsecutivePath(root);
		return maxVal;

	}

	public int[] longestConsecutivePath(TreeNode root) {
		if (root == null) {
			return new int[] { 0, 0 };
		}

		int dcr = 1;
		int incr = 1;

		if (root.left != null) {
			int[] l = longestConsecutivePath(root.left);

			if (root.val - root.left.val == 1) {
				dcr = l[1] + 1;
			}

			if (root.val - root.left.val == -1) {
				incr = l[0] + 1;
			}
		}

		if (root.right != null) {
			int[] r = longestConsecutivePath(root.right);

			if (root.val - root.right.val == 1) {
				dcr = Math.max(r[1] + 1, dcr);
			}

			if (root.val - root.right.val == -1) {
				incr = Math.max(r[0] + 1, incr);
			}
		}

		maxVal = Math.max(maxVal, incr + dcr - 1);

		return new int[] { incr, dcr };

	}

}
