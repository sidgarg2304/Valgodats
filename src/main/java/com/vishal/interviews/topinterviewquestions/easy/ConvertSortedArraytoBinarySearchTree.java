package com.vishal.interviews.topinterviewquestions.easy;

import com.vishal.interviews.util.TreeNode;

public class ConvertSortedArraytoBinarySearchTree {

	public static void main(String[] args) {

	}

	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;
		}
		return sortedArrayToBST(nums, 0, nums.length - 1);
	}

	public TreeNode sortedArrayToBST(int[] nums, int st, int en) {
		if (st < en) {
			return null;
		}

		int m = st + (en - st)/2;
		TreeNode root = new TreeNode(nums[m]);

		root.left = sortedArrayToBST(nums, st, m - 1);
		root.right = sortedArrayToBST(nums, m + 1, en);

		return root;
	}

}
