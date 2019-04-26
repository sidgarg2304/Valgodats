package com.vishal.interviews.facebook.medium;

public class MaximumBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public TreeNode constructMaximumBinaryTree(int[] nums) {

		return constructMaximumBinaryTree(nums, 0, nums.length - 1);
	}

	TreeNode constructMaximumBinaryTree(int[] nums, int st, int en) {
		if(st > en){
			return null;
		}
		int max = Integer.MIN_VALUE;
		int maxIdx = -1;

		for (int i = st; i <= en; i++) {
			if (nums[i] > max) {
				nums[i] = max;
				maxIdx = i;
			}
		}
		TreeNode root = new TreeNode(nums[maxIdx]);
		root.left = constructMaximumBinaryTree(nums, st, maxIdx - 1);
		root.right = constructMaximumBinaryTree(nums, maxIdx + 1, en);

		return root;
	}

}
