package com.vishal.interviews.programcreek.tree;

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

	public TreeNode sortedArrayToBST(int[] nums, int start, int end) {

		if (start > end) {
			return null;
		}

		int m = start + (end - start) / 2;

		TreeNode root = new TreeNode(nums[m]);

		root.left = sortedArrayToBST(nums, start, m - 1);
		root.right = sortedArrayToBST(nums, m + 1, end);

		return root;
	}

}
